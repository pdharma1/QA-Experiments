/**
 * Name: Pradeep Dharmavarapu
 * Class section: 605-782: Web Application Development with JSP and Servlets.
 * Thu 0430pm.
 * Team: Pradeep Dharmavarapu
 * Date: Apr 6, 2014 - 11:22:38 AM
 * Description: 605.782.
 */

package com.et.beans;


public class Expense
{
	private int expenseId = 0;
	private String description = "";
	private String expenseDate;
	private Double amount = 0.0;
	private boolean review = false;
	private boolean posted = false;
	private String fkExpensePaymentSourceId = "";
	private String fkExpenseCategoryId = "";
	private String systemDate;
	private String type = "Expense";
	private String fkExpenseUserId = "";

	public Expense()
	{
		super();
	}

	/**
	 * @return the expenseId
	 */
	public int getExpenseId()
	{
		return expenseId;
	}

	/**
	 * @param expenseId
	 *            the expenseId to set
	 */
	public void setExpenseId(int expenseId)
	{
		this.expenseId = expenseId;
	}

	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * @return the expenseDate
	 */
	public String getExpenseDate()
	{
		return expenseDate;
	}

	/**
	 * @param expenseDate
	 *            the expenseDate to set
	 */
	public void setExpenseDate(String expenseDate)
	{
		this.expenseDate = expenseDate;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount()
	{
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(Double amount)
	{
		this.amount = amount;
	}

	/**
	 * @return the review
	 */
	public boolean isReview()
	{
		return review;
	}

	/**
	 * @param review
	 *            the review to set
	 */
	public void setReview(boolean review)
	{
		this.review = review;
	}

	/**
	 * @return the posted
	 */
	public boolean isPosted()
	{
		return posted;
	}

	/**
	 * @param posted
	 *            the posted to set
	 */
	public void setPosted(boolean posted)
	{
		this.posted = posted;
	}

	/**
	 * @return the fkExpensePaymentSourceId
	 */
	public String getFkExpensePaymentSourceId()
	{
		return fkExpensePaymentSourceId;
	}

	/**
	 * @param fkExpensePaymentSourceId
	 *            the fkExpensePaymentSourceId to set
	 */
	public void setFkExpensePaymentSourceId(String fkExpensePaymentSourceId)
	{
		this.fkExpensePaymentSourceId = fkExpensePaymentSourceId;
	}

	/**
	 * @return the fkExpenseCategoryId
	 */
	public String getFkExpenseCategoryId()
	{
		return fkExpenseCategoryId;
	}

	/**
	 * @param fkExpenseCategoryId
	 *            the fkExpenseCategoryId to set
	 */
	public void setFkExpenseCategoryId(String fkExpenseCategoryId)
	{
		this.fkExpenseCategoryId = fkExpenseCategoryId;
	}

	/**
	 * @return the systemDate
	 */
	public String getSystemDate()
	{
		return systemDate;
	}

	/**
	 * @param systemDate
	 *            the systemDate to set
	 */
	public void setSystemDate(String systemDate)
	{
		this.systemDate = systemDate;
	}

	/**
	 * @return the type
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * @return the fkExpenseUserId
	 */
	public String getFkExpenseUserId()
	{
		return fkExpenseUserId;
	}

	/**
	 * @param fkExpenseUserId
	 *            the fkExpenseUserId to set
	 */
	public void setFkExpenseUserId(String fkExpenseUserId)
	{
		this.fkExpenseUserId = fkExpenseUserId;
	}

}
