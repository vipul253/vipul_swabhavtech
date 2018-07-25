package com.bank.email;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

public class EmailTool {
	
	public static void sendEmail( String toAddress,
			 String message) throws AddressException,
			MessagingException {
		
		String host = "smtp.gmail.com";
		String port = "587";
		String userName = "vipulsawant25@gmail.com";
		String password = "wdkafmvzieorpsmz";
		String subject = "Email Confirmation";
		
		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};

		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		// set plain text message
		msg.setText("click this link to verify your email: "+message);

		// sends the e-mail
		Transport.send(msg);

	}

}
