<%@ page import="java.util.Calendar"%>
<%@ include file="/views/header.jsp"%>
<%@ page import="com.et.dal.CategoryDal"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.et.dal.PaymentSourceDal"%>
<%@ page import="com.et.beans.Expense"%>
<!DOCTYPE html>
<html lang="en">
<%
	CategoryDal categoryDal = new CategoryDal();
	ArrayList<String> categories = new ArrayList<String>();
	categories = categoryDal.getCategories();
	
	PaymentSourceDal paymentSourceDal = new PaymentSourceDal();
	ArrayList<String> paymentSources = new ArrayList<String>();
	paymentSources = paymentSourceDal.getPaymentSources();
	
	Expense expense = new Expense();
	expense = (Expense) request.getAttribute("expenseToBeUpdated");
%>
<head>
<link href="/ExpenseTracker/css/index.css" rel="stylesheet" type="text/css">
<title>Enter Expense</title>
</head>
<body>
	<div>
	<fieldset>
		<legend><h3>Enter/Edit Expense details below</h3></legend>
		<form method="post" action="/ExpenseTracker/Delegate">
			<table>
				<tr>
					<td><label>Expense Description</label></td>
					<td><input type="text" name="txtExpDesc" size="49em" maxlength="49" required
						placeholder="Expense Description" value=<%=(expense!=null)?expense.getDescription():""%>
					/></td>
				</tr>
				<tr>
					<td><label>Date (yyyy-mm-dd)</label></td>
					<td><input name="dtExpDate" type="text" required placeholder="yyyy-mm-dd"
						pattern="\d{4}-\d{1,2}-\d{1,2}" maxlength="10"
						value=<%=(expense!=null)?expense.getExpenseDate():""%>
					/></td>
				</tr>
				<tr>
					<td><label>Amount</label></td>
					<td><input type="text" name="txtAmount" required placeholder="1234.56" maxlength="10"
						pattern="\d+(.\d{2})?" value=<%=(expense!=null)?expense.getAmount():""%>
					/></td>
				</tr>
				<tr>
					<td><label>Payment Using</label></td>
					<td><select required name="ddlPaymentSource" class="aligned">
							<%
								for(String paymentSource:paymentSources){
													out.println("<option value=\""+paymentSource+"\">"+paymentSource+"</option>");
												}
							%>
					</select></td>
				</tr>
				<tr>
					<td><label>Review</label></td>
					<td><select required name="ddlReview" required class="aligned">
							<option value="0">No</option>
							<option value="1">Yes</option>
					</select></td>
				</tr>
				<tr>
					<td><label>Posted</label></td>
					<td><select required name="ddlPosted" required class="aligned">
							<option value="0">No</option>
							<option value="1">Yes</option>
					</select></td>
				</tr>
				<tr>
					<td><label>Category</label></td>
					<td><select required name="ddlCategory" class="aligned">
							<%
								for(String category:categories){
										out.println("<option value=\""+category+"\">"+category+"</option>");
										}
							%>
					</select></td>
				</tr>
				<tr>
					<td><input class="btn btn-logout" type="reset" name="btnAction" value="Reset" /></td>
					<%
						if(expense!=null){
						out.println("<td><input type=\"submit\" name=\"btnAction\" value=\"Update Expense\" class=\"btn btn-expenses\"/></td>");
						}else{
						out.println("<td><input type=\"submit\" name=\"btnAction\" value=\"Save Expense\" class=\"btn btn-expenses\"/></td>");
						}
					%>
				</tr>
			</table>
		</form>
		</fieldset>
	</div>
</body>
</html>