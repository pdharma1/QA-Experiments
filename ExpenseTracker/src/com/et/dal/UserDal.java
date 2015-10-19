/**
 * Name: Pradeep Dharmavarapu
 * Class section: 605-782: Web Application Development with JSP and Servlets.
 * Thu 0430pm.
 * Team: Pradeep Dharmavarapu
 * Date: Apr 6, 2014 - 3:24:42 PM
 * Description: 605.782.
 */

package com.et.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.et.beans.User;

public class UserDal
{

	public boolean updateUser(User user)
	{
		ExpenseTrackerConnection etConnection = new ExpenseTrackerConnection();
		Connection connection = etConnection.getConnection();
		PreparedStatement ps;
		boolean result = false;
		String sql = "UPDATE `ExpenseTracker`.`User` SET "
				+ "`Name` = ?,"
				+ "`Password` = ?,"
				+ "`Address` = ?,"
				+ "`Income` = ?,"
				+ "`Expense` = ?"
				+ " WHERE `UserId` = ?";

		try
		{
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getAddress());
			ps.setBoolean(4, user.isIncome());
			ps.setBoolean(5, user.isExpense());
			ps.setString(6, user.getUserId());

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
		}

		return result;
	}

	public boolean saveUser(User unRegisteredUser)
	{
		ExpenseTrackerConnection etConnection = new ExpenseTrackerConnection();
		Connection sqlconn = etConnection.getConnection();
		PreparedStatement ps;

		boolean result = false;
		String income = "";
		String expense = "";
		String approved = "";
		String insertUnRegisteredUser = "INSERT INTO `user` " +
				"("
				+ "`Name`," +
				"`UserId`," +
				"`Password`," +
				"`Address`," +
				"`fk_User_RoleId`," +
				"`Approved`," +
				"`Income`," +
				"`Expense`)" +
				" VALUES (?,?,?,?,?,?,?,?)";

		try
		{
			ps = sqlconn.prepareStatement(insertUnRegisteredUser);
			ps.setString(1, unRegisteredUser.getName());
			ps.setString(2, unRegisteredUser.getUserId());
			ps.setString(3, unRegisteredUser.getPassword());
			ps.setString(4, unRegisteredUser.getAddress());
			ps.setString(5, unRegisteredUser.getFkUserRoleId());

			if (unRegisteredUser.isApproved())
			{
				approved = "1";
			}
			else
			{
				approved = "0";
			}
			ps.setString(6, approved);

			if (unRegisteredUser.isIncome())
			{
				income = "1";
			}
			else
			{
				income = "0";
			}

			ps.setString(7, income);

			if (unRegisteredUser.isExpense())
			{
				expense = "1";
			}
			else
			{
				expense = "0";
			}

			ps.setString(8, expense);
			int res = ps.executeUpdate();

			if (res > 0)
			{
				result = true;
			}
			sqlconn.close();
		}
		catch (SQLException e)
		{
			try
			{
				sqlconn.rollback();
			}
			catch (SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
			System.out.println(e.getMessage());
		}
		return result;

	}

	public User getUserById(int id)
	{
		ExpenseTrackerConnection etConnection = new ExpenseTrackerConnection();
		Connection sqlconn = etConnection.getConnection();

		User user = new User();
		String select = "select Id, name,userid,password,address,fk_user_roleid,approved,income,expense from user where id=?";

		try
		{
			PreparedStatement ps = sqlconn.prepareStatement(select);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				user.setId(rs.getInt("Id"));
				user.setName(rs.getString("name"));
				user.setUserId(rs.getString("userid"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setFkUserRoleId(rs.getString("fk_user_roleid"));
				user.setApproved(rs.getBoolean("approved") == true ? true : false);
				user.setIncome(rs.getBoolean("income") == true ? true : false);
				user.setExpense(rs.getBoolean("expense") == true ? true : false);
			}
			sqlconn.close();
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}

		return user;
	}

	public User getUserByUserId(String email)
	{
		ExpenseTrackerConnection etConnection = new ExpenseTrackerConnection();
		Connection sqlconn = etConnection.getConnection();

		User user = new User();
		String select = "select Id, name,userid,password,address,fk_user_roleid,approved,income,expense from user where userid=?";

		try
		{
			PreparedStatement ps = sqlconn.prepareStatement(select);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				user.setId(rs.getInt("Id"));
				user.setName(rs.getString("name"));
				user.setUserId(rs.getString("userid"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setFkUserRoleId(rs.getString("fk_user_roleid"));
				user.setApproved(rs.getBoolean("approved") == true ? true : false);
				user.setIncome(rs.getBoolean("income") == true ? true : false);
				user.setExpense(rs.getBoolean("expense") == true ? true : false);
			}
			sqlconn.close();
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}

		return user;
	}

	private User getNewlyInsertedUser()
	{
		ExpenseTrackerConnection etConnection = new ExpenseTrackerConnection();
		Connection sqlconn = etConnection.getConnection();

		User user = new User();
		String select = "select Id, name,userid,password,address,fk_user_roleid,approved,income,expense from user order by Id desc limit 1";

		try
		{
			PreparedStatement ps = sqlconn.prepareStatement(select);
			ResultSet rs = ps.executeQuery(select);
			while (rs.next())
			{
				user.setId(rs.getInt("Id"));
				user.setName(rs.getString("name"));
				user.setUserId(rs.getString("userid"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setFkUserRoleId(rs.getString("fk_user_roleid"));

				user.setApproved(rs.getString("approved") == "1" ? true : false);
				user.setIncome(rs.getString("income") == "1" ? true : false);
				user.setExpense(rs.getString("expense") == "1" ? true : false);
			}
			sqlconn.close();
		}
		catch (Exception ex)
		{
			try
			{
				sqlconn.rollback();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}

		return user;
	}

	public boolean isApproved(String email)
	{
		ExpenseTrackerConnection etConnection = new ExpenseTrackerConnection();
		Connection sqlconn = etConnection.getConnection();

		boolean result = false;
		boolean approved = false;
		String select = "select approved from User where UserId=?";

		try
		{
			PreparedStatement ps = sqlconn.prepareStatement(select);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				approved = rs.getBoolean(1);
			}

			if (approved)
			{
				result = true;
			}
			else
			{
				result = false;
			}
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return result;
	}

	public ArrayList<User> getToBeApprovedUsers()
	{
		ArrayList<User> unApprovedUsers = new ArrayList<User>();
		ExpenseTrackerConnection etConnection = new ExpenseTrackerConnection();
		Connection sqlconn = etConnection.getConnection();

		String select = "select Id, name,userid,password,address,fk_user_roleid,approved,income,expense from user where approved=0";
		try
		{
			PreparedStatement ps = sqlconn.prepareStatement(select);
			ResultSet rs = ps.executeQuery();

			if (rs == null)
			{
				unApprovedUsers = null;
			}
			else
			{
				while (rs.next())
				{
					User user = new User();
					user.setId(rs.getInt("Id"));
					user.setName(rs.getString("name"));
					user.setUserId(rs.getString("userid"));
					user.setAddress(rs.getString("address"));
					user.setFkUserRoleId(rs.getString("fk_user_roleid"));
					user.setApproved(rs.getBoolean("approved") == true ? true : false);
					user.setIncome(rs.getBoolean("income") == true ? true : false);
					user.setExpense(rs.getBoolean("expense") == true ? true : false);
					unApprovedUsers.add(user);
				}
			}
		}
		catch (Exception ex)
		{
			return null;
		}
		return unApprovedUsers;
	}

	public User validateUser(String username, String password)
	{
		User user = new User();
		ExpenseTrackerConnection etConnection = new ExpenseTrackerConnection();
		Connection sqlconn = etConnection.getConnection();

		String select = "select Id, name,userid,password,address,fk_user_roleid,approved,income,expense from user where userid=? and password=?";
		try
		{
			PreparedStatement ps = sqlconn.prepareStatement(select);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				user.setId(rs.getInt("Id"));
				user.setName(rs.getString("name"));
				user.setUserId(rs.getString("userid"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setFkUserRoleId(rs.getString("fk_user_roleid"));
				user.setApproved(rs.getBoolean("approved") == true ? true : false);
				user.setIncome(rs.getBoolean("income") == true ? true : false);
				user.setExpense(rs.getBoolean("expense") == true ? true : false);
			}

			if ((user.getUserId() == "") && (user.getPassword() == ""))
			{
				user = null;
			}
		}
		catch (Exception ex)
		{
			user = null;
		}
		return user;
	}

	public boolean updateUserApprovedFlag(String email)
	{
		boolean result = false;

		ExpenseTrackerConnection etConnection = new ExpenseTrackerConnection();
		Connection sqlconn = etConnection.getConnection();

		String update = "UPDATE `ExpenseTracker`.`User` SET `Approved` = 1 WHERE `UserId` = ?";
		PreparedStatement ps;
		try
		{
			ps = sqlconn.prepareStatement(update);
			ps.setString(1, email);
			int rs = ps.executeUpdate();
			if (rs > 0)
			{
				result = true;
			}
		}
		catch (SQLException ex)
		{
			result = false;
			ex.printStackTrace();
		}
		return result;
	}

	public boolean deleteUser(String email)
	{
		boolean result = false;

		ExpenseTrackerConnection etConnection = new ExpenseTrackerConnection();
		Connection sqlconn = etConnection.getConnection();
		System.out.println("In deleteUser method");

		String update = "DELETE FROM `ExpenseTracker`.`User` WHERE `UserId` =?";
		PreparedStatement ps;
		try
		{
			ps = sqlconn.prepareStatement(update);
			ps.setString(1, email);
			int rs = ps.executeUpdate();
			if (rs > 0)
			{
				result = true;
			}
		}
		catch (SQLException ex)
		{
			result = false;
			ex.printStackTrace();
		}
		return result;
	}
}
