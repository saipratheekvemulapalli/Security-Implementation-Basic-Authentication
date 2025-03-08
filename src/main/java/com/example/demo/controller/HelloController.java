package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	
	@GetMapping("/wish")
	public String Hello() {
		return "You have Achieved the SECURITY in springboot";
		
	}
	
}
