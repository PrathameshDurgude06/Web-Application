package com.blogs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blogs.entities.Role;
import com.blogs.entities.User;
import com.blogs.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	/*
	 * @RequestParam: method arg level annotation to bind request parameters to method args
	 * Done auto by SC
	 * should match req param names to method arg names
	 */
	public String processLoginForm(@RequestParam String email,@RequestParam String password
			,Model map,HttpSession session) {
		System.out.println("in process login form"+email+" "+password);
		try {
		//invoke service layer method
		User signInUser = userService.signInUser(email, password);
		//add user details n message under model attribute
		session.setAttribute("meassage","Login SUccessful");
		session.setAttribute("user_details",signInUser);
		//=>login Successful
		//check the rule in case of admin forward the client to admin home page
		//check the rule in case of blogger forward the client to blogger home page
		if(signInUser.getRole()==Role.ADMIN)
			return "redirect:/admin/home";
		/*
		 * SC-- response.sendRedirect(String URL)
		 * next URL-- http://host:port/spring_boot/admin/home
		 */
		return "redirect:/blogger/home";
		/*
		 * SC-- response.sendRedirect(String URL)
		 * next URL-- http://host:port/spring_boot/blogger/home
		 */
		}catch(RuntimeException e){
			System.out.println("error"+e);
			//=> inavlid login forward clnt to the login form
			map.addAttribute("meassage",e.getMessage());
			return "/users/login"; 
		}
	}
}
