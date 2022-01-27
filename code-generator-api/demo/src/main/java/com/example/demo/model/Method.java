package com.example.demo.model;

import com.example.demo.Enums.ACCESS_MODIFIER;

import lombok.Getter;

@Getter
public class Method {
	RequestType requestType ;
	ACCESS_MODIFIER accessModifier;
	String methodName;
	public RequestType getRequestType() {
		return requestType;
	}
	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}
	public ACCESS_MODIFIER getAccessModifier() {
		return accessModifier;
	}
	public void setAccessModifier(ACCESS_MODIFIER accessModifier) {
		this.accessModifier = accessModifier;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
}
