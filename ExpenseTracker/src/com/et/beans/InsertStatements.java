/**
 * Name: Pradeep Dharmavarapu
 * Class section: 605-782: Web Application Development with JSP and Servlets.
 * Thu 0430pm.
 * Team: Pradeep Dharmavarapu
 * Date: Apr 6, 2014 - 10:21:05 AM
 * Description: 605.782.
 */

package com.et.beans;

class InsertStatements
{
	private String insertIntoCategory = "";
	private String insertIntoExpense = "";
	private String insertIntoIncome = "";
	private String insertIntoPaymentSource = "";
	private String insertIntoRole = "";
	private String insertIntoUser = "";

	/**
	 * @return the insertIntoCategory
	 */
	private String getInsertIntoCategory()
	{
		this.insertIntoCategory = "INSERT INTO `expensetracker`.`category`" + "	(`CategoryId`,`Mandatory`)" + "	VALUES" + "	(<{CategoryId: }>,"
				+ "	<{Mandatory: }>);";
		return insertIntoCategory;
	}

	/**
	 * @return the insertIntoExpense
	 */
	private String getInsertIntoExpense()
	{
		this.insertIntoExpense = "INSERT INTO `expensetracker`.`expense`" + "	(`ExpenseId`," + "	`Description`," + "	`ExpenseDate`," + "	`Amount`,"
				+ "	`Review`," + "	`Posted`," + "	`fk_Expense_PaymentSourceId`," + "	`fk_Expense_CategoryId`," + "	`SystemDate`," + "	`Type`,"
				+ "	`fk_Expense_UserId`)" + "	VALUES" + "	(<{ExpenseId: }>," + "	<{Description: }>," + "	<{ExpenseDate: }>," + "	<{Amount: }>,"
				+ "	<{Review: }>," + "	<{Posted: }>," + "	<{fk_Expense_PaymentSourceId: }>," + "	<{fk_Expense_CategoryId: }>," + "	<{SystemDate: }>,"
				+ "	<{Type: }>," + "	<{fk_Expense_UserId: }>);";
		return insertIntoExpense;
	}

	/**
	 * @return the insertIntoIncome
	 */
	private String getInsertIntoIncome()
	{
		this.insertIntoIncome = "INSERT INTO `expensetracker`.`income`" + "	(`IncomeId`," + "	`Description`," + "	`IncomeDate`," + "	`Amount`,"
				+ "	`Review`," + "	`Posted`," + "	`fk_Income_CategoryId`," + "	`SystemDate`," + "	`Type`," + "	`fk_Income_UserId`)" + "	VALUES"
				+ "	(<{IncomeId: }>," + "	<{Description: }>," + "	<{IncomeDate: }>," + "	<{Amount: }>," + "	<{Review: }>," + "	<{Posted: }>,"
				+ "	<{fk_Income_CategoryId: }>," + "	<{SystemDate: }>," + "	<{Type: }>," + "	<{fk_Income_UserId: }>);";
		return insertIntoIncome;
	}

	/**
	 * @return the insertIntoPaymentSource
	 */
	private String getInsertIntoPaymentSource()
	{
		this.insertIntoPaymentSource = "INSERT INTO `expensetracker`.`paymentsource`" + "	(`PaymentSourceId`," + "	`TotalCredit`," + "	`AvailableCredit`,"
				+ "	`ExpDate`," + "	`Description`)" + "	VALUES" + "	(<{PaymentSourceId: }>," + "	<{TotalCredit: }>," + "	<{AvailableCredit: }>,"
				+ "	<{ExpDate: }>," + "	<{Description: }>);";
		return insertIntoPaymentSource;
	}

	/**
	 * @return the insertIntoRole
	 */
	private String getInsertIntoRole()
	{
		this.insertIntoRole = "	INSERT INTO `expensetracker`.`role`" + "	(`RoleId`," + "	`Description`)" + "	VALUES" + "	(<{RoleId: }>,"
				+ "	<{Description: }>);";
		return insertIntoRole;
	}

	/**
	 * @return the insertIntoUser
	 */
	private String getInsertIntoUser()
	{
		this.insertIntoUser = "	INSERT INTO `expensetracker`.`user`" + "	(`Name`," + "	`UserId`," + "	`Password`," + "	`Address`," + "	`fk_User_RoleId`,"
				+ "	`Approved`," + "	`Income`," + "	`Expense`)" + "	VALUES" + "	(<{Name: }>," + "	<{UserId: }>," + "	<{Password: }>," + "	<{Address: }>,"
				+ "	<{fk_User_RoleId: }>," + "	<{Approved: }>," + "	<{Income: }>," + "	<{Expense: }>);";
		return insertIntoUser;
	}

}
