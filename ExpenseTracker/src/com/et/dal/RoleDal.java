/**
 * Name: Pradeep Dharmavarapu
 * Class section: 605-782: Web Application Development with JSP and Servlets.
 * Thu 0430pm.
 * Team: Pradeep Dharmavarapu
 * Date: Apr 6, 2014 - 12:34:08 PM
 * Description: 605.782.
 */

package com.et.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoleDal
{

	public ArrayList<String> getRoles()
	{
		ExpenseTrackerConnection conn = new ExpenseTrackerConnection();
		Connection connection = conn.getConnection();
		PreparedStatement ps;
		ArrayList<String> roles = new ArrayList<String>();
		String selectStatement = "select RoleId from Role order by RoleId desc";

		try
		{
			ps = connection.prepareStatement(selectStatement);
			ResultSet rs = ps.executeQuery(selectStatement);
			while (rs.next())
			{
				roles.add(rs.getString(1));
			}
			ps.close();
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}

		return roles;
	}
}
