package com.sararoepe.strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StringsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsApplication.class, args);
	}
	
	@RequestMapping("/")
	
	public String greet() {
		return "Good day Client!  How you are today?";
	}
	
@RequestMapping("/random")
	
	public String greetSpring() {
		return "Spring is so great!  It's easy to respond simply with Strings:)!";
	}
	
}
