package com.example.demo.component;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Contact;
import com.example.demo.model.ContactModel;

@Component("contactconverter")
public class ContactConverter {
	
	public Contact ContactModeltoContac(ContactModel contacmodel) {
		Contact contact = new Contact();
		contact.setCity(contacmodel.getCity());
		contact.setFirstname(contacmodel.getFirstname());
		contact.setLastname(contacmodel.getLastname());
		contact.setTelephone(contacmodel.getTelephone());
		contact.setId(contacmodel.getId());
		return contact;
	}
	
	public ContactModel ContacttoContacModel(Contact contac) {
		ContactModel contactmodel = new ContactModel();
		contactmodel.setCity(contac.getCity());
		contactmodel.setFirstname(contac.getFirstname());
		contactmodel.setLastname(contac.getLastname());
		contactmodel.setId(contac.getId());
		contactmodel.setTelephone(contac.getTelephone());
		return contactmodel;
	}
	
}
