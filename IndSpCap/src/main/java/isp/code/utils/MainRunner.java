package isp.code.utils;

import isp.dal.beans.Manpower;
import isp.dal.impls.ManpowerImpl;
import isp.dal.interfaces.IManpower;

public class MainRunner {

	public static void main(String[] args) {

		/*
		 * This is all purpose main program.
		 */
		try {
			IManpower mi = new ManpowerImpl();
			for (Manpower m : mi.getManpower()) {
				System.out.println(m.getManpower());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
