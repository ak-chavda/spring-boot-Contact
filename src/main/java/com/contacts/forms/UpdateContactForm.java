package com.contacts.forms;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateContactForm {

	@NotNull(message = "is required")
	Long contactid;

	@NotNull(message = "is required")
	@Size(min = 1, message = "Username should not be Empty")
	String name;

	@NotNull(message = "is required")
	@Size(min = 1, message = "Email ID should not be Empty")
	String emailid;

	
	
	
	
	
	
	@NotNull(message = "is required")
	List<String> phonenumber;
	
	
	
	
	
	

	public Long getContactid() {
		return contactid;
	}

	public void setContactid(Long contactid) {
		this.contactid = contactid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public List<String> getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(List<String> phonenumber) {
		this.phonenumber = phonenumber;
	}

}
