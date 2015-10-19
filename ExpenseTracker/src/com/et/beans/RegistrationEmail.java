/**
 * Name: Pradeep Dharmavarapu
 * Class section: 605-782: Web Application Development with JSP and Servlets.
 * Thu 0430pm.
 * Team: Pradeep Dharmavarapu
 * Date: Apr 7, 2014 - 10:54:37 PM
 * Description: 605.782.
 */

package com.et.beans;

public class RegistrationEmail
{
	public StringBuffer getRegistrationConfirmationEmailText(User user)
	{
		StringBuffer emailText = new StringBuffer();
		emailText.append("<html>");
		emailText.append("<head>");
		emailText.append("<img alt=\"Banner\" src=\"/ExpenseTracker/imgs/2.png\" /></a>");
		emailText.append("</head>");
		emailText.append("<body>");
		emailText.append("<table>");
		emailText.append("<tr>");
		emailText.append("<td>");
		emailText.append("Thank you for registering with Expense Tracker. ");
		emailText
				.append("Please find the following registration information you entered. Another email notification will be delivered as soon as the request is approved. </td></tr></table><BR>");
		emailText.append("<table><tr><td>Name: " + user.getName());
		emailText.append("</td></tr><tr><td>Email: " + user.getUserId());
		emailText.append("</td></tr><tr><td>Approved: " + user.isApproved());
		emailText.append("</td></tr><tr><td>Address: " + user.getAddress());
		emailText.append("</td></tr><tr><td>Role chosen: " + user.getFkUserRoleId());
		emailText.append("</td></tr><tr><td>Services selected: " + (user.isExpense() ? "Expense " : "")
				+ ((user.isIncome() ? "Income " : "")));
		emailText.append("");
		emailText.append("</td></tr></table><BR><table><tr><td>Warm Regards, </td></tr><tr><td>Expense Tracker Team.</td></tr></table></body>");
		emailText.append("</html>");

		return emailText;
	}

	public StringBuffer getApprovalConfirmationEmailText(User user)
	{
		StringBuffer emailText = new StringBuffer();
		emailText.append("<html>");
		emailText.append("<head>");
		emailText.append("<img alt=\"Banner\" src=\"/ExpenseTracker/imgs/2.png\" /></a>");
		emailText.append("</head>");
		emailText.append("<body>");
		emailText.append("<table>");
		emailText.append("<tr>");
		emailText.append("<td>");
		emailText
				.append("Thank you for registering with Expense Tracker. "
						+ " Your registration is now APPROVED. "
						+ " You are now authorized to enter data per your registered services as below."
						+ " Thank you for your patience and understanding.");
		emailText
				.append(" Please find the following registration information you entered. </td></tr></table><BR>");
		emailText.append("<table><tr><td>Name: " + user.getName());
		emailText.append("</td></tr><tr><td>Email: " + user.getUserId());
		emailText.append("</td></tr><tr><td>Approved: " + user.isApproved());
		emailText.append("</td></tr><tr><td>Address: " + user.getAddress());
		emailText.append("</td></tr><tr><td>Role chosen: " + user.getFkUserRoleId());
		emailText.append("</td></tr><tr><td>Services selected: " + (user.isExpense() ? "Expense " : "")
				+ ((user.isIncome() ? "Income " : "")));
		emailText.append("");
		emailText.append("</td></tr></table><BR><table><tr><td>Warm Regards, </td></tr><tr><td>Expense Tracker Team.</td></tr></table></body>");
		emailText.append("</html>");

		return emailText;
	}

	public StringBuffer getRejectionConfirmationEmailText(User user)
	{
		StringBuffer emailText = new StringBuffer();
		emailText.append("<html>");
		emailText.append("<head>");
		emailText.append("<img alt=\"Banner\" src=\"/ExpenseTracker/imgs/2.png\" /></a>");
		emailText.append("</head>");
		emailText.append("<body>");
		emailText.append("<table>");
		emailText.append("<tr>");
		emailText.append("<td>");
		emailText
				.append("Thank you for registering with Expense Tracker. "
						+ " Your registration is now REJECTED. You are not authorized to enter data per your registered services as below. "
						+ " User information deleted from our databases."
						+ " Should you want to utilize our services, we encourage you to re-register yourself and repeat through this process."
						+ " Thank you for your patience and understanding.");
		emailText
				.append(" Please find the following registration information you entered. </td></tr></table><BR>");
		emailText.append("<table><tr><td>Name: " + user.getName());
		emailText.append("</td></tr><tr><td>Email: " + user.getUserId());
		emailText.append("</td></tr><tr><td>Approved: " + user.isApproved());
		emailText.append("</td></tr><tr><td>Address: " + user.getAddress());
		emailText.append("</td></tr><tr><td>Role chosen: " + user.getFkUserRoleId());
		emailText.append("</td></tr><tr><td>Services selected: " + (user.isExpense() ? "Expense " : "")
				+ ((user.isIncome() ? "Income " : "")));
		emailText.append("");
		emailText.append("</td></tr></table><BR><table><tr><td>Warm Regards, </td></tr><tr><td>Expense Tracker Team.</td></tr></table></body>");
		emailText.append("</html>");

		return emailText;
	}
}
