package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.lang.model.element.Modifier;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Enums.ACCESS_MODIFIER;
import com.example.demo.model.BuildVO;
import com.example.demo.model.Method;
import com.example.demo.model.ModelClass;
import com.example.demo.model.RequestType;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.MethodSpec.Builder;

public class BuildCode {

	public JavaFile process(ModelClass modelClass) {
		TypeSpec typeSpec = processClass(modelClass);
		return JavaFile.builder("com.javapoet.person", typeSpec).indent("    ").build();
	}

	private TypeSpec processClass(ModelClass modelClass) {

		List<MethodSpec> methodSpecs = new ArrayList<>();
		for (Method method : modelClass.getMethods())
			methodSpecs.add(processMethod(method));

		com.squareup.javapoet.TypeSpec.Builder classBuilder = TypeSpec.classBuilder(modelClass.getClassName());
		if (modelClass.getAccessModifier().equals(ACCESS_MODIFIER.PUBLIC)) {
			classBuilder.addModifiers(Modifier.PUBLIC);
		} else if (modelClass.getAccessModifier().equals(ACCESS_MODIFIER.PRIVATE)) {
			classBuilder.addModifiers(Modifier.PRIVATE);
		}
		for (MethodSpec methodSpec : methodSpecs)
			classBuilder.addMethod(methodSpec);

		return classBuilder.build();

	}

	private MethodSpec processMethod(Method method) {
		RequestType requestType;

		Builder methodBuilder = MethodSpec.methodBuilder(method.getMethodName());
		if (method.getAccessModifier().equals(ACCESS_MODIFIER.PUBLIC)) {
			methodBuilder.addModifiers(Modifier.PUBLIC);
		} else if (method.getAccessModifier().equals(ACCESS_MODIFIER.PRIVATE)) {
			methodBuilder.addModifiers(Modifier.PRIVATE);
		}
		if(null !=method.getRequestType()) {
		methodBuilder.addAnnotation(processAnnotation(method.getRequestType()));
		}
		return methodBuilder.build();
	}
	
	
	private AnnotationSpec processAnnotation(RequestType requestType) {
		com.squareup.javapoet.AnnotationSpec.Builder annotationBuilder = AnnotationSpec.builder(GetMapping.class);
		annotationBuilder.addMember("value", "$S", requestType.getPath());
		return annotationBuilder.build();
	}
	

}
