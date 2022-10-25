package com.dmtwng.metrics.metricstutorial.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter")
public class CounterController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CounterController.class);

    private Counter requestsCounterTest;

    public CounterController(MeterRegistry meterRegistry) {
        this.requestsCounterTest = Counter.builder("requests.count.test")
                .description("Custom metric, counting number of call to the endpoint counter/count")
                .register(meterRegistry);
    }

    @GetMapping("/count")
    public String count() {
        requestsCounterTest.increment();
        LOGGER.info("Counter has been incremented");
        return "Current count: %.0f".formatted(requestsCounterTest.count());
    }

}
