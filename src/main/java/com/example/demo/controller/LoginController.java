package com.example.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.UserCredential;

@Controller
public class LoginController {
	
	private static final Log LOG = LogFactory.getLog(LoginController.class);
	
	
	@GetMapping("/")
	public String redirectToLogin() {
		LOG.info("<REDIRECTLOGINFORM>");
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String showLoginform(Model model,@RequestParam(name="error",required=false) String error,
								@RequestParam(name="logout",required=false) String logout ) {
		LOG.info("<SHOWLOGINFORM> "+error+" "+logout);
		model.addAttribute("logout",logout);
		model.addAttribute("error",error);
		model.addAttribute("userCredential",new UserCredential());
		return "login";
	}
	
	@PostMapping("/loginCheck")
	public String LoginCheck(@ModelAttribute(name="userCredential") UserCredential usercredential) {
		LOG.info("<LOGINCHECK> "+usercredential);
		if(usercredential.getUsername().equals("user") && usercredential.getPassword().equals("user")) {
			return "contacts";
		}
		
		return "redirect:/login?error=fuck";
	}
	
}
