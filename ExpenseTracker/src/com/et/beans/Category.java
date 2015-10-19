/**
 * Name: Pradeep Dharmavarapu
 * Class section: 605-782: Web Application Development with JSP and Servlets.
 * Thu 0430pm.
 * Team: Pradeep Dharmavarapu
 * Date: Apr 6, 2014 - 11:43:25 AM
 * Description: 605.782.
 */

package com.et.beans;

public class Category
{
	private String categoryId = "";
	private boolean mandatory = false;

	public Category()
	{
		super();
	}

	/**
	 * @return the categoryId
	 */
	public String getCategoryId()
	{
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
	 */
	public void setCategoryId(String categoryId)
	{
		this.categoryId = categoryId;
	}

	/**
	 * @return the mandatory
	 */
	public boolean isMandatory()
	{
		return mandatory;
	}

	/**
	 * @param mandatory
	 *            the mandatory to set
	 */
	public void setMandatory(boolean mandatory)
	{
		this.mandatory = mandatory;
	}

}
