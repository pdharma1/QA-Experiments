<%@ page import="com.et.workers.GetHeaderContent"%>
<!DOCTYPE html>
<html>
<head>
<link href="/ExpenseTracker/css/index.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title></title>
<link rel="shortcut icon" src="/ExpenseTracker/imgs/header2.png">
</head>
<body>
	<img class="banner" alt="Banner" src="/ExpenseTracker/imgs/header2.png" />
	<hr>
	<form method="post" action="/ExpenseTracker/Delegate">
		<table cellspacing="10" style="margin-left: auto; margin-right: auto;">
			<tr>
				<%
					if (session != null)
					{
						StringBuffer sb = GetHeaderContent.getHeaderContent(session);
						out.println(sb.toString());
					}
				%>
			</tr>
		</table>
		<hr>
	</form>
</body>
</html>