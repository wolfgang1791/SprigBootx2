package com.example.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.constant.ViewConstant;
import com.example.demo.model.ContactModel;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	private static final Log LOG = LogFactory.getLog(ContactController.class);
	
	@GetMapping("/contactform")
	private String redirectContactForm(Model model) {
		model.addAttribute("contactmodel",new ContactModel());
		return ViewConstant.CONTACT_FORM;
	}
	

	@GetMapping("/cancel")
	private String cancel() {
		return ViewConstant.CONTANCS;
	}
	
	@PostMapping("/addContact")
	public String addContact(@ModelAttribute(name="contactmodel") ContactModel contactmodel,Model model) {
		LOG.info(contactmodel.toString());
		model.addAttribute("result",1);
		return ViewConstant.CONTANCS;
	}
	
	
	
}
