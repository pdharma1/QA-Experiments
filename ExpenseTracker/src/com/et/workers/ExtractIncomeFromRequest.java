/**
 * Name: Pradeep Dharmavarapu
 * Class section: 605-782: Web Application Development with JSP and Servlets.
 * Thu 0430pm.
 * Team: Pradeep Dharmavarapu
 * Date: Apr 14, 2014 - 12:17:51 AM
 * Description: 605.782.
 */

package com.et.workers;

import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.et.beans.Income;
import com.et.beans.User;

public class ExtractIncomeFromRequest
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

	public Income getIncomeFromRequest(HttpServletRequest request, HttpSession session)
	{
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int day = now.get(Calendar.DATE);
		String date = year + "-" + (month + 1) + "-" + day;

		User user = new User();
		user = (User) session.getAttribute("loggedInUser");
		Income income = new Income();
		income.setDescription(request.getParameter("txtIncDesc"));
		income.setIncomeDate(request.getParameter("dtIncDate"));
		income.setAmount(Double.parseDouble(request.getParameter("txtAmount")));
		income.setPosted(request.getParameter("ddlPosted").equals("0") ? false : true);
		income.setReview(request.getParameter("ddlReview").equals("0") ? false : true);
		income.setFkIncomeCategoryId(request.getParameter("ddlCategory"));
		income.setFkIncomeUserId(user.getUserId());
		income.setSystemDate(date);
		request.setAttribute("newIncomeToBeSaved", income);

		return income;
	}

	public HttpServletRequest getToBeUpdatedIncomeFromRequest(HttpServletRequest request, HttpSession session)
	{
		User user = new User();
		user = (User) session.getAttribute("loggedInUser");
		Income income = new Income();
		int incomeIdToBeUpdated = (int) session.getAttribute("incomeIdToBeUpdated");
		String incomeIdCorrespondingUserId = (String) session.getAttribute("incomeIdCorrespondingUserId");
		income.setIncomeId(incomeIdToBeUpdated);
		income.setDescription(request.getParameter("txtIncDesc"));
		income.setIncomeDate(request.getParameter("dtIncDate"));
		income.setAmount(Double.parseDouble(request.getParameter("txtAmount")));
		income.setPosted(request.getParameter("ddlPosted").equals("0") ? false : true);
		income.setReview(request.getParameter("ddlReview").equals("0") ? false : true);
		income.setFkIncomeCategoryId(request.getParameter("ddlCategory"));
		income.setFkIncomeUserId(incomeIdCorrespondingUserId);
		income.setSystemDate(getCurrentDate());
		request.setAttribute("incomeToBeUpdated", income);

		return request;
	}

	public int getIncomeIdFromRequest(HttpServletRequest request)
	{
		Enumeration<String> params = request.getParameterNames();
		String strIncomeId = "";
		while (params.hasMoreElements())
		{
			String temp = params.nextElement();
			if (request.getParameter(temp).equals("Edit"))
			{
				strIncomeId = temp;
			}
		}
		return Integer.parseInt(strIncomeId);
	}
}
