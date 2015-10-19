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

import com.et.beans.Expense;
import com.et.beans.Mandatory;
import com.et.beans.User;

public class ExpenseDal {
	private String getCurrentDate() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int day = now.get(Calendar.DATE);
		String date = year + "-" + (month + 1) + "-" + day;
		return date;
	}

	public ArrayList<Mandatory> getMandatoryExpenses(User user) {
		ArrayList<Mandatory> mandatoryExpenses = new ArrayList<Mandatory>();
		Mandatory mExpense = new Mandatory();

		ExpenseTrackerConnection conn = new ExpenseTrackerConnection();
		Connection connection = conn.getConnection();
		PreparedStatement ps;
		String sql = "select c.categoryId,e.description,e.expensedate,e.amount "
				+ "from ExpenseTracker.Category c "
				+ "left join ExpenseTracker.expense e on c.CategoryId = e.fk_Expense_CategoryId "
				+ "where e.fk_expense_userid is null or e.fk_expense_userid=?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUserId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				mExpense.setDescription(rs.getString("Description"));
				mExpense.setDate(rs.getString("expenseDate"));
				mExpense.setAmount(rs.getDouble("amount"));
				mExpense.setCategory(rs.getString("CategoryId"));
				mandatoryExpenses.add(mExpense);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mandatoryExpenses;

	}

	public double getAllTotalExpense(User user) {
		double expenseSummary = 0.0;
		ExpenseTrackerConnection conn = new ExpenseTrackerConnection();
		Connection connection = conn.getConnection();
		PreparedStatement ps;
		String sql = "select round(sum(amount),2) as TotalAmount from expense where fk_Expense_UserId =?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUserId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				expenseSummary = rs.getDouble(1);
			}
		} catch (SQLException e) {
			expenseSummary = 0.0;
			e.printStackTrace();
		}
		return expenseSummary;
	}

	public Map<String, String> getExpenseSummary(User user) {
		Map<String, String> expenseSummary = new HashMap<String, String>();
		ExpenseTrackerConnection conn = new ExpenseTrackerConnection();
		Connection connection = conn.getConnection();
		PreparedStatement ps;
		String sql = "select fk_expense_categoryId, round(sum(amount),2) as TotalAmount "
				+ "from expense where fk_Expense_UserId =?"
				+ " group by fk_expense_categoryId";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUserId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String category = rs.getString("fk_expense_categoryId");
				String totalAmount = rs.getString("TotalAmount");
				expenseSummary.put(category, totalAmount);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return expenseSummary;
	}

	public boolean updateExpense(Expense expense) {
		ExpenseTrackerConnection conn = new ExpenseTrackerConnection();
		Connection connection = conn.getConnection();
		String exceptionMessage = "";
		PreparedStatement ps;
		boolean result = false;
		String sql = "UPDATE `ExpenseTracker`.`Expense` SET "
				+ "`Description` = ?," + "`ExpenseDate` = ?," + "`Amount` = ?,"
				+ "`Review` = ?," + "`Posted` = ?,"
				+ "`fk_Expense_PaymentSourceId` = ?,"
				+ "`fk_Expense_CategoryId` = ?," + "`SystemDate` = ?,"
				+ "`Type` = ?," + "`fk_Expense_UserId` = ?"
				+ "WHERE `ExpenseId` = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, expense.getDescription());
			ps.setString(2, expense.getExpenseDate());
			ps.setDouble(3, expense.getAmount());
			ps.setBoolean(4, expense.isReview());
			ps.setBoolean(5, expense.isPosted());
			ps.setString(6, expense.getFkExpensePaymentSourceId());
			ps.setString(7, expense.getFkExpenseCategoryId());
			ps.setString(8, getCurrentDate());
			ps.setString(9, "Expense");
			ps.setString(10, expense.getFkExpenseUserId());
			ps.setInt(11, expense.getExpenseId());

			int rs = ps.executeUpdate();
			if (rs > 0) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}

		return result;
	}

	public boolean saveExpense(Expense expense) {
		ExpenseTrackerConnection conn = new ExpenseTrackerConnection();
		Connection connection = conn.getConnection();
		String exceptionMessage = "";
		PreparedStatement ps;
		boolean result = false;
		try {
			String sql = "INSERT INTO `expensetracker`.`expense` ("
					+ "	`Description`," // 1
					+ "	`ExpenseDate`,"// 2
					+ "	`Amount`,"// 3
					+ "	`Review`,"// 4
					+ "	`Posted`,"// 5
					+ "	`fk_Expense_PaymentSourceId`,"// 6
					+ "	`fk_Expense_CategoryId`,"// 7
					+ "	`SystemDate`,"// 8
					+ "	`Type`,"// 9
					+ "	`fk_Expense_UserId`)"// 10
					+ "	VALUES (?,?,?,?,?,?,?,?,?,?)";

			try {
				ps = connection.prepareStatement(sql);
				ps.setString(1, expense.getDescription());
				ps.setString(2, expense.getExpenseDate());
				ps.setDouble(3, expense.getAmount());

				if (expense.isReview()) {
					ps.setBoolean(4, true);
				} else {
					ps.setBoolean(4, false);
				}

				if (expense.isPosted()) {
					ps.setBoolean(5, true);
				} else {
					ps.setBoolean(5, false);
				}
				ps.setString(6, expense.getFkExpensePaymentSourceId());
				ps.setString(7, expense.getFkExpenseCategoryId());
				ps.setString(8, expense.getSystemDate());
				ps.setString(9, "Expense");
				ps.setString(10, expense.getFkExpenseUserId());

				int rs = ps.executeUpdate();

				if (rs > 0) {
					result = true;
				} else {
					result = false;
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println(e.getCause());
				result = false;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return result;
	}

	public ArrayList<Expense> getTop10Expenses(HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		ExpenseTrackerConnection conn = new ExpenseTrackerConnection();
		Connection connection = conn.getConnection();
		PreparedStatement ps;

		ArrayList<Expense> top10ExpenseList = new ArrayList<Expense>();
		String sql = "select * from  Expense where fk_expense_userid = '"
				+ user.getUserId() + "' order by SystemDate desc limit 10";

		try {
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Expense expense = new Expense();
				expense.setExpenseId(rs.getInt("expenseId"));
				expense.setDescription(rs.getString("description"));
				expense.setExpenseDate(rs.getString("expensedate"));
				expense.setAmount(rs.getDouble("amount"));
				expense.setPosted((rs.getBoolean("posted") ? true : false));
				expense.setFkExpenseCategoryId(rs
						.getString("fk_expense_categoryid"));
				expense.setFkExpensePaymentSourceId(rs
						.getString("fk_expense_paymentsourceid"));
				// expense.setType(rs.getString("type"));
				top10ExpenseList.add(expense);
			}
		} catch (SQLException e) {
			top10ExpenseList = null;
		}

		return top10ExpenseList;
	}

	public Expense getExpenseById(int expenseId, HttpSession session) {
		ExpenseTrackerConnection conn = new ExpenseTrackerConnection();
		Connection connection = conn.getConnection();
		PreparedStatement ps;

		String sql = "select * from  Expense where ExpenseId =?";
		Expense expense = new Expense();
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, expenseId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				expense.setExpenseId(rs.getInt("expenseId"));
				expense.setDescription(rs.getString("description"));
				expense.setExpenseDate(rs.getString("expensedate"));
				expense.setAmount(rs.getDouble("amount"));
				expense.setReview((rs.getBoolean("review") ? true : false));
				expense.setPosted((rs.getBoolean("posted") ? true : false));
				expense.setFkExpensePaymentSourceId(rs
						.getString("fk_expense_paymentsourceid"));
				expense.setFkExpenseCategoryId(rs
						.getString("fk_expense_categoryid"));
				expense.setType(rs.getString("type"));
				expense.setFkExpenseUserId(rs.getString("fk_expense_userid"));
			}
		} catch (SQLException e) {
			expense = null;
			e.printStackTrace();
		}

		return expense;
	}
}
