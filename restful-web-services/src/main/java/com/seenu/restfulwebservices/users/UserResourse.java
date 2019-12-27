package com.seenu.restfulwebservices.users;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResourse {
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping("/users")
	public List<User> retriveall(){
		return service.findAll();
	}
	@GetMapping("/users/{id}")
	public User oneuser(@PathVariable int id) throws UserNotFoundException{
		User user=service.findone(id);
		if(user==null)
			throw new UserNotFoundException("id-"+id);
		return user;
	}
	
//	@PostMapping("/users")
//	public void insert(@RequestBody User user) {       //HTTP status code is : 200 (ok)
//		User u = service.save(user);
//		
//	}
	
	@PostMapping("/users")                                       // HTTP status code is : 201 (Created)
	public ResponseEntity<Object> insert(@RequestBody User user) {
		User u = service.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()  
				.path("/{id}")
				.buildAndExpand(u.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

}
