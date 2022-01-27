package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ProcessCode;
import com.example.demo.model.BuildVO;

@RestController
public class Controller {

	@CrossOrigin
	@PostMapping(path = "/generate", 
	        consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getJavaFile(@RequestBody BuildVO ob) {
		
	System.out.println("***********************************" + ob.toString());
	ProcessCode processCode = new ProcessCode();
	String result = processCode.generateJavaFile(ob);
	 return result;
	}	
	
}
