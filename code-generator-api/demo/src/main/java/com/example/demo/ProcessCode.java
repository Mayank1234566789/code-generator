package com.example.demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.BuildVO;
import com.example.demo.model.ModelClass;
import com.squareup.javapoet.JavaFile;

public class ProcessCode {

	public String generateJavaFile(BuildVO buildVO) {
		String response = null;
		BuildCode buildCode = new BuildCode();
		for (ModelClass modelClass : buildVO.getModelClass()) {
			JavaFile javaFile = buildCode.process(modelClass);
			try {
				System.out.println("#################Start of Output######################");
				javaFile.writeTo(System.out);
			    response = javaFile.toString();
				System.out.println("##################End of Output######################");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return response;

	}

}
