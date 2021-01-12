package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.User;
import com.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService service;
	
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(ModelMap m,@RequestParam("uname")String uname, @RequestParam("pass")String password) {
		if(service.login(m, uname, password)) {
			return "welcome";
		}
		return "loginerror";
	}
	
	
	@GetMapping("/register")
	public String showRegister() {
		return "register";
	}
	
	@PostMapping("/register")
	public void register(@RequestParam("uname")String name, @RequestParam("pass")String pass,
			@RequestParam("email")String email, @RequestParam("city")String city) {
		if(service.register(name,pass,email,city)) {
			System.out.println("registered success");
		}else {
			System.out.println("register failure");
		}
	}
	
	@PostMapping("/edit")
	public String editUser(ModelMap m, @RequestParam("email")String email, 
			@RequestParam("city")String city) {
		if(service.edit(m,email,city)) {
			return "welcome";
		}else {
			return "welcome";
		}
		
		
	}
}
