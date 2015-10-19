<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="isp.code.workers.viewbuilders.UnitTechJSP"%>
<%@ include file="header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<%
	UnitTechJSP unitTech = new UnitTechJSP();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<BR>
	<form method="post" action="/IndSpCap/Delegate">
		<div class="Table">
			<FIELDSET>
				<LEGEND>Unit Technical Information</LEGEND>
				<div>
					<label for="txtMachinesInstalled">Count of Machines Installed</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" type="text" id="txtMachinesInstalled" name="txtMachinesInstalled" PLACEHOLDER="Machines Count" REQUIRED TABINDEX="1"
							MAXLENGTH="45"
						>
					</div>
				</div>
				<BR>
				<div>
					<label for="txtInstalledCapacity">Installed Capacity</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" type="text" id="txtInstalledCapacity" name="txtInstalledCapacity" PLACEHOLDER="Expected Capacity" REQUIRED TABINDEX="2"
							MAXLENGTH="45"
						>
					</div>
				</div>
				<BR>
				<div>
					<label for="txtPresentUtil">Present Utilization %</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" type="text" id="txtPresentUtil" name="txtPresentUtil" PLACEHOLDER="Present Capacity at Utilization %" REQUIRED TABINDEX="3"
							MAXLENGTH="45"
						>
					</div>
				</div>
				<BR>
				<div>
					<label for="txtSpareCap">Spare Capacity Available %</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" READONLY type="text" id="txtSpareCap" name="txtSpareCap" PLACEHOLDER="Capacity available %" REQUIRED TABINDEX="4"
							MAXLENGTH="45"
						>
					</div>
				</div>
				<BR>
				<div>
					<label>Facilities Available:</label><label class="RequiredField">*</label><%=unitTech.getFacilities().toString()%>
				</div>
				<BR>
				<div>
					<label for="txtShifts">Number of Shifts</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" type="text" id="txtShifts" name="txtShifts" PLACEHOLDER="Shifts" REQUIRED TABINDEX="5" MAXLENGTH="45">
					</div>
				</div>
				<BR>
				<div>
					<label for="txtPower">Power in KW</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" type="text" id="txtPower" name="txtPower" PLACEHOLDER="Power in Kilo Watts" REQUIRED TABINDEX="6" MAXLENGTH="45">
					</div>
				</div>
				<BR>
				<div>
					<label>Genset Available</label><label class="RequiredField">*</label> <input type="radio" id="radioGenSetYes" value="Yes" name="radioGenSet" REQUIRED
						TABINDEX="4"
					><LABEL for="radioGenSetYes">Yes</LABEL> <input type="radio" id="radioGenSetNo" value="No" name="radioGenSet" REQUIRED TABINDEX="7"><LABEL
						for="radioGenSetNo"
					>No</LABEL>
				</div>
				<BR>
				<div>
					<label for="txtTechnicals">Technical Strength</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" type="text" id="txtTechnicals" name="txtTechnicals" PLACEHOLDER="Technical Strength" REQUIRED TABINDEX="8" MAXLENGTH="45">
					</div>
				</div>
				<BR>
				<div>
					<%=unitTech.getActivities().toString()%>
				</div>
				<BR>
				<div>
					<label for="txtProdManufac">Product of Manufacturing</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" type="text" id="txtProdManufac" name="txtProdManufac" PLACEHOLDER="Product being manufactured" REQUIRED TABINDEX="9"
							MAXLENGTH="45"
						>
					</div>
				</div>
				<BR>
				<div>
					<%=unitTech.getManpower().toString()%>
				</div>
				<BR>
				<div>
					<label for="txtEndUser">End User</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" type="text" id="txtEndUser" name="txtEndUser" PLACEHOLDER="Who is the order to?" REQUIRED TABINDEX="10" MAXLENGTH="45">
					</div>
				</div>
				<BR>
				<div>
					<label for="radioQuality">Quality Standards - In house:</label><label class="RequiredField">*</label> <input type="radio" id="radioQualityYes"
						name="radioQuality" value="Yes" REQUIRED TABINDEX="10"
					/>
					<lable for="radioQualityYes">Yes</lable>
					<input type="radio" id="radioQualityNo" name="radioQuality" value="No" REQUIRED TABINDEX="10" />
					<lable for="radioQualityNo">No</lable>
				</div>
				<BR>
				<div>
					<label for="txtSpecialization">Specialization</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" type="text" id="txtSpecialization" name="txtSpecialization" PLACEHOLDER="What is your Specialization?" REQUIRED TABINDEX="10" MAXLENGTH="45">
					</div>
				</div>
				<BR>

				<div ALIGN="right">
					<input type="submit" name="btnAction" value="Submit Unit Tech" class="SubmitButtons">
				</div>

			</FIELDSET>
		</div>
	</form>
</body>
</html>