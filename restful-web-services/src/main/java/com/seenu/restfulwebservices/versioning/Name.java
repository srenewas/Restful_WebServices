package com.seenu.restfulwebservices.versioning;

public class Name {
	
	public Name() {
	}
	
	public String firstname;
	public String Secondname;
	public Name(String firstname, String secondname) {
		super();
		this.firstname = firstname;
		Secondname = secondname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSecondname() {
		return Secondname;
	}
	public void setSecondname(String secondname) {
		Secondname = secondname;
	}
	
}
