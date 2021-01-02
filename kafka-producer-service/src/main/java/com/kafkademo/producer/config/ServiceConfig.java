package com.kafkademo.producer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.kafkademo.producer.model.ServiceDetails;

@Configuration
@PropertySource("classpath:service-details.properties")
public class ServiceConfig {
	
	@Bean
	@ConfigurationProperties(prefix="app-history")
	public ServiceDetails appHistoryService(){
		return new ServiceDetails();
		
	}
	
	

}
