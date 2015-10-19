/**
 * Name: Pradeep Dharmavarapu
 * Class section: 605-782: Web Application Development with JSP and Servlets.
 * Thu 0430pm.
 * Team: Pradeep Dharmavarapu
 * Date: Apr 10, 2014 - 12:12:24 AM
 * Description: 605.782.
 */

package com.et.workers;

import javax.servlet.http.HttpSession;

import com.et.beans.User;

public class GetHeaderContent
{
	public static StringBuffer getHeaderContent(HttpSession session)
	{
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		StringBuffer sb = new StringBuffer("");

		if (loggedInUser == null)
		{
			sb.append("<td><a href=\"/ExpenseTracker/index.jsp\">Register</a></td>");
			sb.append("<td></td>");
			sb.append("<td><a href=\"/ExpenseTracker/views/login.jsp\">Login</a></td>");
			sb.append("<td></td>");
		}
		else
		{
			if (loggedInUser.isApproved())
			{
				if (loggedInUser.isExpense())
				{
					sb.append("<td><a href=\"/ExpenseTracker/views/expense.jsp\">New Expense</a></td>");
					sb.append("<td></td>");
				}
				if (loggedInUser.isIncome())
				{
					sb.append("<td><a href=\"/ExpenseTracker/views/income.jsp\">New Income </a></td>");
					sb.append("<td></td>");
				}
				if ((loggedInUser.isExpense()) || (loggedInUser.isIncome()))
				{
					sb.append("<td><a href=\"/ExpenseTracker/views/viewtransactions.jsp\">View Transactions </a></td>");
					sb.append("<td></td>");
				}

				if (loggedInUser.getFkUserRoleId().equals("Admin"))
				{
					sb.append("<td><a href=\"/ExpenseTracker/views/approve.jsp\">Approve Users </a></td>");
					sb.append("<td></td>");
				}

				if (loggedInUser.getFkUserRoleId().equals("Admin"))
				{
					sb.append("<td><a href=\"/ExpenseTracker/views/admin.jsp\">Admin</a></td>");
					sb.append("<td></td>");
				}

				if (loggedInUser.isIncome() && loggedInUser.isExpense())
				{
					sb.append("<td><a href=\"/ExpenseTracker/views/reports.jsp\">Reports</a></td>");
				}
				sb.append("<td><a href=\"/ExpenseTracker/views/profile.jsp\">" + loggedInUser.getName() + "</a></td>");
				sb.append("<td><input type=\"submit\" class=\"btn btn-logout\" value=\"Logout\" name=\"btnAction\" /></td>");
			}
			else
			{
				sb.append("<td><a href=\"/ExpenseTracker/views/profile.jsp\">" + loggedInUser.getName() + "</a></td>");
				sb.append("<td><input type=\"submit\" class=\"btn btn-logout\" value=\"Logout\" name=\"btnAction\" /></td>");
			}
		}

		return sb;
	}
}
