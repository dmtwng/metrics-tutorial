package com.dmtwng.metrics.metricstutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MetricsTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetricsTutorialApplication.class, args);
	}

}
