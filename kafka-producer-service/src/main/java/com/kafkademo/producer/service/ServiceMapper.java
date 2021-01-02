package com.kafkademo.producer.service;

import java.sql.Timestamp;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.kafkademo.producer.model.Payload;
import com.kafkademo.producer.model.ResponseDetailsDO;
import com.kafkademo.producer.model.ServiceDetails;

@Service
public class ServiceMapper {

	public Payload parseRequestToJson2(ServiceDetails service) {
		Payload response = null;
		ResponseDetailsDO data;
		try {
			String URL = service.getUrl();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.set("encryptedToken", service.getEncryptedToken());
			headers.set("content-type", service.getContentType());
			HttpEntity<ResponseDetailsDO> entity = new HttpEntity<ResponseDetailsDO>(new ResponseDetailsDO(), headers);
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(URL).queryParam("role", "2");
			data = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.POST, entity, ResponseDetailsDO.class).getBody();
			Timestamp publishTime =new Timestamp(System.currentTimeMillis());
			response = new Payload(service.getServiceName(),data.getResponseType(),publishTime,data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

}
