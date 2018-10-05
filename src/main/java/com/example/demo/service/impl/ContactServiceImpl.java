package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.component.ContactConverter;
import com.example.demo.entity.Contact;
import com.example.demo.model.ContactModel;
import com.example.demo.repository.ContactRepository;
import com.example.demo.service.ContactService;

@Service("contactserviceimpl")
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactrepository;
	
	@Autowired
	@Qualifier("contactconverter")
	private ContactConverter contactconverter;
	
	@Override
	public ContactModel addContact(ContactModel contactmodel) {
		Contact contact = contactrepository.save(contactconverter.ContactModeltoContac(contactmodel));
		return contactconverter.ContacttoContacModel(contact);
	}

	@Override
	public List<ContactModel> listAllContacts() {
		List<ContactModel> listmodel = new ArrayList<ContactModel>();
		List<Contact> listcontact = contactrepository.findAll();
		for(Contact c : listcontact) {
			listmodel.add(contactconverter.ContacttoContacModel(c));
			System.out.println(c.getCity());
		}
		return listmodel;
	}
	
	

	
}
