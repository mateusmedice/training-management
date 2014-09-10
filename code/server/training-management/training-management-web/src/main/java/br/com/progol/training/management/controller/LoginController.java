package br.com.progol.training.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("/doLogin")
	public String loginPage(
		@RequestParam(value="userName", required=true) String userName, 
		@RequestParam(value="password", required=true) String password) {
		
		if(userName == null || password == null) {
			return "login";
		}
		
		return "home";
	}
	
}
