package com.seenu.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	//@GetMapping("/v1")                                     //  By using URI versioning (TWITTER) http://localhost:8080/v1
	@GetMapping(value="/param",params="v=1")                 //  by using Request Param versioning (AMAZON) http://localhost:8080/param?v=1
	public PersionV1 personv1() {
		return new PersionV1("seenu");
	}
	
	@GetMapping(value="/header",headers="X-API-VERSION=1")      // By using header versioning (MICROSOFT)   http://localhost:8080/header
	public PersionV1 personv11() {
		return new PersionV1("seenu");
	}
	
	//@GetMapping("/v2")                                        //By using URI versioning (TWITTER)     http://localhost:8080/v2
	//@GetMapping(value="/param",params="v=2")                  //  By using Request Param versioning (AMAZON)  http://localhost:8080/param?v=2
	public PersionV2 persionv2() {
		return new PersionV2(new Name("seenu","iglesias"));
	}
	
	@GetMapping(value="/header",headers="X-API-VERSION=2")      //  by using header versioning  (MICROSOFT)  http://localhost:8080/header
	public PersionV2 persionv21() {
		return new PersionV2(new Name("seenu","iglesias"));
	}
}
