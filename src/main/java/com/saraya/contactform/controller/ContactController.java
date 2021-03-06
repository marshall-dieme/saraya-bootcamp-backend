package com.saraya.contactform.controller;

import com.saraya.contactform.entity.ContactForm;
import com.saraya.contactform.message.Message;
import com.saraya.contactform.servises.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * @author NdourCodeur
 **/

@RestController
@RequestMapping("/api/contact")
public class ContactController {

	private final EmailService emailService;

	public ContactController(EmailService emailService) {
		this.emailService = emailService;
	}


	// URL = http://127.0.0.1:8001/api/contact/sendEmail
	@PostMapping("/send-email")
	public ResponseEntity<?> sendEmail(@Valid @RequestBody ContactForm contactForm) {
		
		emailService.send(contactForm);
		
		return new ResponseEntity<>(new Message("Email sent successfully"), HttpStatus.OK);
	}
}
