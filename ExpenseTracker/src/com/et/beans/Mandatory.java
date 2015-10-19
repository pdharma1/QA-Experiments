/**
 * Name: Pradeep Dharmavarapu
 * Class section: 605-782: Web Application Development with JSP and Servlets.
 * Thu 0430pm.
 * Team: Pradeep Dharmavarapu
 * Date: May 15, 2014 - 4:16:54 PM
 * Description: 605.782.
 */

package com.et.beans;

public class Mandatory
{
	private String description = "";
	private Double amount = 0.00;
	private String date = "";
	private String category = "";

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
	 * @return the expenseDate
	 */
	public String getDate()
	{
		return date;
	}

	/**
	 * @param expenseDate
	 *            the expenseDate to set
	 */
	public void setDate(String date1)
	{
		this.date = date1;
	}

	/**
	 * @return the category
	 */
	public String getCategory()
	{
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category)
	{
		this.category = category;
	}

}
