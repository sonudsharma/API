package com.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailHelper {

	public static boolean sendOtpMail(String to, Integer otp) {

		// Sender's email ID needs to be mentioned
		String from = "rays.hrms@gmail.com";//change accordingly
		final String username = "rays.hrms@gmail.com";//change accordingly
		final String password = "rays@123";//change accordingly
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("One Time Password for Auronia");

			// Now set the actual message
			message.setContent("Dear, <br/><br/>" + "Your OTP for Auronia is <b>" + otp + "</b><br/>" + "Validity: 5 minutes.<br/><br/>" + "Sincerely,<br/><br/>" + "Auronia Team", "text/html; charset=utf-8");

			// Send message
			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		return true;
	}
}
