package com.et.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.et.beans.Income;
import com.et.dal.IncomeDal;
import com.et.workers.ExtractIncomeFromRequest;

/**
 * Servlet implementation class EditIncome
 */
@WebServlet("/EditIncome")
public class EditIncome extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditIncome()
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
			Income income = new Income();
			HttpSession session = request.getSession();
			IncomeDal incomeDal = new IncomeDal();

			String incomeUrl = "./views/income.jsp";

			ExtractIncomeFromRequest eifr = new ExtractIncomeFromRequest();
			int incomeId = eifr.getIncomeIdFromRequest(request);
			income = incomeDal.getIncomeById(incomeId, session);

			if (income != null)
			{
				session.setAttribute("incomeIdToBeUpdated", incomeId);
				session.setAttribute("incomeIdCorrespondingUserId", income.getFkIncomeUserId());
				request.setAttribute("incomeToBeUpdated", income);

				request.getRequestDispatcher(incomeUrl).forward(request, response);
			}
			else
			{
				request.getRequestDispatcher(errorUrl).forward(request, response);
			}
		}
		catch (Exception ex)
		{
			request.setAttribute("editIncomeError", "Error while editing Income. Please try again later");
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
