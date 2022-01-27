package com.example.demo.model;

import lombok.Getter;

public class RequestType {
	String mappingType;
	String path;
	String paramName;
	public String getMappingType() {
		return mappingType;
	}
	public void setMappingType(String mappingType) {
		this.mappingType = mappingType;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	
	
}
