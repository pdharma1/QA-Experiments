<%@ page import="java.util.Calendar"%>
<%@ include file="/views/header.jsp"%>
<%@ page import="com.et.dal.CategoryDal"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.et.dal.PaymentSourceDal"%>
<%@ page import="com.et.beans.Income"%>
<!DOCTYPE html>
<html lang="en">
<%
	CategoryDal categoryDal = new CategoryDal();
	ArrayList<String> categories = new ArrayList<String>();
	categories = categoryDal.getCategories();

	Income income = new Income();
	income = (Income) request.getAttribute("incomeToBeUpdated");
%>
<head>
<link href="/ExpenseTracker/css/index.css" rel="stylesheet" type="text/css">
<title>Enter Income</title>
</head>
<body>
	<div>
	<fieldset>
		<legend>
		<h3>Enter/Edit Income details below</h3></legend>
		<FORM method="post" action="/ExpenseTracker/Delegate">
			<table>
				<tr>
					<td><label>Income Description</label></td>
					<td><input type="text" name="txtIncDesc" size="49em" maxlength="49" required
						placeholder="Income Description" value=<%=(income != null) ? income.getDescription() : ""%>
					/></td>
				</tr>
				<tr>
					<td><label>Date (yyyy-mm-dd)</label></td>
					<td><input name="dtIncDate" type="text" required placeholder="yyyy-mm-dd"
						pattern="\d{4}-\d{1,2}-\d{1,2}" maxlength="10" value=<%=(income!=null)?income.getIncomeDate():"" %>
					/></td>
				</tr>
				<tr>
					<td><label>Amount</label></td>
					<td><input type="text" name="txtAmount" required placeholder="1234.56" maxlength="10"
						pattern="\d+(.\d{2})?" value=<%=(income!=null)?income.getAmount():"" %>
					/></td>
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
					<td><select required name="ddlCategory" class="aligned" value="Income">
							<%
								for (String category : categories)
								{
									out.println("<option value=\"" + category + "\">" + category + "</option>");
								}
							%>
					</select></td>
				</tr>
				<tr>
					<td><input class="btn btn-logout" type="reset" name="btnAction" value="Reset" /></td>
					<%
					if(income!=null){
					out.println("<td><input type=\"submit\" name=\"btnAction\" value=\"Update Income\" class=\"btn btn-incomes\" /></td>");
					}else{
					out.println("<td><input type=\"submit\" name=\"btnAction\" value=\"Save Income\" class=\"btn btn-incomes\" /></td>");
					}
					%>
				</tr>
			</table>
		</FORM>
		</fieldset>
	</div>
</body>
</html>