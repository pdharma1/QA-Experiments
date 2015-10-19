/**
 * Name: Pradeep Dharmavarapu
 * Class section: 605-782: Web Application Development with JSP and Servlets.
 * Thu 0430pm.
 * Team: Pradeep Dharmavarapu
 * Date: Apr 6, 2014 - 11:35:46 AM
 * Description: 605.782.
 */

package com.et.beans;

public class Role
{
	private String roleId = "";
	private String description = "";

	public Role()
	{
		super();
	}

	/**
	 * @return the roleId
	 */
	public String getRoleId()
	{
		return roleId;
	}

	/**
	 * @param roleId
	 *            the roleId to set
	 */
	public void setRoleId(String roleId)
	{
		this.roleId = roleId;
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

}
