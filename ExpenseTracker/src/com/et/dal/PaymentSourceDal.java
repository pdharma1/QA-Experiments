/**
 * Name: Pradeep Dharmavarapu
 * Class section: 605-782: Web Application Development with JSP and Servlets.
 * Thu 0430pm.
 * Team: Pradeep Dharmavarapu
 * Date: Apr 13, 2014 - 8:56:15 PM
 * Description: 605.782.
 */

package com.et.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentSourceDal
{

	public boolean saveNewPaymentSource(String paymentSourceId, double totalCredit, String expDate)
	{
		ExpenseTrackerConnection conn = new ExpenseTrackerConnection();
		Connection connection = conn.getConnection();
		PreparedStatement ps;
		boolean result = false;

		String sql = "INSERT INTO `ExpenseTracker`.`PaymentSource` "
				+ "(`PaymentSourceId`, "
				+ "`TotalCredit`, "
				+ "`AvailableCredit`,"
				+ "`ExpDate`,"
				+ "`Description`)"
				+ "VALUES"
				+ "("
				+ "?,"
				+ "?,"
				+ "?,"
				+ "?,"
				+ "?"
				+ ");";
		try
		{
			ps = connection.prepareStatement(sql);
			ps.setString(1, paymentSourceId);
			ps.setDouble(2, totalCredit);
			ps.setDouble(3, 0.00);
			ps.setString(4, expDate);
			ps.setString(5, "");

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

	public ArrayList<String> getPaymentSources()
	{
		ExpenseTrackerConnection conn = new ExpenseTrackerConnection();
		Connection connection = conn.getConnection();
		PreparedStatement ps;

		ArrayList<String> paymentSources = new ArrayList<String>();
		String selectStatement = "SELECT paymentsourceid FROM ExpenseTracker.PaymentSource order by paymentsourceid asc";

		try
		{
			ps = connection.prepareStatement(selectStatement);
			ResultSet rs = ps.executeQuery(selectStatement);
			while (rs.next())
			{
				paymentSources.add(rs.getString(1));
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return paymentSources;
	}

}
