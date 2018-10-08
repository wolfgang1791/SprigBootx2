package com.example.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.constant.ViewConstant;



// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 */
@Controller
public class LoginController {
	
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(LoginController.class);
	
	
	/**
	 * Show loginform.
	 *
	 * @param model the model
	 * @param error the error
	 * @param logout the logout
	 * @return the string
	 */
	@GetMapping("/login")
	public String showLoginform(Model model,@RequestParam(name="error",required=false) String error,
								@RequestParam(name="logout",required=false) String logout ) {
		LOG.info("<SHOWLOGINFORM> "+error+" "+logout);
		
		model.addAttribute("logout",logout);
		model.addAttribute("error",error);
		//model.addAttribute("userCredential",new UserCredential());
		return ViewConstant.LOGIN;
	}
	
	/**
	 * Login check.
	 *
	 * @return the string
	 */
	@GetMapping({"/loginsuccess","/"})
	public String LoginCheck() {
		LOG.info("cascascascascascdvsdf ");
		return "redirect:/contacts/showcontacts";
	}
	
}
