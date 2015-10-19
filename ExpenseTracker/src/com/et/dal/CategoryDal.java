/**
 * Name: Pradeep Dharmavarapu
 * Class section: 605-782: Web Application Development with JSP and Servlets.
 * Thu 0430pm.
 * Team: Pradeep Dharmavarapu
 * Date: Apr 13, 2014 - 11:47:32 AM
 * Description: 605.782.
 */

package com.et.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDal
{

	public boolean saveNewCategory(String category, boolean mandatory)
	{
		ExpenseTrackerConnection conn = new ExpenseTrackerConnection();
		Connection connection = conn.getConnection();
		PreparedStatement ps;
		boolean result = false;

		String sql = "INSERT INTO `ExpenseTracker`.`Category`"
				+ "(`CategoryId`,"
				+ "`Mandatory`)"
				+ " VALUES "
				+ "(?,?)";
		try
		{
			ps = connection.prepareStatement(sql);
			ps.setString(1, category);
			ps.setBoolean(2, mandatory);

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
			System.out.println(e.getMessage());
		}

		return result;
	}

	public ArrayList<String> getCategories()
	{
		ExpenseTrackerConnection conn = new ExpenseTrackerConnection();
		Connection connection = conn.getConnection();
		PreparedStatement ps;
		ArrayList<String> categories = new ArrayList<String>();
		String selectStatement = "select CategoryId from Category order by CategoryId asc";

		try
		{
			ps = connection.prepareStatement(selectStatement);
			ResultSet rs = ps.executeQuery(selectStatement);
			while (rs.next())
			{
				categories.add(rs.getString(1));
			}
			ps.close();

		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}

		return categories;
	}
}
