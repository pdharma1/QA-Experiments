<%@ include file="/views/header.jsp"%>
<%@ page import="com.et.beans.User"%>
<%@ page import="com.et.workers.Top10ExpenseIncomeHtml"%>
<%
	Top10ExpenseIncomeHtml top10ExpenseIncome = new Top10ExpenseIncomeHtml();

	StringBuffer income = new StringBuffer("");
	income = top10ExpenseIncome.getTop10Incomes(session);

	StringBuffer expense = new StringBuffer("");
	expense = top10ExpenseIncome.getTop10Expenses(session);

	User user = (User) session.getAttribute("loggedInUser");
%>
<!DOCTYPE html>
<html>
<head>
<link href="/ExpenseTracker/css/index.css" rel="stylesheet" type="text/css">
<title>View Transactions</title>
</head>
<body>
	<div>
		<%
			if (user.isExpense())
			{
		%>
		<fieldset>
			<legend><h3>Expenses</h3></legend>
			<form method="post" action="/ExpenseTracker/EditExpense">
				<table class="profile">
					<tr>
						<th>Description</th>
						<th>Expense Date</th>
						<th>Amount</th>
						<th>Posted?</th>
						<th>Category</th>
						<th>Payment Source</th>
						<th>Edit</th>
					</tr>
					<%=expense.toString()%>
				</table>
			</form>
		</fieldset>
		<%
			}
		%>
		<BR>
		<%
			if (user.isIncome())
			{
		%>
		<fieldset>
			<legend><h3>Income</h3></legend>
			<form method="post" action="/ExpenseTracker/EditIncome">
				<table class="profile">
					<tr>
						<th>Description</th>
						<th>Income Date</th>
						<th>Amount</th>
						<th>Posted?</th>
						<th>Category</th>
						<th>Edit</th>
					</tr>
					<%=income.toString()%>
				</table>
			</form>
		</fieldset>
		<%
			}
		%>
	</div>
</body>
</html>