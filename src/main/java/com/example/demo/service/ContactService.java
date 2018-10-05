package com.example.demo.service;



import java.util.List;

import com.example.demo.model.ContactModel;

//@Service("ContactService")
public interface ContactService {

	public abstract ContactModel addContact(ContactModel contactmodel);
	public abstract List<ContactModel> listAllContacts();
}
