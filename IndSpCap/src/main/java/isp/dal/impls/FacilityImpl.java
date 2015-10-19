package isp.dal.impls;

import java.util.List;

import org.hibernate.Session;

import isp.dal.beans.Facility;
import isp.dal.conn.HibernateFactory;
import isp.dal.interfaces.IFacility;

public class FacilityImpl implements IFacility {

	private List<Facility> facilities = null;

	@Override
	public List<Facility> getFacilities() {

		HibernateFactory factory = new HibernateFactory();
		Session session = null;
		try {
			session = factory.getSession();
			facilities = session.createQuery("from Facility").list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.closeSession(session);
		}
		return facilities;
	}

}
