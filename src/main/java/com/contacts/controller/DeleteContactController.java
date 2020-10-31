package com.contacts.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.contacts.entity.Contact;
import com.contacts.repository.ContactPhoneRepository;
import com.contacts.repository.ContactRepository;

@Controller
public class DeleteContactController {

	@Autowired
	ContactRepository contactRepository;
	@Autowired
	ContactPhoneRepository contactPhoneRepository;

	@Transactional
	@RequestMapping("/delete_contact")
	public String deleteContact(Model model, @RequestParam("id") Long contactid, HttpSession httpSession) {
		Contact c = new Contact();
		c.setContactId(contactid);

		contactPhoneRepository.deleteByContact(c);
		contactRepository.delete(c);

		return "redirect:/all_contacts";

	}

}
