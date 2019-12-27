package com.seenu.restfulwebservices;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {             // This is From ApiInfo.Class
	
	// For Customizing info of Swagger
	public static final Contact DEFAULT_CONTACT = new Contact("Seenu iglesias", "http://www.seenuiglesias.com", "ch.srenewas@gmail.com");
	  public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Api Documentation", "Seenu Api Documentation Description", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	  
	  // For Customizing Produces Consumes Data Format
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(Arrays.asList("applicatrion/json","appplication/xml"));


	@Bean
	public Docket api() {                                //http://localhost:8080/v2/api-docs     http://localhost:8080/swagger-ui.html
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCES_AND_CONSUMES)
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES);   
	}                                   

}
