package com.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "child")
public class Child {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String childName;
	@Column
	private String parentName;
	@Column
	private Date dob;
	@Column
	private String parentContact;	
	@Column
	private String email;
	@Column(nullable = false)
	private String password;
	@Column
	private String address;
	public Child(int id, String childName, String parentName, Date dob, String parentContact, String email,
			String password, String address) {
		super();
		this.id = id;
		this.childName = childName;
		this.parentName = parentName;
		this.dob = dob;
		this.parentContact = parentContact;
		this.email = email;
		this.password = password;
		this.address = address;
	}
	public Child() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public String getChildName() {
		return childName;
	}
	public String getParentName() {
		return parentName;
	}
	public Date getDob() {
		return dob;
	}
	public String getParentContact() {
		return parentContact;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getAddress() {
		return address;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setChildName(String childName) {
		this.childName = childName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void setParentContact(String parentContact) {
		this.parentContact = parentContact;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
