package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.constant.ViewConstant;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	@GetMapping("/contactform")
	private String redirectContactForm() {
		return ViewConstant.CONTACT_FORM;
	}
}
