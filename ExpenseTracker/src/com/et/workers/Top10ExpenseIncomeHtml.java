/**
 * Name: Pradeep Dharmavarapu
 * Class section: 605-782: Web Application Development with JSP and Servlets.
 * Thu 0430pm.
 * Team: Pradeep Dharmavarapu
 * Date: Apr 14, 2014 - 7:47:20 PM
 * Description: 605.782.
 */

package com.et.workers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.et.beans.Expense;
import com.et.beans.Income;
import com.et.dal.ExpenseDal;
import com.et.dal.IncomeDal;

public class Top10ExpenseIncomeHtml
{
	public StringBuffer getTop10Expenses(HttpSession session)
	{
		StringBuffer sb = new StringBuffer();
		ExpenseDal expenseDal = new ExpenseDal();
		ArrayList<Expense> expenses = new ArrayList<Expense>();
		expenses = expenseDal.getTop10Expenses(session);

		for (Expense expense : expenses)
		{
			sb.append("<tr class=\"viewtrans\">");
			sb.append("<td>" + expense.getDescription() + "</td>");
			sb.append("<td>" + expense.getExpenseDate() + "</td>");
			sb.append("<td class=\"amountstyle\">" + "$" + expense.getAmount() + "</td>");
			sb.append("<td>" + expense.isPosted() + "</td>");
			sb.append("<td>" + expense.getFkExpenseCategoryId() + "</td>");
			sb.append("<td>" + expense.getFkExpensePaymentSourceId() + "</td>");
			sb.append("<td><input class=\"btn btn-logout\" type=\"submit\" value=\"Edit\" name=\"" + expense.getExpenseId() + "\"/></td>");
			sb.append("</tr>");
		}

		return sb;
	}

	public StringBuffer getTop10Incomes(HttpSession session)
	{
		StringBuffer sb = new StringBuffer();
		IncomeDal incomeDal = new IncomeDal();
		ArrayList<Income> incomes = new ArrayList<Income>();

		incomes = incomeDal.getTop10Incomes(session);
		for (Income income : incomes)
		{
			sb.append("<tr class=\"viewtrans\">");
			sb.append("<td>" + income.getDescription() + "</td>");
			sb.append("<td>" + income.getIncomeDate() + "</td>");
			sb.append("<td class=\"amountstyle\">" + "$" + income.getAmount() + "</td>");
			sb.append("<td>" + income.isPosted() + "</td>");
			sb.append("<td>" + income.getFkIncomeCategoryId() + "</td>");
			sb.append("<td><input class=\"btn btn-logout\" type=\"submit\" value=\"Edit\" name=\"" + income.getIncomeId() + "\"/></td>");
			sb.append("</tr>");
		}

		return sb;
	}
}
