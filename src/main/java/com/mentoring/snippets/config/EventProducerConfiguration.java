package com.mentoring.snippets.config;

import com.mentoring.snippets.service.ProducerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class EventProducerConfiguration {
	 @Bean
	 public ProducerService producerService() {
	   return new ProducerService();
	 }
}