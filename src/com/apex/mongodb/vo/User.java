package com.apex.mongodb.vo;

import java.io.Serializable;

public class User implements Serializable{

	private String id;
	private String firstName;
	private String lastName;
	private String middleName;

	public User() {
		super();
	}

	public User(String id, String firstName, String lastName, String middleName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

}
