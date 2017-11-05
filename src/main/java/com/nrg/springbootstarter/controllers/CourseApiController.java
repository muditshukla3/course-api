package com.nrg.springbootstarter.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseApiController {

	@RequestMapping("/hello")
	public String sayHello(){
		return "Hello";
	}
}
