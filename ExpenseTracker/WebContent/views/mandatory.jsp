<%@ include file="/views/header.jsp"%>
<%@ page import="com.et.beans.Mandatory"%>
<%@ page import="com.et.dal.ExpenseDal"%>
<%@ page import="com.et.dal.IncomeDal"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.et.beans.User"%>
<%
	User user = new User();
	user = (User) session.getAttribute("loggedInUser");
	ArrayList<Mandatory> mIncomes = new ArrayList<Mandatory>();
	ArrayList<Mandatory> mExpenses = new ArrayList<Mandatory>();

	ExpenseDal expenseDal = new ExpenseDal();
	IncomeDal incomeDal = new IncomeDal();

	mIncomes = incomeDal.getMandatoryIncomes(user);
	mExpenses = expenseDal.getMandatoryExpenses(user);
%>
<!DOCTYPE html>
<html>
<head>
<link href="/ExpenseTracker/css/index.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mandatory Expenses</title>
</head>
<body>
	<div>
		<fieldset>
			<legend>
				<h3>Income</h3>
			</legend>
			<table class="profile">
				<tr>
					<th>Category</th>
					<th>Description</th>
					<th>Date</th>
					<th>Amount</th>
				</tr>
				<%
					for (Mandatory mIncome : mIncomes)
					{
						out.println("<tr align=\"center\">");
						out.println("<td>" + mIncome.getCategory() + "</td>");
						out.println("<td>" + mIncome.getDescription() + "</td>");
						out.println("<td>" + mIncome.getDate() + "</td>");
						out.println("<td align=\"right\">" + "$"+mIncome.getAmount() + "</td>");
						out.println("</tr>");
					}
				%>
			</table>
		</fieldset>
	</div>
	<div>
		<fieldset>
			<legend>
				<h3>Expense</h3>
			</legend>
				<table class="profile">
					<tr>
						<th>Category</th>
						<th>Description</th>
						<th>Date</th>
						<th>Amount</th>
					</tr>
					<%
						for (Mandatory mExpense : mExpenses)
						{
							out.println("<tr align=\"center\">");
							out.println("<td>" + mExpense.getCategory() + "</td>");
							out.println("<td>" + mExpense.getDescription() + "</td>");
							out.println("<td>" + mExpense.getDate() + "</td>");
							out.println("<td align=\"right\">" + "$"+mExpense.getAmount() + "</td>");
							out.println("</tr>");
						}
					%>
				</table>
		</fieldset>
	</div>
</body>
</html>