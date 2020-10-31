package com.contacts.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ContactPhone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long phoneID;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "contact_id", nullable = false)
	private Contact contact;

	private String phoneNo;

	public ContactPhone() {
	}

	public ContactPhone(long phoneID, Contact contact, String phoneNo) {
		super();
		this.phoneID = phoneID;
		this.contact = contact;
		this.phoneNo = phoneNo;
	}

	public long getPhoneID() {
		return phoneID;
	}

	public void setPhoneID(long phoneID) {
		this.phoneID = phoneID;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "ContactPhone [phoneID=" + phoneID + ", phoneNo=" + phoneNo + ", contact=" + contact + "]";
	}

}
