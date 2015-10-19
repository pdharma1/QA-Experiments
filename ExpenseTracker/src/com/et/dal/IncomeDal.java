/**
 * Name: Pradeep Dharmavarapu
 * Class section: 605-782: Web Application Development with JSP and Servlets.
 * Thu 0430pm.
 * Team: Pradeep Dharmavarapu
 * Date: Apr 13, 2014 - 8:30:41 PM
 * Description: 605.782.
 */

package com.et.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.et.beans.Income;
import com.et.beans.Mandatory;
import com.et.beans.User;

public class IncomeDal
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

	public ArrayList<Mandatory> getMandatoryIncomes(User user)
	{
		ArrayList<Mandatory> mandatoryIncomes = new ArrayList<Mandatory>();
		Mandatory iMandatory = new Mandatory();
		String sql = "select c.categoryId,e.description,e.IncomeDate,e.amount,e.fk_Income_CategoryId "
				+ "from ExpenseTracker.Category c "
				+ "left join ExpenseTracker.income e on c.CategoryId = e.fk_Income_CategoryId "
				+ "where e.fk_Income_userid is null or e.fk_Income_userid=?";

		ExpenseTrackerConnection conn = new ExpenseTrackerConnection();
		Connection connection = conn.getConnection();
		PreparedStatement ps;

		try
		{
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUserId());
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				iMandatory.setDescription(rs.getString("Description"));
				iMandatory.setDate(rs.getString("IncomeDate"));
				iMandatory.setAmount(rs.getDouble("amount"));
				iMandatory.setCategory(rs.getString("CategoryId"));
				mandatoryIncomes.add(iMandatory);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return mandatoryIncomes;

	}

	public double getAllTotalIncome(User user)
	{
		double incomeSummary = 0.0;
		ExpenseTrackerConnection conn = new ExpenseTrackerConnection();
		Connection connection = conn.getConnection();
		PreparedStatement ps;
		String sql = "select round(sum(amount),2) as TotalAmount "
				+ "from income where fk_income_UserId =?";
		try
		{
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUserId());
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				incomeSummary = rs.getDouble(1);
			}
		}
		catch (SQLException e)
		{
			incomeSummary = 0.0;
			System.out.println("Catch In Income summary method: " + e.getMessage());
			e.printStackTrace();
		}
		return incomeSummary;
	}

	public Map<String, String> getIncomeSummary(User user)
	{
		Map<String, String> incomeSummary = new HashMap<String, String>();
		ExpenseTrackerConnection conn = new ExpenseTrackerConnection();
		Connection connection = conn.getConnection();
		PreparedStatement ps;
		String sql = "select fk_income_categoryId, round(sum(amount),2) as TotalAmount "
				+ "from"
				+ " income where fk_income_UserId =?"
				+ " group by fk_income_categoryId";

		try
		{
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUserId());
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				String category = rs.getString("fk_income_categoryId");
				String totalAmount = rs.getString("TotalAmount");
				incomeSummary.put(category, totalAmount);
			}

		}
		catch (SQLException e)
		{
			System.out.println("In Income summary method: " + e.getMessage());
			e.printStackTrace();
		}

		return incomeSummary;
	}

	public boolean updateIncome(Income income)
	{
		ExpenseTrackerConnection conn = new ExpenseTrackerConnection();
		Connection connection = conn.getConnection();
		String exceptionMessage = "";
		PreparedStatement ps;
		boolean result = false;
		String sql = "UPDATE `ExpenseTracker`.`Income` SET "
				+ "`Description` = ?,"
				+ "`IncomeDate` = ?,"
				+ "`Amount` = ?,"
				+ "`Review` = ?,"
				+ "`Posted` = ?,"
				+ "`fk_Income_CategoryId` = ?,"
				+ "`SystemDate` = ?,"
				+ "`Type` = ?,"
				+ "`fk_Income_UserId` = ?"
				+ "WHERE `IncomeId` = ?";

		try
		{
			ps = connection.prepareStatement(sql);
			ps.setString(1, income.getDescription());
			ps.setString(2, income.getIncomeDate());
			ps.setDouble(3, income.getAmount());
			ps.setBoolean(4, income.isReview());
			ps.setBoolean(5, income.isPosted());
			ps.setString(6, income.getFkIncomeCategoryId());
			ps.setString(7, getCurrentDate());
			ps.setString(8, "Income");
			ps.setString(9, income.getFkIncomeUserId());
			ps.setInt(10, income.getIncomeId());

			int rs = ps.executeUpdate();
			if (rs > 0)
			{
				result = true;
			}
			else
			{
				result = false;
			}
		}
		catch (SQLException e)
		{
			result = false;
			System.out.println("In Income update method: " + e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	public Income getIncomeById(int incomeId, HttpSession session)
	{
		Income income = new Income();
		ExpenseTrackerConnection conn = new ExpenseTrackerConnection();
		Connection connection = conn.getConnection();
		PreparedStatement ps;

		String sql = "select * from  Income where IncomeId =?";

		try
		{
			ps = connection.prepareStatement(sql);
			ps.setInt(1, incomeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				income.setIncomeId(rs.getInt("incomeId"));
				income.setDescription(rs.getString("description"));
				income.setIncomeDate(rs.getString("incomedate"));
				income.setAmount(rs.getDouble("amount"));
				income.setReview((rs.getBoolean("review") ? true : false));
				income.setPosted((rs.getBoolean("posted") ? true : false));
				income.setFkIncomeCategoryId(rs.getString("fk_income_categoryid"));
				income.setType(rs.getString("type"));
				income.setFkIncomeUserId(rs.getString("fk_income_userid"));
			}
		}
		catch (SQLException e)
		{
			System.out.println("Exception from getIncomeById \n" + e.getMessage());
			income = null;
			e.printStackTrace();
		}

		return income;
	}

	public boolean saveIncome(Income income)
	{
		ExpenseTrackerConnection conn = new ExpenseTrackerConnection();
		Connection connection = conn.getConnection();
		PreparedStatement ps;
		boolean result = false;

		try
		{
			// HttpSession session = request.getSession();
			// User user = (User) session.getAttribute("loggedInUser");

			String sql = "INSERT INTO `ExpenseTracker`.`Income`"
					+ "(`Description`,"// 1
					+ "`IncomeDate`,"// 2
					+ "`Amount`,"// 3
					+ "`Review`,"// 4
					+ "`Posted`,"// 5
					+ "`fk_Income_CategoryId`,"// 6
					+ "`SystemDate`,"// 7
					+ "`Type`,"// 8
					+ "`fk_Income_UserId`)"// 9
					+ "VALUES"
					+ "(?,?,?,?,?,?,?,?,?)";

			try
			{
				ps = connection.prepareStatement(sql);
				ps.setString(1, income.getDescription());
				ps.setString(2, income.getIncomeDate());
				ps.setDouble(3, income.getAmount());

				if (income.isReview())
				{
					ps.setBoolean(4, true);
				}
				else
				{
					ps.setBoolean(4, false);
				}

				if (income.isPosted())
				{
					ps.setBoolean(5, true);
				}
				else
				{
					ps.setBoolean(5, false);
				}
				ps.setString(6, income.getFkIncomeCategoryId());
				ps.setString(7, income.getSystemDate());
				ps.setString(8, "Income");
				ps.setString(9, income.getFkIncomeUserId());
				// System.out.println(ps.toString());

				int rs = ps.executeUpdate();

				if (rs > 0)
				{
					result = true;
				}
				else
				{
					result = false;
				}
			}
			catch (SQLException e)
			{
				System.out.println(e.getMessage());
				System.out.println(e.getCause());
				result = false;
			}
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}

		return result;
	}

	public ArrayList<Income> getTop10Incomes(HttpSession session)
	{
		User user = (User) session.getAttribute("loggedInUser");
		ArrayList<Income> top10IncomeList = new ArrayList<Income>();
		ExpenseTrackerConnection conn = new ExpenseTrackerConnection();
		Connection connection = conn.getConnection();
		PreparedStatement ps;

		String sql = "select * from  Income where fk_income_userid = '" + user.getUserId() + "' order by SystemDate desc limit 10";

		try
		{
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				Income income = new Income();
				income.setIncomeId(rs.getInt("incomeid"));
				income.setDescription(rs.getString("description"));
				income.setIncomeDate(rs.getString("incomedate"));
				income.setAmount(rs.getDouble("amount"));
				income.setPosted((rs.getBoolean("posted") ? true : false));
				income.setFkIncomeCategoryId(rs.getString("fk_income_categoryid"));
				top10IncomeList.add(income);
			}
		}
		catch (SQLException e)
		{
			top10IncomeList = null;
		}

		return top10IncomeList;
	}
}
