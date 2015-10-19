/**
 * Name: Pradeep Dharmavarapu
 * Class section: 605-782: Web Application Development with JSP and Servlets.
 * Thu 0430pm.
 * Team: Pradeep Dharmavarapu
 * Date: Apr 6, 2014 - 11:40:18 AM
 * Description: 605.782.
 */

package com.et.beans;

public class User
{
	private int id = 0;
	private String name = "";
	private String userId = "";
	private String password = "";
	private String address = "";
	private String fkUserRoleId = "";
	private boolean approved = false;
	private boolean income = false;
	private boolean expense = false;

	public User()
	{
		super();
	}

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the userId
	 */
	public String getUserId()
	{
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * @return the address
	 */
	public String getAddress()
	{
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address)
	{
		this.address = address;
	}

	/**
	 * @return the fkUserRoleId
	 */
	public String getFkUserRoleId()
	{
		return fkUserRoleId;
	}

	/**
	 * @param fkUserRoleId
	 *            the fkUserRoleId to set
	 */
	public void setFkUserRoleId(String fkUserRoleId)
	{
		this.fkUserRoleId = fkUserRoleId;
	}

	/**
	 * @return the approved
	 */
	public boolean isApproved()
	{
		return approved;
	}

	/**
	 * @param approved
	 *            the approved to set
	 */
	public void setApproved(boolean approved)
	{
		this.approved = approved;
	}

	/**
	 * @return the income
	 */
	public boolean isIncome()
	{
		return income;
	}

	/**
	 * @param income
	 *            the income to set
	 */
	public void setIncome(boolean income)
	{
		this.income = income;
	}

	/**
	 * @return the expense
	 */
	public boolean isExpense()
	{
		return expense;
	}

	/**
	 * @param expense
	 *            the expense to set
	 */
	public void setExpense(boolean expense)
	{
		this.expense = expense;
	}

}
