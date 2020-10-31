package com.contacts.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.contacts.forms.AddContactForm;

@Entity
//@Table(name = "contacts")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long contactId;

	private String name;

	private String emailId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid", nullable = false)
	private User user;

	public Contact() {
	}

	public Contact(AddContactForm contactform, Long userId) {
		this.setName(contactform.getName());
		this.setEmailId(contactform.getEmailid());
		this.user = new User();
		this.user.setUserid(userId);
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", name=" + name + ", emailId=" + emailId + ", user=" + user + "]";
	}

}
