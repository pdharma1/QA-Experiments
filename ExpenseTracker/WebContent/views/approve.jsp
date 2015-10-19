<%@ include file="/views/header.jsp"%>
<%@ page import="com.et.beans.ApproveUserHtml"%>
<%@ page import="com.et.beans.User"%>


<!DOCTYPE html>
<html lang="en">
<head>
<link href="/ExpenseTracker/css/index.css" rel="stylesheet" type="text/css">
<title>Approve Users</title>
<%
	User loggedInUser = (User) session.getAttribute("loggedInUser");
	StringBuffer sb1 = new StringBuffer("");
	ApproveUserHtml approveHtml = new ApproveUserHtml();
	sb1 = approveHtml.getApproveUserHtml(session);
%>
</head>
<body>
<div>
<fieldset>
<legend><h3>Approve/Reject Users</h3></legend>
	<%
		if (loggedInUser != null)
		{
			out.println(sb1.toString());
		}
	%>
	</fieldset>
	</div>
</body>
</html>