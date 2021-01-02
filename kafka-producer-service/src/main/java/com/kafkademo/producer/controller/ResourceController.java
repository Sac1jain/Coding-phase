package com.kafkademo.producer.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkademo.producer.config.KafkaAdmin;
import com.kafkademo.producer.model.Payload;
import com.kafkademo.producer.model.ServiceDetails;
import com.kafkademo.producer.service.ServiceMapper;

@RestController
@RequestMapping("/publish")
public class ResourceController {
	
	@Autowired
	private  KafkaTemplate<String, Object> kafkaTemplate;
	@Autowired
	private KafkaAdmin kafkaAdmin;
	@Autowired
	public ServiceMapper serviceMapper;
	@Autowired
	public ServiceDetails appHistoryService;
	
	@PostMapping("/appHistoryService")
	public Payload publishMessage(){

		final String TOPIC = appHistoryService.getServiceName();

		Boolean isTopicAlreadyExist=kafkaAdmin.createTopic(TOPIC, 1, 1, new HashMap<String,String>());
		
		Payload dataToPublish = serviceMapper.parseRequestToJson2(appHistoryService);
		
		kafkaTemplate.send(TOPIC,dataToPublish);
		
		return dataToPublish;
	}
	
}
