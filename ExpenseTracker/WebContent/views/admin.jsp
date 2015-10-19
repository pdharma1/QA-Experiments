<%@ include file="/views/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%
	String categoryMessage = "";
	String paymentMessage = "";
	
	if (request.getAttribute("saveNewPaymentSource") != null)
	{
		boolean saveNewPaymentSource = (Boolean) request.getAttribute("saveNewPaymentSource");
		if (saveNewPaymentSource)
		{
			paymentMessage = "Category added successfully";
			request.setAttribute("saveNewPaymentSource",null) ;
		}
		else
		{
			paymentMessage = "Category not added successfully";
		}
	}
	else
	{
		categoryMessage = "";
	}
	
	
	if (request.getAttribute("saveNewCategory") != null)
	{
		boolean saveNewCategory = (Boolean) request.getAttribute("saveNewCategory");
		if (saveNewCategory)
		{
			categoryMessage = "Category added successfully";
			request.setAttribute("saveNewCategory",null) ;
		}
		else
		{
			categoryMessage = "Category not added successfully";
		}
	}
	else
	{
		categoryMessage = "";
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Operations</title>
</head>
<body>
	<div style="margin-left:15%; float: left; width: 32%; padding: 2px;">
		<fieldset style=" float: left; padding: 2px;">
			<legend>
				<h3>New Category</h3>
			</legend>
			<form method="post" action="/ExpenseTracker/Delegate">
				<table>
					<tr>
						<td><label class="admin" for="txtNewCategory">Category</label></td>
						<td><input id="txtNewCategory" type="text" name="txtNewCategory" required maxlength="44"
							placeholder="New Category"
						/></td>
					</tr>
					<tr>
						<td><label class="admin">Mandatory</label></td>
						<td><input type="radio" name="rbtnMandatory" value="Yes" required /><label class="YesNo">Yes</label><input
							type="radio" name="rbtnMandatory" value="No" required
						/><label class="YesNo">No</label></td>
					</tr>
					<tr></tr>
					<br>
					<tr>
						<td></td>
						<td><input class="btn btn-admin1" type="submit" value="Save New Category"
							name="btnAction"
						/></td>
					</tr>
					<tr>
						<td style="color: maroon;"><p>
								<i><%=categoryMessage%></i>
							</p></td>
					</tr>
				</table>
			</form>
		</fieldset>
	</div>
	<div style=" margin-left:1%;float: left; width: 35%;">
		<fieldset style="float: left; padding: 2px;">
			<legend>
				<h3>New Payment Source</h3>
			</legend>
			<form method="get" action="/ExpenseTracker/Delegate">
				<table>
					<tr>
						<td><label for="txtPaymentSourceId">Name</label></td>
						<td><input type="text" maxlength="44" required placeholder="New Payment Source"
							id="txtPaymentSourceId" name="txtPaymentSourceName"
						/></td>
					</tr>
					<tr>
						<td><label for="txtCreditLimit">Credit Limit</label></td>
						<td><input type="text" required placeholder="Credit Limit" id="txtCreditLimit"
							name="txtCreditLimit"
						/></td>
					</tr>
					<tr>
						<td><label for="txtExpDate">Expire Date (yyyy-mm-dd)</label></td>
						<td><input type="text" maxlength="10" placeholder="yyyy-mm-dd"
							pattern="\d{4}-\d{1,2}-\d{1,2}" id="txtExpDate" name="txtExpDate"
						/></td>
					</tr>
					<tr>
						<td></td>
						<td><input class="btn btn-admin2" type="submit" name="btnAction"
							value="Save Payment Source"
						/></td>
					</tr>
					<tr>
						<td style="color: maroon;"><p>
								<i><%=paymentMessage %></i>
							</p></td>
					</tr>
				</table>
			</form>
		</fieldset>
	</div>
</body>
</html>