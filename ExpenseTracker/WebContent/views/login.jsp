<%@ include file="/views/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="/ExpenseTracker/css/index.css" rel="stylesheet" type="text/css">
<title>Expense Tracker - Please login</title>
</head>
<body>
	<div>
		<form action="/ExpenseTracker/Delegate" method="post">
			<fieldset>
				<legend>
					<h3>Login</h3>
				</legend>
				<table>
					<tr>
						<td><label>Username </label></td>
						<td><input type="text" name="txtUsername" placeholder="Login id is Email" required
							maxlength="49"
						/></td>
					</tr>
					<tr>
						<td><label>Password</label></td>
						<td><input type="password" name="txtPassword" placeholder="Enter Password" required
							maxlength="49"
						/></td>
					</tr>
					<tr />
					<tr />
					<tr />
					<tr />
					<tr>
						<td />
						<td><input class="btn btn-login" type="submit" value="Login" name="btnAction"></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>
