package com.et.delegates;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.et.beans.User;
import com.et.dal.IncomeDal;

/**
 * Servlet implementation class IncomeBreakdownBar
 */
@WebServlet("/IncomeBreakdown")
public class IncomeBreakdown extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IncomeBreakdown()
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
		Map<String, String> incomeBreakdown = new HashMap<String, String>();
		incomeBreakdown = incomeDal.getIncomeSummary(user);

		// create a dataset...
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (Entry<String, String> entry : incomeBreakdown.entrySet())
		{
			dataset.addValue(Double.parseDouble(entry.getValue()), entry.getKey(), "");
		}

		// create a chart...
		final JFreeChart chart = ChartFactory.createBarChart(
				"Income Breakdown", // chart title
				"Category", // domain axis label
				"Value", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL,
				true, // include legend
				true, // tooltips?
				false // URLs?
				);
		ChartUtilities.writeChartAsPNG(out, chart, 570, 300);
	}

}
