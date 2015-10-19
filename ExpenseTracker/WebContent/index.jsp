<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ include file="./views/header.jsp"%>
<%@ page import="com.et.beans.Role"%>
<%@ page import="com.et.dal.RoleDal"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<HTML lang="en">
<head>
<link href="/ExpenseTracker/css/index.css" rel="stylesheet" type="text/css">
<title>Welcome to Expense Tracker</title>
<%
	Role role = new Role();
	RoleDal dbRoles = new RoleDal();
	ArrayList<String> roles = new ArrayList<String>();
	roles = dbRoles.getRoles();
	String confirmationMessage = "";
%>
</head>
<body>
	<form method="post" action="/ExpenseTracker/Delegate">
		<div>
			<fieldset>
				<legend color="Red">
					<h3>Registration</h3>
				</legend>
				<table>
					<tr>
						<td><label>Name</label></td>
						<td><input type="text" name="txtName" placeholder="Enter Full Name" size="49em" required
							maxlength="49"
						/></td>
					</tr>
					<tr>
						<td><label>Email</label></td>
						<td><input type="text" placeholder="Enter Email" required name="txtEmail"
							pattern="\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}\b" size="49em" maxlength="49"
						/></td>
					</tr>
					<tr>
						<td><label>Password</label></td>
						<td><input type="password" required size="49em" name="txtPassword" maxlength="49"
							placeholder="Enter Password"
						></td>
					</tr>
					<tr>
						<td><label>Address</label></td>
						<td><input type="text" placeholder="Enter Address" required size="49em" maxlength="49"
							name="txtAddress"
						/></td>
					</tr>
					<tr>
						<td><label>Select Role</label></td>
						<td><select required name="ddlRole" class="aligned">
								<%
									for (String str : roles)
									{
								%>
								<option value=<%=str%>><%=str%></option>
								<%
									}
								%>
						</select></td>
					</tr>
					<tr>
						<td><label>Select Service</label></td>
						<td><input id="idExpChkBox" type="checkbox" name="chkExpense" value="Expense" 
							class="checkbox-inline"
						/> <label for="idExpChkBox">Expense</label><input id="idIncChkBox" type="checkbox" 
							name="chkIncome" value="Income" class="checkbox-inline"
						/> <label for="idIncChkBox">Income</label></td>
					</tr>
					<tr />
					<tr />
					<tr />
					<tr />
					<tr>
						<td align="center"><input class="btn btn-reset" type="reset" value="Reset"
							name="btnAction"
						/>
						<td align="center"><input class="btn btn-register" type="submit" value="Register"
							name="btnAction"
						/></td>
					</tr>
					<tr>
						<td><label name="lblConfirmationMessage" value="<%=confirmationMessage%>"></label></td>
					</tr>
				</table>
			</fieldset>
		</div>
	</form>
</body>
</html>