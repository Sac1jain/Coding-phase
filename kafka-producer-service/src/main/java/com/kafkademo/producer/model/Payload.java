package com.kafkademo.producer.model;

import java.sql.Timestamp;

public class Payload {

	private String serviceName;
	private String apiName;
	private Timestamp publishedOn;
	private Object serviceData;
	public Payload() {}
	public Payload(String serviceName, String apiName, Timestamp timestamp, Object serviceData) {
		super();
		this.serviceName = serviceName;
		this.apiName = apiName;
		this.publishedOn = timestamp;
		this.serviceData = serviceData;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	public Timestamp getPublishedOn() {
		return publishedOn;
	}
	public void setPublishedOn(Timestamp publishedOn) {
		this.publishedOn = publishedOn;
	}
	public Object getServiceData() {
		return serviceData;
	}
	public void setServiceData(Object serviceData) {
		this.serviceData = serviceData;
	}
	
	
}
