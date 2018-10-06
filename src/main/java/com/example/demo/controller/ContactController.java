package com.example.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.constant.ViewConstant;
import com.example.demo.model.ContactModel;
import com.example.demo.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	private static final Log LOG = LogFactory.getLog(ContactController.class);
	
	@Autowired
	@Qualifier("contactserviceimpl")
	private ContactService contactservice;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/contactform")
	private String redirectContactForm(Model model,@RequestParam(name="id",required=false)Integer id) {
		ContactModel cm = new ContactModel();
		if(!id.equals(0)) {
			cm = contactservice.findContactModeltbyId(id);
		}	
		model.addAttribute("contactmodel",cm);
		return ViewConstant.CONTACT_FORM;
	}
	

	@GetMapping("/cancel")
	private String cancel() {
		return "redirect:showcontacts";
	}
	
	@PostMapping("/addContact")
	public String addContact(@ModelAttribute(name="contactmodel") ContactModel contactmodel,Model model) {
		
		LOG.info(contactmodel.toString());
		
		if(!contactservice.addContact(contactmodel).equals(null))
			model.addAttribute("result",1);
			else {
				model.addAttribute("result",0);
			}
		return "redirect:showcontacts";
	}
	
	@GetMapping("/showcontacts")
	public ModelAndView showContacts() {
		ModelAndView mav = new ModelAndView(ViewConstant.CONTANCS);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username",user.getUsername());
		mav.addObject("contacts",contactservice.listAllContacts());
		return mav;
	}
	
	@GetMapping("/removecontact")
	public ModelAndView removeContact(@RequestParam(name="id",required=true)Integer id) {
		contactservice.removeContact(id);
		return showContacts();
	}
	
}
