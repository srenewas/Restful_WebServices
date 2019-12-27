package com.seenu.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//@JsonIgnoreProperties(value= {"filter1","filter3"})  // STATIC FILTER -> we can also exclude the variables by using @jsonIgnoreProperties
@JsonFilter("idpass")
public class filter {
	
	//@JsonIgnore   // This is the Static filtering
	public String filter1;
	public String filter2;
	
	//@JsonIgnore   // This is the Static filtering
	public String filter3;
	
	public filter(String filter1, String filter2, String filter3) {
		super();
		this.filter1 = filter1;
		this.filter2 = filter2;
		this.filter3 = filter3;
	}
	public String getFilter1() {
		return filter1;
	}
	public void setFilter1(String filter1) {
		this.filter1 = filter1;
	}
	public String getFilter2() {
		return filter2;
	}
	public void setFilter2(String filter2) {
		this.filter2 = filter2;
	}
	public String getFilter3() {
		return filter3;
	}
	public void setFilter3(String filter3) {
		this.filter3 = filter3;
	}

}
