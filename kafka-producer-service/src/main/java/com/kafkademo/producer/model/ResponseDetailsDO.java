package com.kafkademo.producer.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class ResponseDetailsDO{
	private String responseType;
	private Object data;
	private Integer statusCode;
	private String status;
	
	public String getResponseType() {
		return responseType;
	}
	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ResponseDetailsDO [responseType=" + responseType + ", data=" + data + ", statusCode=" + statusCode
				+ ", status=" + status + "]";
	}
}
