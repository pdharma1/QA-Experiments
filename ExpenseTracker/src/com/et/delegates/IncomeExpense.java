package com.et.delegates;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.et.beans.User;
import com.et.dal.ExpenseDal;
import com.et.dal.IncomeDal;

/**
 * Servlet implementation class IncomeExpensePie
 */
@WebServlet("/IncomeExpense")
public class IncomeExpense extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IncomeExpense()
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		OutputStream out = response.getOutputStream();
		response.setContentType("image/png");
		User user = new User();
		HttpSession session = request.getSession();
		user = (User) session.getAttribute("loggedInUser");

		IncomeDal incomeDal = new IncomeDal();
		ExpenseDal expenseDal = new ExpenseDal();

		// create a dataset...
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Expense", expenseDal.getAllTotalExpense(user));
		dataset.setValue("Income", incomeDal.getAllTotalIncome(user));

		// create a chart...
		JFreeChart chart = ChartFactory.createPieChart(
				"Income Expense",
				dataset,
				true, // legend?
				true, // tooltips?
				false // URLs?
				);
		ChartUtilities.writeChartAsPNG(out, chart, 570, 300);
	}

}
