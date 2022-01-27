package com.example.demo.model;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@ToString
public class BuildVO {
	List<ModelClass> modelClass;

	public List<ModelClass> getModelClass() {
		return modelClass;
	}

	public void setModelClass(List<ModelClass> modelClass) {
		this.modelClass = modelClass;
	}
}
