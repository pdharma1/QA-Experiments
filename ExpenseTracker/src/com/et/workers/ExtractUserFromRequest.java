/**
 * Name: Pradeep Dharmavarapu
 * Class section: 605-782: Web Application Development with JSP and Servlets.
 * Thu 0430pm.
 * Team: Pradeep Dharmavarapu
 * Date: Apr 6, 2014 - 5:01:00 PM
 * Description: 605.782.
 */

package com.et.workers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.et.beans.User;

public class ExtractUserFromRequest
{
	public User extractRegistrationUser(HttpServletRequest request)
	{
		User user = new User();
		user.setName(request.getParameter("txtName"));
		user.setUserId(request.getParameter("txtEmail"));
		user.setPassword(request.getParameter("txtPassword"));
		user.setAddress(request.getParameter("txtAddress"));
		user.setFkUserRoleId(request.getParameter("ddlRole"));
		user.setApproved(false);
		user.setIncome(request.getParameter("chkIncome") == null ? false : true);
		user.setExpense(request.getParameter("chkExpense") == null ? false : true);

		return user;
	}

	public User extractProfileUser(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		User user = new User();
		user.setName(request.getParameter("txtEditedName"));
		user.setUserId(loggedInUser.getUserId());
		user.setPassword(request.getParameter("txtNewPassword"));
		user.setAddress(request.getParameter("txtEditedAddress"));
		user.setIncome(request.getParameter("chkIncome") == null ? false : true);
		user.setExpense(request.getParameter("chkExpense") == null ? false : true);

		return user;
	}
}
