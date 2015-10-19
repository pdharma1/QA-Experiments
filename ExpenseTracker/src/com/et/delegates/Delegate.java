package com.et.delegates;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.et.beans.Expense;
import com.et.beans.Income;
import com.et.beans.User;
import com.et.dal.CategoryDal;
import com.et.dal.ExpenseDal;
import com.et.dal.IncomeDal;
import com.et.dal.PaymentSourceDal;
import com.et.dal.UserDal;
import com.et.workers.Emailer;
import com.et.workers.ExtractExpenseFromRequest;
import com.et.workers.ExtractIncomeFromRequest;
import com.et.workers.ExtractUserFromRequest;

/**
 * Servlet implementation class Delegate
 */
@WebServlet("/Delegate")
public class Delegate extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Delegate()
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			HttpSession session = request.getSession();
			Emailer emailer = new Emailer();

			User unRegisteredUser = new User();
			User registeredUser = new User();
			User loggedInUser = new User();
			UserDal userDal = new UserDal();

			ExtractIncomeFromRequest eifr = new ExtractIncomeFromRequest();
			IncomeDal incomeDal = new IncomeDal();

			ExtractExpenseFromRequest eefr = new ExtractExpenseFromRequest();
			ExpenseDal expenseDal = new ExpenseDal();

			response.setContentType("text/html");
			String regConfirmUrl = "./views/regconfirm.jsp";
			String errorUrl = "./views/error.jsp";
			String profileUrl = "./views/profile.jsp";
			String logoutUrl = "./views/login.jsp";
			String viewTransactions = "./views/viewtransactions.jsp";
			String admin = "./views/admin.jsp";

			switch (request.getParameter("btnAction"))
			{
				case "Save Payment Source": {
					PaymentSourceDal paymentSourceDal = new PaymentSourceDal();
					boolean paymentSourceInserted = paymentSourceDal
							.saveNewPaymentSource(request
									.getParameter("txtPaymentSourceName"), Double
									.parseDouble(request
											.getParameter("txtCreditLimit")),
									request.getParameter("txtExpDate"));

					if (paymentSourceInserted)
					{
						request.setAttribute("saveNewPaymentSource",
								paymentSourceInserted);
						request.getRequestDispatcher(admin).forward(request,
								response);
					}
					else
					{
						request.setAttribute("saveNewPaymentSource",
								paymentSourceInserted);
						request.getRequestDispatcher(admin).forward(request,
								response);
					}

					break;
				}

				case "Save New Category": {
					CategoryDal categoryDal = new CategoryDal();
					boolean categoryInserted = categoryDal
							.saveNewCategory(
									request.getParameter("txtNewCategory"),
									request.getParameter("rbtnMandatory").equals(
											"Yes") ? true : false);

					if (categoryInserted)
					{
						request.setAttribute("saveNewCategory", categoryInserted);
						request.getRequestDispatcher(admin).forward(request,
								response);
					}
					else
					{
						request.setAttribute("saveNewCategory", categoryInserted);
						request.getRequestDispatcher(admin).forward(request,
								response);
					}

					break;
				}

				case "Update Profile": {
					ExtractUserFromRequest eufr = new ExtractUserFromRequest();
					User user = new User();
					user = eufr.extractProfileUser(request);
					boolean userUpdated = userDal.updateUser(user);
					if (userUpdated)
					{
						request.setAttribute("userUpdated",
								"User update successful");
						session.setAttribute("loggedInUser", user);
						// Enumeration<String> attrEnum =
						// session.getAttributeNames();
						// while (attrEnum.hasMoreElements())
						// {
						// String attrName = attrEnum.nextElement();
						// session.removeAttribute(attrName);
						// }

						// response.sendRedirect(logoutUrl);
						request.getRequestDispatcher(profileUrl).forward(request,
								response);
					}
					else
					{
						request.setAttribute("userUpdated",
								"User update 'not' successful");
						request.getRequestDispatcher(errorUrl).forward(request,
								response);
					}

					break;
				}

				case "Update Income": {
					Income income = new Income();
					request = eifr
							.getToBeUpdatedIncomeFromRequest(request, session);
					income = (Income) request.getAttribute("incomeToBeUpdated");

					boolean expenseUpdated = incomeDal.updateIncome(income);
					if (expenseUpdated)
					{
						session.setAttribute("incomeToBeUpdated", null);
						session.setAttribute("incomeIdToBeUpdated", null);
						session.setAttribute("incomeIdCorrespondingUserId", null);
						request.getRequestDispatcher(viewTransactions).forward(
								request, response);
					}
					else
					{
						request.getRequestDispatcher(errorUrl).forward(request,
								response);
					}

					break;
				}

				case "Update Expense": {
					Expense expense = new Expense();
					request = eefr.getToBeUpdatedExpenseFromRequest(request,
							session);
					expense = (Expense) request.getAttribute("expenseToBeUpdated");

					boolean expenseUpdated = expenseDal.updateExpense(expense);
					if (expenseUpdated)
					{
						session.setAttribute("expenseToBeUpdated", null);
						session.setAttribute("expenseIdToBeUpdated", null);
						session.setAttribute("expenseIdCorrespondingUserId", null);
						request.getRequestDispatcher(viewTransactions).forward(
								request, response);
					}
					else
					{
						request.getRequestDispatcher(errorUrl).forward(request,
								response);
					}

					break;
				}
				case "Save Income": {
					Income income = new Income();
					income = eifr.getIncomeFromRequest(request, session);
					boolean incomeSaved = incomeDal.saveIncome(income);
					if (incomeSaved)
					{
						request.getRequestDispatcher(viewTransactions).forward(
								request, response);
					}
					else
					{
						request.getRequestDispatcher(errorUrl).forward(request,
								response);
					}
					break;
				}

				case "Save Expense": {
					Expense expense = new Expense();

					expense = eefr.getExpenseFromRequest(request, session);
					boolean expenseSaved = expenseDal.saveExpense(expense);
					if (expenseSaved)
					{
						request.getRequestDispatcher(viewTransactions).forward(
								request, response);
					}
					else
					{
						request.getRequestDispatcher(errorUrl).forward(request,
								response);
					}
					break;
				}

				case "Logout": {
					Enumeration<String> attrEnum = session.getAttributeNames();
					while (attrEnum.hasMoreElements())
					{
						String attrName = attrEnum.nextElement();
						session.removeAttribute(attrName);
					}

					response.sendRedirect(logoutUrl);
					break;
				}

				case "Register": {
					ExtractUserFromRequest eufr = new ExtractUserFromRequest();
					unRegisteredUser = eufr.extractRegistrationUser(request);
					boolean rs = userDal.saveUser(unRegisteredUser);

					if (rs)
					{
						registeredUser = userDal.getUserByUserId(unRegisteredUser
								.getUserId());
						session.setAttribute("registeredUser", registeredUser);
						boolean emailResult = emailer.emailRegistrationEmailNow(
								registeredUser, "Registration");
						if (emailResult)
						{
							request.getRequestDispatcher(regConfirmUrl).forward(
									request, response);
						}
						else
						{
							request.setAttribute(
									"sendEmailError",
									"There was an error while sending email. However User registration is successful.");
							request.getRequestDispatcher(errorUrl).forward(request,
									response);
						}
					}
					else
					{
						request.setAttribute(
								"registrationMessage",
								"Either the user exists already or there is some other issue. Please touch base later.");
						request.getRequestDispatcher(errorUrl).forward(request,
								response);
					}
					break;
				}
				case "Login": {
					loggedInUser = userDal.validateUser(
							request.getParameter("txtUsername"),
							request.getParameter("txtPassword"));
					if (loggedInUser != null)
					{
						session.setAttribute("loggedInUser", loggedInUser);
						request.getRequestDispatcher(profileUrl).forward(request,
								response);
					}
					else
					{
						request.setAttribute(
								"loginValidationMessage",
								"User with id: '"
										+ request.getParameter("txtUsername")
										+ "' does not exist or you entered incorrect password or there is some other issue. Please touch base later.");
						request.getRequestDispatcher(errorUrl).forward(request,
								response);
					}

					break;
				}
				default: {
					request.getRequestDispatcher(errorUrl).forward(request,
							response);
					break;
				}
			}
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

}
