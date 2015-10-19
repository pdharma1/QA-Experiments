<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="isp.code.workers.viewbuilders.IndexJSP"%>
<%@ include file="./pages/header.jsp"%>


<!DOCTYPE html>
<html>
<head>
<%
	IndexJSP indexJsp = new IndexJSP();
%>
<link href="css/isp1.css" rel="stylesheet" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Industrial Spare Capacity</title>
</head>
<body>
	<BR>
	<BR>
	<div>
		<%=indexJsp.getIntroContent().toString()%>
	</div>
</body>
</html>