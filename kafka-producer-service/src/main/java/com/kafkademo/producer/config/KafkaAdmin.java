package com.kafkademo.producer.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.ListTopicsOptions;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:service-details.properties")
public class KafkaAdmin {

	@Value("${KafkaBootStrapServers}")
	String kafkaBootstrapServer;

	public Boolean createTopic(String topic, int partitions, int replication, Map<String, String> configs) {

		Properties config = new Properties();
		config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServer);

		AdminClient admin = AdminClient.create(config);
		Boolean isTopicAlreadyExist = checkListOfTopics(topic);
		if (!isTopicAlreadyExist)
			admin.createTopics(Arrays.asList(new NewTopic(topic, partitions, (short) replication).configs(configs)));
	return isTopicAlreadyExist;
	}

	public Boolean checkListOfTopics(String topic) {
		try {
			Properties props = new Properties();
			props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServer);
			AdminClient client = AdminClient.create(props);
			ListTopicsOptions options = new ListTopicsOptions();
			options.listInternal(true); 
			ListTopicsResult topics = client.listTopics(options);
			Set<String> currentTopicList = topics.names().get();
			if (currentTopicList.contains(topic))
				return true;
			else
				return false;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return false;
	}
}
