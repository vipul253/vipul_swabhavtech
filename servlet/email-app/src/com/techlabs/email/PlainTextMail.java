package com.techlabs.email;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class PlainTextMail {
	public void sendPlainTextEmail(String host, String port,
			final String userName, final String password, String toAddress,
			String subject, String message) throws AddressException,
			MessagingException {

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
		msg.setText(message);

		// sends the e-mail
		Transport.send(msg);

	}

	/**
	 * Test the send e-mail method
	 *
	 */
	public static void main(String[] args) {
		// SMTP server information
		String host = "smtp.gmail.com";
		String port = "587";
		String mailFrom = "vipulsawant25@gmail.com";
		String password = "Osh5m2@@";

		// outgoing message information
		String mailTo = "vipulsawant25@gmail.com";
		String subject = "hello me";
		String message = "Hope you are doing well";

		PlainTextMail mailer = new PlainTextMail();

		try {
			mailer.sendPlainTextEmail(host, port, mailFrom, password, mailTo,
					subject, message);
			System.out.println("Email sent.");
		} catch (Exception ex) {
			System.out.println("Failed to sent email.");
			ex.printStackTrace();
		}
	}
}