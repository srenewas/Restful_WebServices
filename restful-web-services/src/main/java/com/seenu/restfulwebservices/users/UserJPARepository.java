package com.seenu.restfulwebservices.users;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPARepository {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/jpa/users")
	public List<User> retriveall(){
		return repository.findAll();
	}
	@GetMapping("/jpa/users/{id}")
	public Optional<User> oneuser(@PathVariable int id) throws UserNotFoundException{
		Optional<User> user=repository.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException("id-"+id);
		return user;
	}
	
//	@PostMapping("/users")
//	public void insert(@RequestBody User user) {       //HTTP status code is : 200 (ok)
//		User u = service.save(user);
//		
//	}
	
	@PostMapping("/jpa/users")                                       // HTTP status code is : 201 (Created)
	public ResponseEntity<Object> insert(@RequestBody User user) {
		User u = repository.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()  
				.path("/{id}")
				.buildAndExpand(u.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

}
