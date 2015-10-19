package com.et.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.et.beans.Expense;
import com.et.dal.ExpenseDal;
import com.et.workers.ExtractExpenseFromRequest;

/**
 * Servlet implementation class EditExpense
 */
@WebServlet("/EditExpense")
public class EditExpense extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditExpense()
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String errorUrl = "./views/error.jsp";

		try
		{
			Expense expense = new Expense();
			HttpSession session = request.getSession();
			ExpenseDal expenseDal = new ExpenseDal();

			String expenseUrl = "./views/expense.jsp";

			ExtractExpenseFromRequest eefr = new ExtractExpenseFromRequest();
			int expenseId = eefr.getExpenseIdFromRequest(request);
			expense = expenseDal.getExpenseById(expenseId, session);

			if (expense != null)
			{
				session.setAttribute("expenseIdToBeUpdated", expenseId);
				session.setAttribute("expenseIdCorrespondingUserId", expense.getFkExpenseUserId());
				request.setAttribute("expenseToBeUpdated", expense);
				request.getRequestDispatcher(expenseUrl).forward(request, response);
			}
			else
			{
				request.getRequestDispatcher(errorUrl).forward(request, response);
			}
		}
		catch (Exception ex)
		{
			request.setAttribute("editExpenseError", "Error while editing Expense. Please try again later");
			request.getRequestDispatcher(errorUrl).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

}
