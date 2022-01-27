package com.example.demo.model;

import java.util.List;

import com.example.demo.Enums.ACCESS_MODIFIER;

import lombok.Getter;

public class ModelClass {
	ACCESS_MODIFIER accessModifier;
	String className;
	List<Method> methods;

	public ACCESS_MODIFIER getAccessModifier() {
		return accessModifier;
	}

	public void setAccessModifier(ACCESS_MODIFIER accessModifier) {
		this.accessModifier = accessModifier;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<Method> getMethods() {
		return methods;
	}

	public void setMethods(List<Method> methods) {
		this.methods = methods;
	}

}
