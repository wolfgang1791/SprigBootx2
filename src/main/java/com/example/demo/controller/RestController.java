package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.ContactModel;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
	
	@GetMapping("/checkrest")
	public ResponseEntity<ContactModel> checkrest(){
		ContactModel c = new ContactModel(2,"gdg","csc","fdcdd","dwaw");
		return new ResponseEntity<ContactModel>(c, HttpStatus.OK);
	}
}
