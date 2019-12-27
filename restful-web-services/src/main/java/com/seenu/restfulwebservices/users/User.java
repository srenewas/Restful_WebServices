package com.seenu.restfulwebservices.users;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

// here ApiModel is the customizing User.class Description
@ApiModel("*****ITS ALL ABOUT DESCRIPTION OF USER*****")
// for database connection
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	//ApiModelProperty is only applicable for user variables only
	@ApiModelProperty(notes="kanisham rendu accharalu aina kottu")
	// here @size and @past Annotations only for validations
	@Size(min=2,message="name should have atleast 2 letters")
	private String name;
	
	@ApiModelProperty(notes="puttina roju kaccchithanga mundhudai undali")
	@Past
	private Date date;
	
	// This is under Association(Post.class)
	@OneToMany(mappedBy="user")
	private List<Post> post;
	
	public User() {
	}
	
	public User(Integer id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
