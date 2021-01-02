package com.kafkademo.producer.model;

public class ServiceDetails {
	
	private String serviceName;
	private String url;
	private String contentType;
	private String methodType;
	private String encryptedToken;
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getMethodType() {
		return methodType;
	}
	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}
	public String getEncryptedToken() {
		return encryptedToken;
	}
	public void setEncryptedToken(String encryptedToken) {
		this.encryptedToken = encryptedToken;
	}
	

}
