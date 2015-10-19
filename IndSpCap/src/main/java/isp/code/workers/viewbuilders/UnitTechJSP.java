package isp.code.workers.viewbuilders;

import java.util.List;

import isp.dal.beans.Activity;
import isp.dal.beans.Facility;
import isp.dal.beans.Manpower;
import isp.dal.impls.ActivityImpl;
import isp.dal.impls.FacilityImpl;
import isp.dal.impls.ManpowerImpl;
import isp.dal.interfaces.IActivity;
import isp.dal.interfaces.IFacility;
import isp.dal.interfaces.IManpower;

public class UnitTechJSP {

	private StringBuilder sbFacility = new StringBuilder("");
	private StringBuilder sbActivities = new StringBuilder("");
	private StringBuilder sbManpower = new StringBuilder("");

	public StringBuilder getFacilities() {

		IFacility facility = new FacilityImpl();
		List<Facility> facilities = facility.getFacilities();

		for (Facility fac : facilities) {
			this.sbFacility.append(
			        "<INPUT type=\"checkbox\" name=\"chk\"" + fac.getFacilityType() + " value=\"" + fac.getFacilityType() + "\" /><label>" + fac.getFacilityType() + "</label>");
		}

		return this.sbFacility;
	}

	public StringBuilder getActivities() {

		IActivity activity = new ActivityImpl();

		this.sbActivities.append("<label>Line of Activity</label><label class=\"RequiredField\">*</label>");
		this.sbActivities.append("<div><select name=\"multiActivity\" multiple size=\"" + activity.getActivities().size() + "\">");
		for (Activity act : activity.getActivities()) {

			sbActivities.append("<option value=\"" + act.getActivityType() + "\">" + act.getActivityType() + "</option>");
			// this.sbActivities.append("<div><INPUT type=\"checkbox\" name=\"" + "chk" + act.getActivityType() + "\"" +
			// " value=\"" + act.getActivityType() + "\" /><label>"
			// + act.getActivityType() + "</label></div>");
		}
		sbActivities.append("</select></div>");
		return this.sbActivities;
	}

	public StringBuilder getManpower() {

		IManpower manpower = new ManpowerImpl();
		this.sbManpower.append("<label>Details of Manpower</label><label class=\"RequiredField\">*</label>");
		for (Manpower m : manpower.getManpower()) {
			this.sbManpower.append(
			        "<div><INPUT type=\"checkbox\" name=\"" + "chk" + m.getManpower() + "\"" + " value=\"" + m.getManpower() + "\" /><label>" + m.getManpower() + "</label></div>");
		}
		return this.sbManpower;
	}
}
