<%@ include file="/views/header.jsp"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="com.et.dal.ExpenseDal"%>
<%@ page import="com.et.dal.IncomeDal"%>
<%@ page import="com.et.beans.User"%>
<%@ page import="java.util.Map.Entry"%>
<!DOCTYPE html>
<html>
<head>
<%
	User loggedInUser = new User();
	loggedInUser = (User) session.getAttribute("loggedInUser");
		ExpenseDal expenseDal = new ExpenseDal();

		IncomeDal incomeDal = new IncomeDal();
		Map<String, String> expenseSummary = new HashMap<String, String>();
		expenseSummary = expenseDal.getExpenseSummary(loggedInUser);

		Map<String, String> incomeSummary = new HashMap<String, String>();
		incomeSummary = incomeDal.getIncomeSummary(loggedInUser);
%>
<link href="/ExpenseTracker/css/index.css" rel="stylesheet" type="text/css">
<title>Expense Tracker - Reports</title>
</head>
<body>
<div style="margin-left: 15%; float: left; width: 69.27%; padding: 2px;">
<table>
<tr><td><p>Please click <a href="mandatory.jsp">here</a> for mandatory expense list</p></td></tr>
</table>
</div>
	<div style="margin-left: 15%; float: left; width: 23%; padding: 2px;">
		<fieldset>
			<legend>
				<h3>Totals</h3>
			</legend>
			<table border="1" align="center">
				<tr>
					<th>Income</th>
					<td align="right"><%="$" + incomeDal.getAllTotalIncome(loggedInUser)%></td>
				</tr>
				<tr>
					<th>Expense</th>
					<td align="right"><%="$" + expenseDal.getAllTotalExpense(loggedInUser)%></td>
				</tr>
				<tr>
					<th>Effective Savings</th>
					<td align="right"><%="$" + String.format("%.2f", (incomeDal.getAllTotalIncome(loggedInUser) - expenseDal.getAllTotalExpense(loggedInUser)))%></td>
				</tr>
			</table>
		</fieldset>
	</div>
	<div style="margin-left: 2%; float: left; width: 44%; padding: 2px;">
		<fieldset>
			<legend>
				<h3>Income Expense</h3>
			</legend>
			<img BORDER="1" alt="Income-Expense" src="/ExpenseTracker/IncomeExpense">
		</fieldset>
	</div>
	<div style="margin-left: 15%; float: left; width: 23%; padding: 2px;">
		<fieldset>
			<legend>
				<h3>Income Summary</h3>
			</legend>
			<table border="1" align="center">
				<tr>
					<th>Category</th>
					<th>Amount</th>
				</tr>
				<%
					for (Entry entry : incomeSummary.entrySet())
					{
						out.println("<tr><td>" + entry.getKey().toString() + "</td><td align=\"right\">" + "$" + entry.getValue().toString() + "</td></tr>");
					}
				%>
			</table>
		</fieldset>
	</div>
	<div style="margin-left: 2%; float: left; width: 44%; padding: 2px;">
		<fieldset>
			<legend>
				<h3>Income Breakdown</h3>
			</legend>
			<img BORDER="1" alt="Income breakdown" src="/ExpenseTracker/IncomeBreakdown">
		</fieldset>
	</div>
	<div style="margin-left: 15%; float: left; width: 23%; padding: 2px;">
		<fieldset>
			<legend>
				<h3>Expense Summary</h3>
			</legend>
			<table border="1" align="center">
				<tr>
					<th>Category</th>
					<th>Amount</th>
				</tr>
				<%
					for (Entry entry : expenseSummary.entrySet())
					{
						out.println("<tr><td>" + entry.getKey().toString() + "</td><td align=\"right\">" + "$" + entry.getValue().toString() + "</td></tr>");
					}
				%>
			</table>
		</fieldset>
	</div>
	<div style="margin-left: 2%; float: left; width: 44%; padding: 2px;">
		<fieldset>
			<legend>
				<h3>Expense Breakdown</h3>
			</legend>
			<img BORDER="1" alt="Expense breakdown" src="/ExpenseTracker/ExpenseBreakdown">
		</fieldset>
	</div>
</body>
</html>