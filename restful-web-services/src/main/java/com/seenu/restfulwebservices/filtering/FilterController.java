package com.seenu.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {
	
	//*****STATIC FILTERING

//	@GetMapping("/filter")
//	public filter retrive() {
//		return new filter("seenu","suhas","ravi");
//	}
	
	
	//*****DYNAMIC FILTERING*******
	
	@GetMapping("/filter")
	public MappingJacksonValue retrive() {
		filter fil =  new filter("seenu","suhas","ravi");
		
		MappingJacksonValue value = new MappingJacksonValue(fil);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("filter1","filter3");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("idpass", filter);
		
		value.setFilters(filters);
		return value;
	}
	
	//*****STATIC FILTERING
	
//	@GetMapping("/filters")
//	public List<filter> Allretrive() {
//		return Arrays.asList(new filter("seenu", "suvvy", "bugga"),
//				             new filter("ravi", "nag", "hema"));
//	}
	
	//*****DYNAMIC FILTERING*******
	
	@GetMapping("/filters")
	public MappingJacksonValue Allretrive() {
		List<filter> list = Arrays.asList(new filter("seenu", "suvvy", "bugga"),
				             new filter("ravi", "nag", "hema"));
        MappingJacksonValue value = new MappingJacksonValue(list);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("filter1","filter3");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("idpass", filter);
		
		value.setFilters(filters);
		
		return value;
	}

}
