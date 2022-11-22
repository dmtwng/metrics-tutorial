package com.dmtwng.metrics.metricstutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LogsProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogsProducer.class);

    @Scheduled(fixedDelay = 5000)
    public void logInfoMessage() {
        LOGGER.info("Scheduled info message.");
    }

    @Scheduled(fixedDelay = 33500)
    public void logWarningMessage() {
        LOGGER.warn("Scheduled warning message.");
    }
}
