package com.saraya.contactform.servises;

import javax.mail.internet.MimeMessage;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;

import com.saraya.contactform.entity.ContactForm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author NdourCodeur
 **/
@Service
public class EmailService {
	
	Logger logger = LogManager.getLogger(EmailService.class);

	private final JavaMailSender emailSender;

	public EmailService(JavaMailSender emailSender) {
		this.emailSender = emailSender;
	}

	@Value("${spring.mail.username}")
	private String emailTo;
	
	@Async
	public void send(ContactForm contactForm) {
		
		// prepare email format
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
				mimeMessage.setSubject("Saraya Bootcamp contact");
				
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
				
				helper.setText(
							"<html>"
								+	"<body>" 
									+	"Email sent by: " + contactForm.getFirstName() + " " + contactForm.getLastName()+ "<br/>"
									+   "Email address: " + contactForm.getEmail() + "<br/>"
						            +   "Email address: " + contactForm.getPhone()
									+   "<br/><br/>"
									+   contactForm.getMessage()
								+   "</body>"
							+ "</html>", true);
			}
		};
		
		try {
			emailSender.send(preparator);
			logger.info("Email sent successfully...");
		} catch (Exception e) {
			logger.error("Error sending email.");
			throw e;
		}		
	}

}
