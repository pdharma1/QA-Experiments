<%@ page errorPage="error.jsp"%>
<%@ include file="/views/header.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>WOOPSIE DAISY! Something went wrong!!!</title>
<link href="../css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="error">
<fieldset>
<legend><h3>Alert !</h3></legend>
		<table>
			<tr><td align="center">			<h2>Why am I here?</h2></td></tr>
<%			if(exception!=null){%>
			<tr><td><p>
				Error occurred due to: <i><%=exception%></i>
				<%} %>
			</p></td></tr>
			
				<%if(request.getAttribute("sendEmailError")!=null){ %>
				<tr><td><p>Possible Causes: <i class="error"><%=request.getAttribute("sendEmailError") %></i></p></td></tr>
				<%}if(request.getAttribute("registrationMessage")!=null) {%>
				<tr><td><p>Possible Causes: <i class="error"><%=request.getAttribute("registrationMessage") %></i></p></td></tr>
				<%} %>
				<%if(request.getAttribute("loginValidationMessage")!=null) {%>
				<tr><td><p>Possible Causes: <i class="error"><%=request.getAttribute("loginValidationMessage") %></i></p></td></tr>
				<%} %>
				<%if(request.getAttribute("userApprovedRejectedMessage")!=null) {%>
				<tr><td><p>Possible Causes: <i class="error"><%=request.getAttribute("userApprovedRejectedMessage") %></i></p></td></tr>
				<%} %>
				<%if(request.getAttribute("editExpenseError")!=null) {%>
				<tr><td><p>Possible Causes: <i class="error"><%=request.getAttribute("editExpenseError") %></i></p></td></tr>
				<%} %>
				<%if(request.getAttribute("editIncomeError")!=null) {%>
				<tr><td><p>Possible Causes: <i class="error"><%=request.getAttribute("editIncomeError") %></i></p></td></tr>
				<%} %>
			<tr><td><p><b>In general when an unknown error occurred you will be navigated by the system onto this screen.
				Please follow the links from the header section to continue your operations on the site.</b><p></td></tr>
			<tr><td><%@ page isErrorPage="true"%></td></tr>
			<tr><td><p>Thank you for your patience and understanding. Site will be improved soon.</p></td></tr>
		</table>
	</fieldset>
	</div>
</body>
</html>
