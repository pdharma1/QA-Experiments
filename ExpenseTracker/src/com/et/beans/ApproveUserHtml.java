/**
 * Name: Pradeep Dharmavarapu
 * Class section: 605-782: Web Application Development with JSP and Servlets.
 * Thu 0430pm.
 * Team: Pradeep Dharmavarapu
 * Date: Apr 9, 2014 - 8:40:42 PM
 * Description: 605.782.
 */

package com.et.beans;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.et.dal.UserDal;

public class ApproveUserHtml
{
	public StringBuffer getApproveUserHtml(HttpSession session)
	{
		StringBuffer sb = new StringBuffer("");
		ArrayList<User> toBeApprovedUsers = new ArrayList<User>();
		UserDal userDal = new UserDal();

		toBeApprovedUsers = userDal.getToBeApprovedUsers();

		sb.append("<form method=\"post\" action=\"/ExpenseTracker/ApproveRejectUsers\">");
		sb.append("<table class=\"profile\">");
		sb.append("<tr>");
		sb.append("<th>Name</th>");
		sb.append("<th>User Id</th>");
		sb.append("<th>Role</th>");
		sb.append("<th>Approved</th>");
		sb.append("<th>Income</th>");
		sb.append("<th>Expense</th>");
		sb.append("<th>Approve</th>");
		sb.append("<th>Reject</th>");
		sb.append("</tr>");

		for (User user : toBeApprovedUsers)
		{
			sb.append("<tr><td>" + user.getName() + "</td><td>" + user.getUserId() + "</td><td>" + user.getFkUserRoleId() + "</td><td>"
					+ user.isApproved() + "</td><td>" + user.isIncome() + "</td><td>" + user.isExpense()
					+ "</td><td><input class=\"btn btn-incomes\" type=\"submit\" value=\"Approve\" name=" + user.getId()
					+ "/></td><td><input class=\"btn btn-logout\" type=\"submit\" value=\"Reject\" name=" + user.getId() + "/></td></tr>");
		}

		return sb;
	}

	public StringBuffer getApproveUserHtmlEnhancement()
	{
		StringBuffer sb = new StringBuffer("");

		sb.append("<div align=\"center\" class=\"approvepage\">");
		sb.append("<div>");
		sb.append("<div style=\"float: left; width: 20em\">");
		sb.append("<div>");
		sb.append("<img width=\"70\" height=\"100\" src=\"/ExpenseTracker/imgs/1.png\" />");
		sb.append("</div>");
		sb.append("<div style=\"position: relative\">");
		sb.append("<input type=\"submit\" value=\"Approve\" name=\"Approve1\"/><input type=\"submit\" value=\"Reject\" name=\"Reject1\"/>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("<div style=\"float: left; width: 20em\">");
		sb.append("<div>");
		sb.append("<img width=\"70\" height=\"100\" src=\"/ExpenseTracker/imgs/1.png\" />");
		sb.append("</div>");
		sb.append("<div style=\"position: relative\">");
		sb.append("<input type=\"submit\" value=\"Approve\" /><input type=\"submit\" value=\"Reject\" />");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("<div style=\"float: left; width: 20em\">");
		sb.append("<div>");
		sb.append("<img width=\"70\" height=\"100\" src=\"/ExpenseTracker/imgs/1.png\" />");
		sb.append("</div>");
		sb.append("<div style=\"position: relative\">");
		sb.append("<input type=\"submit\" value=\"Approve\" /><input type=\"submit\" value=\"Reject\" />");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("<div style=\"float: left; width: 20em\">");
		sb.append("<div>");
		sb.append("<img width=\"70\" height=\"100\" src=\"/ExpenseTracker/imgs/1.png\" />");
		sb.append("</div>");
		sb.append("<div style=\"position: relative\">");
		sb.append("<input type=\"submit\" value=\"Approve\" /><input type=\"submit\" value=\"Reject\" />");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("</div>\")");
		return sb;
	}

}
