/**
 * Name: Pradeep Dharmavarapu
 * Class section: 605-782: Web Application Development with JSP and Servlets.
 * Thu 0430pm.
 * Team: Pradeep Dharmavarapu
 * Date: Apr 6, 2014 - 12:34:24 PM
 * Description: 605.782.
 */

package com.et.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExpenseTrackerConnection
{
	/*
	 * Windows login credentials
	 * private static String url = "jdbc:mysql://Deema-XPS-PC:3306/expensetracker";
	 * private static String username = "mbp";
	 * private static String password = "root";
	 */

	static String username = "root";
	static String password = "";
	static String exceptionMessage = "";
	Connection connection;

	public Connection getConnection()
	{
		try
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensetracker", username, password);
			}
			catch (ClassNotFoundException e)
			{
				exceptionMessage = e.getMessage();
			}

			return (connection);
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
			return null;
		}
	}
}
