package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.UserCredential;

@Controller
public class LoginController {
	
	@GetMapping("/")
	public String redirectToLogin() {
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String showLoginform(Model model,@RequestParam(name="error",required=false) String error,
								@RequestParam(name="logout",required=false) String logout ) {
		System.out.println(error);System.out.println(logout);
		model.addAttribute("logout",logout);
		model.addAttribute("error",error);
		model.addAttribute("userCredential",new UserCredential());
		return "login";
	}
	
	@PostMapping("/loginCheck")
	public String LoginCheck(@ModelAttribute(name="userCredential") UserCredential usercredential) {
		
		if(usercredential.getUsername().equals("user") && usercredential.getPassword().equals("user")) {
			return "contacts";
		}
		
		return "redirect:/login?error=fuck";
	}
	
}
