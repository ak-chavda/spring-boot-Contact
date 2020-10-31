package com.contacts.controller;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.contacts.entity.Contact;
import com.contacts.entity.ContactPhone;
import com.contacts.repository.ContactPhoneRepository;
import com.contacts.repository.ContactRepository;
import com.contacts.util.ContactWrapper;

@Controller
public class ViewAllContactsController {

	@Autowired
	ContactRepository contactRepository;

	@Autowired
	ContactPhoneRepository contactPhoneRepository;

	@Autowired
	HttpSession httpSession;

	@RequestMapping("/all_contacts")
	public String viewContacts(Model theModel, HttpServletRequest request) {
		List<Contact> contactList = contactRepository.findByUserid((Long) httpSession.getAttribute("uid"));
		List<ContactPhone> phList = contactPhoneRepository.findByUserid((Long) httpSession.getAttribute("uid"));

		HashMap<Long, ContactWrapper> contacts = new HashMap<Long, ContactWrapper>();

		//	Wraps the contact data for view part.
		ContactWrapper cw;
		for (Contact contact : contactList) {
			cw = new ContactWrapper();
			cw.setContactId(contact.getContactId());
			cw.setEmailId(contact.getEmailId());
			cw.setName(contact.getName());
			
			//	extract phno.s(string values) and makes a list of it from phList(list of obj.s) 
			cw.setPhList(
					phList.stream()
					.filter(ph -> ph.getContact().getContactId() == contact.getContactId())
					.map( ph -> ph.getPhoneNo() )
					.collect( Collectors.toList() ));
			
			contacts.put(contact.getContactId(), cw);
		}
		
		theModel.addAttribute("contacts", contacts);

		return "view_contact";
	}

}
