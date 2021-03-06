package com.saraya.contactform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author NdourCodeur
 **/

@SpringBootApplication
@EnableAsync
public class ContactFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactFormApplication.class, args);
	}

}
