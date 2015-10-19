<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ include file="/views/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Registration Confirmation</title>
<link href="/ExpenseTracker/css/index.css" rel="stylesheet" type="text/css">
<body>
	<div>
		<fieldset>
			<legend>
				<h3>Registration Confirmation</h3>
			</legend>
			<table>
				<tr>
					<td><p>
							Hello <i><%=request.getParameter("txtName")%>.</i>
						</p></td>
				</tr>
				<tr>
					<td><p>Thank you for registering with Expense Tracker. We are looking forward to
							better assisting you with tracking your income, expenses and through many more services.</p></td>
				</tr>
				<tr>
					<td><b>Next Steps:</b></td>
				</tr>
				<tr>
					<td><ul>
							<li>Please wait for Admin to approve your request. You will be notified via email.</li>
							<li>Continue to <a href="views/login.jsp">Login</a> if your request has already been
								approved.
							</li>
						</ul></td>
				</tr>
			</table>
		</fieldset>
	</div>
</body>
</html>