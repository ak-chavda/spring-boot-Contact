package com.contacts.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SignupForm {

	@NotNull(message = "is required")
	@Size(min = 1, message = "Username should not be Empty")
	private String username;

	@NotNull(message = "is required")
	@Size(min = 1, message = "Email should not be Empty")
	private String emailid;

	@NotNull(message = "is required")
	@Size(min = 1, message = "Phone No should not be Empty")
	private String phoneno;

	@NotNull(message = "is required")
	@Size(min = 1, message = "Password should not be Empty")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
