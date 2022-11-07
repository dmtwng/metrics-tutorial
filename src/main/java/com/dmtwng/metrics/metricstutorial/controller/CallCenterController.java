package com.dmtwng.metrics.metricstutorial.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.HashSet;
import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/call-center")
public class CallCenterController {

    private Set<String> operators = new HashSet<>();

    public CallCenterController(MeterRegistry meterRegistry) {
        // Register gauge to get size from collection
        Gauge.builder("callcenter.operators.number", operators::size)
                .strongReference(true)
                .description("Custom metric, get number of operators in call center")
                .register(meterRegistry);
    }

    @GetMapping("/register")
    public String registerOperator(@RequestParam String id) {
        operators.add(id);
        return "Operators count: %d".formatted(operators.size());
    }

    @GetMapping("/unregister")
    public String unregisterOperator(@RequestParam String id) {
        operators.remove(id);
        return "Operators count: %d".formatted(operators.size());
    }

    @GetMapping("/operators")
    public Set<String> operatorsList() {
        return operators;
    }
}
