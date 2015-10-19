<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="isp.code.workers.viewbuilders.CoInfoJSP"%>
<%@ include file="header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	CoInfoJSP cin = new CoInfoJSP();
%>
</head>
<body>
	<BR>
	<form method="post" action="/IndSpCap/Delegate">
		<div class="Table">
			<fieldset>
				<legend>Company Information</legend>
				<div>
					<label>Name of the Company</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" type="text" name="txtUnitName" PLACEHOLDER="Name of the Company" REQUIRED TABINDEX="1" MAXLENGTH="45">
					</div>
				</div>
				<BR>
				<div>
					<label>SSI Registration Number</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" type="text" name="txtSSI" placeholder="SSI Registration" TABINDEX="2" MAXLENGTH="45" REQUIRED>
					</div>
				</div>
				<BR>
				<div>
					<label>PAN Number</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" type="text" name="txtPan" PLACEHOLDER="Tax PAN Number" TABINDEX="3" MAXLENGTH="45" REQUIRED>
					</div>
				</div>
				<BR>
				<div>
					<label>Address Line1</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" type="text" name="txtAddress1" PLACEHOLDER="Address Line 1" TABINDEX="4" MAXLENGTH="45" REQUIRED>
					</div>
				</div>
				<BR>
				<div>
					<label>Address Line2</label>
					<div>
						<input class="InputFields" type="text" name="txtAddress2" TABINDEX="5" MAXLENGTH="45">
					</div>
				</div>
				<BR>
				<div>
					<label>District</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" type="text" name="txtDistrict" PLACEHOLDER="District/County" TABINDEX="6" MAXLENGTH="45" REQUIRED>
					</div>
				</div>
				<BR>
				<div>
					<label>State</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" type="text" name="txtState" PLACEHOLDER="State" TABINDEX="7" MAXLENGTH="45" REQUIRED>
					</div>
				</div>
				<BR>
				<div>
					<label>Pincode</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" type="text" name="txtPincode" PLACEHOLDER="Pincode/Zipcode" TABINDEX="8" MAXLENGTH="45" REQUIRED>
					</div>
				</div>
				<BR>
				<div>
					<label>Constitution</label><label class="RequiredField">*</label>
					<div>
						<SELECT NAME="ddlConstitution" TABINDEX="9" REQUIRED>
							<%=cin.getConstitutionsDDLContent().toString()%>
						</SELECT>
					</div>
				</div>
				<BR>
				<div>
					<label>Name of the Person in-charge</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" type="text" name="txtPoc" PLACEHOLDER="Point of Contact" TABINDEX="9" MAXLENGTH="45" REQUIRED>
					</div>
				</div>
				<BR>
				<div>
					<label>Phone Number</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" type="text" name="txtPhone" PLACEHOLDER="Phone Number" TABINDEX="10" MAXLENGTH="45" REQUIRED>
					</div>
				</div>
				<BR>
				<div>
					<label>Email</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" type="text" name="txtPocEmail" PLACEHOLDER="Point of Contact Email" TABINDEX="11" MAXLENGTH="45" REQUIRED>
					</div>
				</div>
				<BR>
				<div>
					<label>Website</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" type="text" name="txtWebsite" PLACEHOLDER="Your company's website" TABINDEX="12" MAXLENGTH="45" REQUIRED>
					</div>
				</div>
				<BR>
				<div>
					<label>Turnover</label><label class="RequiredField">*</label>
					<div>
						<input class="InputFields" type="text" name="txtTurnover" PLACEHOLDER="Your company's turnover" TABINDEX="13" MAXLENGTH="45" REQUIRED>
					</div>
				</div>
				<BR>
				<div>
					<label for="radioProfitYes">Profit Making?</label><label class="RequiredField">*</label> <input type="radio" id="radioProfitYes"
						name="radioProfitMaking" value="Yes" REQUIRED TABINDEX="10"
					/>
					<lable for="radioProfitYes">Yes</lable>
					<input type="radio" id="radioProfitNo" name="radioProfitMaking" value="No" REQUIRED TABINDEX="10" />
					<lable for="radioProfitNo">No</lable>
				</div>
				<BR>
				<div>
					<label>Member of Associations if any?</label>
					<div>
						<input class="InputFields" type="text" name="txtMemberAsso" PLACEHOLDER="What associations do you belong to?" TABINDEX="14" MAXLENGTH="45">
					</div>
				</div>
				<BR>
				<div>
					<label>Bankers</label>
					<div>
						<input class="InputFields" type="text" name="txtBankers" PLACEHOLDER="Who do you Bank with?" TABINDEX="15" MAXLENGTH="45">
					</div>
				</div>
				<BR>
				<div>
					<label>Limits (in Lakhs)</label><label class="RequiredField">*</label> 
					<input type="radio" name="txtBankers" value="CC" TABINDEX="16" required><label>CC</label> 
					<input type="radio" name="txtBankers" value="BG" TABINDEX="16" required><label>BG</label> 
					<input type="radio" name="txtBankers" value="LC" TABINDEX="16" required><label>LC</label>
				</div>
				<BR>
				<div ALIGN="right">
					<input type="submit" name="btnAction" value="Submit Co. Info" class="SubmitButtons">
				</div>

			</fieldset>
		</div>
	</form>

</body>
</html>