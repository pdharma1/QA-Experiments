/**
 * Name: Pradeep Dharmavarapu
 * Class section: 605-782: Web Application Development with JSP and Servlets.
 * Thu 0430pm.
 * Team: Pradeep Dharmavarapu
 * Date: Apr 13, 2014 - 10:15:43 PM
 * Description: 605.782.
 */

package com.et.workers;

import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.et.beans.Expense;
import com.et.beans.User;

public class ExtractExpenseFromRequest
{
	private String getCurrentDate()
	{
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int day = now.get(Calendar.DATE);
		String date = year + "-" + (month + 1) + "-" + day;

		return date;
	}

	public Expense getExpenseFromRequest(HttpServletRequest request, HttpSession session)
	{
		User user = new User();
		user = (User) session.getAttribute("loggedInUser");
		Expense expense = new Expense();
		expense.setDescription(request.getParameter("txtExpDesc"));
		expense.setExpenseDate(request.getParameter("dtExpDate"));
		expense.setAmount(Double.parseDouble(request.getParameter("txtAmount")));
		expense.setFkExpensePaymentSourceId(request.getParameter("ddlPaymentSource"));
		expense.setPosted(request.getParameter("ddlPosted").equals("0") ? false : true);
		expense.setReview(request.getParameter("ddlReview").equals("0") ? false : true);
		expense.setFkExpenseCategoryId(request.getParameter("ddlCategory"));
		expense.setFkExpenseUserId(user.getUserId());
		expense.setSystemDate(getCurrentDate());

		return expense;
	}

	public HttpServletRequest getToBeUpdatedExpenseFromRequest(HttpServletRequest request, HttpSession session)
	{
		User user = new User();
		user = (User) session.getAttribute("loggedInUser");
		Expense expense = new Expense();
		int expenseIdToBeUpdated = (int) session.getAttribute("expenseIdToBeUpdated");
		String expenseIdCorrespondingUserId = (String) session.getAttribute("expenseIdCorrespondingUserId");
		expense.setExpenseId(expenseIdToBeUpdated);
		expense.setDescription(request.getParameter("txtExpDesc"));
		expense.setExpenseDate(request.getParameter("dtExpDate"));
		expense.setAmount(Double.parseDouble(request.getParameter("txtAmount")));
		expense.setFkExpensePaymentSourceId(request.getParameter("ddlPaymentSource"));
		expense.setPosted(request.getParameter("ddlPosted").equals("0") ? false : true);
		expense.setReview(request.getParameter("ddlReview").equals("0") ? false : true);
		expense.setFkExpenseCategoryId(request.getParameter("ddlCategory"));
		expense.setFkExpenseUserId(expenseIdCorrespondingUserId);
		expense.setSystemDate(getCurrentDate());
		request.setAttribute("expenseToBeUpdated", expense);

		return request;
	}

	public int getExpenseIdFromRequest(HttpServletRequest request)
	{
		Enumeration<String> params = request.getParameterNames();
		String strExpenseId = "";
		while (params.hasMoreElements())
		{
			String temp = params.nextElement();
			if (request.getParameter(temp).equals("Edit"))
			{
				strExpenseId = temp;
			}
		}
		return Integer.parseInt(strExpenseId);
	}
}
