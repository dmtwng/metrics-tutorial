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

    private Counter requestsCounter;

    public CounterController(MeterRegistry meterRegistry) {
        this.requestsCounter = meterRegistry.counter("requests.count.test");
    }

    @GetMapping("/count")
    public void count() {
        requestsCounter.increment();
        LOGGER.info("Counter has been incremented");
    }

}
