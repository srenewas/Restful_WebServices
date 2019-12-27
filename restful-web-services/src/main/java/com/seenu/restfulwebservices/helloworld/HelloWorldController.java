package com.seenu.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@controller
@RestController
public class HelloWorldController {
	
	//@RequestMapping(method = RequestMethod.GET, path="/hello-world")
	@GetMapping(path = "/hello-world")
	public String helloworld() {
		return "hello world";
		
		// http://localhost:8080/hello-world
		// output :- helloworld
	}
	@GetMapping(path="/hello-bean")
	public HelloWorldBean helloworldbean() {
		return new HelloWorldBean("SEENU IGLESIAS");
		
		// http://localhost:8080/hello=bean
		// output :- { "message": "SEENU IGLESIAS"}
	}
	@GetMapping(path="hello-world/path/{name}")
	public HelloWorldBean Hellopathvariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("HELLO , %s", name));     
		
		//  http://localhost:8080/hello-world/path/suhas iglesias
		// output like this{ "message": "HELLO , suhas iglesias"}
	}
}
