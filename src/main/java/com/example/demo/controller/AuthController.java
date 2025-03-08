package com.example.demo.controller;

import java.util.Base64.Encoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.POJO.Users;
import com.example.demo.repo.UsersRepo;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	UsersRepo userrepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public String register(@RequestBody Users users) {
	    System.out.println("Register request received for username: " + users.getUsername());

	    Users existinguser = userrepo.findByUsername(users.getUsername());
	    if (existinguser != null) {
	        return "user already there";
	    }
	    users.setPassword(passwordEncoder.encode(users.getPassword()));
	    userrepo.save(users);

	    return "User registered Successfully";
	}

}
