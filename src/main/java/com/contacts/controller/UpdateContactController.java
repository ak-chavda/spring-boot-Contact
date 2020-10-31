package com.contacts.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.contacts.entity.Contact;
import com.contacts.entity.ContactPhone;
import com.contacts.entity.User;
import com.contacts.forms.UpdateContactForm;
import com.contacts.repository.ContactPhoneRepository;
import com.contacts.repository.ContactRepository;

@Controller
public class UpdateContactController {

	@Autowired
	ContactRepository contactRepository;

	@Autowired
	ContactPhoneRepository contactPhoneRepository;

	@GetMapping
	@RequestMapping("/edit_contact")
	public String updateForm(Model model, @RequestParam("id") Long contactid, HttpSession httpSession) {

		Contact c = contactRepository.findByUseridandContactId((Long) httpSession.getAttribute("uid"), contactid);

		List<ContactPhone> phList = contactPhoneRepository
				.findByUseridandContactId((Long) httpSession.getAttribute("uid"), contactid);

		model.addAttribute("con", c);
		model.addAttribute("phList", phList);

//		return "edit_contact";
		return "tedit_contact";
	}

	@RequestMapping("/update_contact")
	public String processForm(@Valid @ModelAttribute("updateContact") UpdateContactForm updateContact,
			BindingResult bindingResult, Model theModel, HttpSession session) {

		if (bindingResult.hasErrors()) {
			theModel.addAttribute("error", "All Fields are mandatory");
//			return "edit_contact";
			return "tedit_contact";
		}

		// ********************* contact info only ***************

		Contact c = new Contact();
		c.setContactId(updateContact.getContactid());
		c.setEmailId(updateContact.getEmailid());
		c.setName(updateContact.getName());

		// create user obj to give contact obj
		User u = new User();
		u.setUserid((Long) session.getAttribute("uid"));

		// provide user obj to contact obj
		c.setUser(u);
		contactRepository.save(c);

		// *************************** contact phone only**********

		// before update delete old ph records
		contactPhoneRepository.deleteByContact(c);

		if (updateContact.getPhonenumber() != null) {

			// create ref for contactphone
			ContactPhone cp = null;

			for (String ph : updateContact.getPhonenumber()) {
				cp = new ContactPhone();
				cp.setPhoneNo(ph);
				cp.setContact(c);
				contactPhoneRepository.save(cp);
			}
		}

		return "redirect:/all_contacts";
	}

}
