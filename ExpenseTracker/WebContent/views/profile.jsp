<%@ include file="/views/header.jsp"%>
<%@ page import="com.et.beans.User"%>
<%
	User user = new User();
	user = (User) session.getAttribute("loggedInUser");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="/ExpenseTracker/css/index.css" rel="stylesheet" type="text/css">
<title>Profile</title>
</head>
<body>
	<div>
		<form method="post" action="/ExpenseTracker/Delegate">
			<fieldset>
				<legend>
					<h3>
						Edit
						<%=user.getName()%>
						Profile
					</h3>
				</legend>
				<%
					if (!user.isApproved())
					{
						out.println("<table><tr><td><h3><p><i>NOTE: Your access is pending Approval. Please sit tight until the Admin approves your request.</i></p></h3></td></tr></table>");
					}
				%>
				<table>
				<tr><td><p>NOTE:</p></td></tr>
					<tr>
						<td>
								<ul><li><i>For security reasons profile changes will signout users. Please relogin.</i></li>
								<li><i>Reports are displayed to users with both Income and Expense services. </i></li></ul>
								
							</td>
					</tr>
				</table>
				<table>
					<tr>
						<td><label>Name</label></td>
						<td><input type="text" name="txtEditedName" value=<%=user.getName()%> required /></td>
					</tr>
					<tr>
						<td><label>Password</label></td>
						<td><input type="PASSWORD" name="txtNewPassword" placeholder="New password" required /></td>
					</tr>
					<tr>
						<td><label>Address</label></td>
						<td><input type="text" name="txtEditedAddress" value=<%=user.getAddress()%> required /></td>
					</tr>
					<tr>
						<td><input id="chkExpense" type="checkbox" name="chkExpense" value="Expense" /><label
							for="chkExpense"
						>Expense</label></td>
						<td><input id="chkIncome" type="checkbox" name="chkIncome" value="Income" /><label
							for="chkIncome"
						>Income</label></td>
					</tr>
					<tr>
						<td />
						<td><input class="btn btn-update" type="submit" value="Update Profile" name="btnAction" /></td>
						<td><label class="label-confirm"><i><%=(request.getAttribute("userUpdated") != null) ? request.getAttribute("userUpdated") : ""%></i></label></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>