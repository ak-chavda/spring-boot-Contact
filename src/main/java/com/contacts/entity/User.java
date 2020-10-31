package com.contacts.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.contacts.forms.SignupForm;

@Entity
//@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userid;
	private String username;
	private String emailid;
	private String phoneno;
	private String password;

	public User() {
	}

	public User(long userid, String username, String emailid, String phoneno, String password) {
		this.userid = userid;
		this.username = username;
		this.emailid = emailid;
		this.phoneno = phoneno;
		this.password = password;

	}

	public User(SignupForm signup) {
		this.username = signup.getUsername();
		this.emailid = signup.getEmailid();
		this.phoneno = signup.getPhoneno();
		this.password = signup.getPassword();
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

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