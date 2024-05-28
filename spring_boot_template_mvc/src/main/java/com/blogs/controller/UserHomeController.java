package com.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//spring bean conataining request handling logic
public class UserHomeController {
public UserHomeController() {
		System.out.println("In ctor of"+getClass());
}
//add method to render login page
@GetMapping("/")
public String showLoginForm(){
	System.out.println("In show login form");
	return "/users/login"; //handler returns LVN to DS --> V.R --> D.S
	//AVN: /WEB-INF/views/users/login.jsp
}
}
