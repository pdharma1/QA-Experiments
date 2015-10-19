/**
 * Name: Pradeep Dharmavarapu
 * Class section: 605-782: Web Application Development with JSP and Servlets.
 * Thu 0430pm.
 * Team: Pradeep Dharmavarapu
 * Date: Apr 6, 2014 - 11:22:29 AM
 * Description: 605.782.
 */

package com.et.beans;


public class Income
{
	private int incomeId = 0;
	private String description = "";
	private String incomeDate;
	private Double amount = 0.0;
	private boolean review = false;
	private boolean posted = false;
	private String fkIncomeCategoryId = "";
	private String systemDate;
	private String type = "Income";
	private String fkIncomeUserId = "";

	public Income()
	{
		super();
	}

	/**
	 * @return the incomeId
	 */
	public int getIncomeId()
	{
		return incomeId;
	}

	/**
	 * @param incomeId
	 *            the incomeId to set
	 */
	public void setIncomeId(int incomeId)
	{
		this.incomeId = incomeId;
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
	 * @return the incomeDate
	 */
	public String getIncomeDate()
	{
		return incomeDate;
	}

	/**
	 * @param incomeDate
	 *            the incomeDate to set
	 */
	public void setIncomeDate(String incomeDate)
	{
		this.incomeDate = incomeDate;
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
	 * @return the fkIncomeCategoryId
	 */
	public String getFkIncomeCategoryId()
	{
		return fkIncomeCategoryId;
	}

	/**
	 * @param fkIncomeCategoryId
	 *            the fkIncomeCategoryId to set
	 */
	public void setFkIncomeCategoryId(String fkIncomeCategoryId)
	{
		this.fkIncomeCategoryId = fkIncomeCategoryId;
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
	 * @return the fkIncomeUserId
	 */
	public String getFkIncomeUserId()
	{
		return fkIncomeUserId;
	}

	/**
	 * @param fkIncomeUserId
	 *            the fkIncomeUserId to set
	 */
	public void setFkIncomeUserId(String fkIncomeUserId)
	{
		this.fkIncomeUserId = fkIncomeUserId;
	}

}
