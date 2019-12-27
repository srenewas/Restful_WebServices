package com.seenu.restfulwebservices.versioning;

public class PersionV2 {
	
	public Name name;
	
	public PersionV2() {
	}
	
	public PersionV2(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
	
}
