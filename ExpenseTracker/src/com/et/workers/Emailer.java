/**
 * Name: Pradeep Dharmavarapu
 * Class section: 605-782: Web Application Development with JSP and Servlets.
 * Thu 0430pm.
 * Team: Pradeep Dharmavarapu
 * Date: Apr 2, 2014 - 4:28:45 PM
 * Description: 605.782.
 */

package com.et.workers;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.et.beans.RegistrationEmail;
import com.et.beans.User;

public class Emailer
{
	public boolean emailRegistrationEmailNow(User user, String subject)
	{
		boolean result = false;
		StringBuffer sb = new StringBuffer();
		RegistrationEmail emailHtml = new RegistrationEmail();
		sb = emailHtml.getRegistrationConfirmationEmailText(user);

		String fromAddress = "jhuuser1@gmail.com";

		try
		{
			sendMail(user.getUserId().replace("`", "").replace("'", ""), fromAddress, "Expense Tracker - " + subject, sb.toString());
			result = true;
		}
		catch (MessagingException e)
		{
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	public boolean emailRegistrationApprovalEmailNow(User user, String subject)
	{
		boolean result = false;
		StringBuffer sb = new StringBuffer();
		RegistrationEmail emailHtml = new RegistrationEmail();
		sb = emailHtml.getApprovalConfirmationEmailText(user);

		String fromAddress = "jhuuser1@gmail.com";

		try
		{
			sendMail(user.getUserId().replace("`", "").replace("'", ""), fromAddress, "Expense Tracker - " + subject, sb.toString());
			result = true;
		}
		catch (MessagingException e)
		{
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	public boolean emailRegistrationRejectionEmailNow(User user, String subject)
	{
		boolean result = false;
		StringBuffer sb = new StringBuffer();
		RegistrationEmail emailHtml = new RegistrationEmail();
		sb = emailHtml.getRejectionConfirmationEmailText(user);

		String fromAddress = "jhuuser1@gmail.com";

		try
		{
			sendMail(user.getUserId().replace("`", "").replace("'", ""), fromAddress, "Expense Tracker - " + subject, sb.toString());
			result = true;
		}
		catch (MessagingException e)
		{
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	private void sendMail(String to, String from, String subject, String emailMessage) throws MessagingException
	{
		Message message = new MimeMessage(getSession());
		message.addRecipient(RecipientType.TO, new InternetAddress(to));
		message.addFrom(new InternetAddress[] { new InternetAddress(from) });
		message.setSubject(subject);
		message.setContent(emailMessage, "text/html");
		Transport.send(message);
	}

	private Session getSession()
	{
		Authenticator authenticator = new Authenticator();
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.port", "587");
		properties.setProperty("mail.smtp.submitter", authenticator.getPasswordAuthentication().getUserName());

		return Session.getInstance(properties, authenticator);
	}

	private class Authenticator extends javax.mail.Authenticator
	{
		private PasswordAuthentication authentication;

		public Authenticator()
		{
			String username = "jhuuser1";
			String password = "jhuuserpass12";
			authentication = new PasswordAuthentication(username, password);
		}

		protected PasswordAuthentication getPasswordAuthentication()
		{
			return authentication;
		}
	}
}
