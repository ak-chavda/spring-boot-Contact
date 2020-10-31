package com.contacts.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SigninForm {

	@NotNull
	@Size(min = 1, message = "Username should not be Empty")
	String userName;

	@NotNull
	@Size(min = 1, message = "Password should not be Empty")
	String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
