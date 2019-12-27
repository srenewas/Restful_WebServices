package com.seenu.restfulwebservices.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	public static List<User> users = new ArrayList<>();
	private static int count=3;
	
	static{
		users.add(new User(1, "seenu", new Date()));
		users.add(new User(2, "suahs", new Date()));
		users.add(new User(3, "aron", new Date()));
	}
	public List<User> findAll(){
		return users;
	}
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++count);
		}
		users.add(user);
		return user;
	}
	public User findone(int id) {
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
}
