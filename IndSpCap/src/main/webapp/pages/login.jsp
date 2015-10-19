<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
	<BR>
	<form ACTION="/IndSpCap/Delegate" method="post">
		<div class="Table">
			<fieldset>
				<legend>Login</legend>
				<div>
					<label>Username:</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" name="txtUsername" type="text" PLACEHOLDER="Username" REQUIRED MAXLENGTH="45">
					</div>
					<br> <label>Password:</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" name="txtPassword" type="password" PLACEHOLDER="Password" REQUIRED MAXLENGTH="45">
					</div>
					<br>
					<div>
						<input type="submit" name="btnAction" value="Login" class="SubmitButtons">
					</div>
				</div>
			</fieldset>
		</div>
	</form>

</body>
</html>