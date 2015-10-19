<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="isp.code.workers.viewbuilders.HeaderJSP"%>
<!DOCTYPE html>
<html>
<head>
<link href="/IndSpCap/css/isp1.css" rel="stylesheet" type="text/css">
<%
	HeaderJSP headerJsp = new HeaderJSP();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Industrial Spare Capacity</title>
</head>
<body>
	<div>
		<%=headerJsp.getHeaderContent(session).toString()%>
	</div>
	<BR>
	<HR>
</body>
</html>