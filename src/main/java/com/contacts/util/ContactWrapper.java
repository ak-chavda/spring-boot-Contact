package com.contacts.util;

import java.util.ArrayList;
import java.util.List;

public class ContactWrapper {

	private long contactId;
	private String name;
	private String emailId;
	private List<String> phList;

	public ContactWrapper() {
		this.phList = new ArrayList<String>();
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

	public List<String> getPhList() {
		return phList;
	}

	public void setPhList(List<String> phList) {
		this.phList = phList;
	}

}
