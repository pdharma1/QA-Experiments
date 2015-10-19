package isp.code.workers.viewbuilders;

import java.util.List;

import isp.dal.beans.Constitution;
import isp.dal.impls.ConstitutionImpl;
import isp.dal.interfaces.IConstitution;

public class CoInfoJSP {

	private StringBuilder sbConstitutions = new StringBuilder("");

	public StringBuilder getConstitutionsDDLContent() {

		IConstitution constImpl = new ConstitutionImpl();
		List<Constitution> constitutions = constImpl.getAllConstitutions();

		sbConstitutions.append("<OPTION value=\"\">Select</OPTION>");
		for (Constitution consti : constitutions) {
			sbConstitutions.append("<OPTION value=\"" + consti.getConstitution() + "\">" + consti.getConstitution() + "</OPTION>");
		}

		return sbConstitutions;
	}
}
