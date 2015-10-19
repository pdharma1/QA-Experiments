package isp.dal.impls;

import java.util.List;

import org.hibernate.Session;

import isp.dal.beans.Manpower;
import isp.dal.conn.HibernateFactory;
import isp.dal.interfaces.IManpower;

public class ManpowerImpl implements IManpower {

	List<Manpower> manpowers = null;

	Session session = null;

	@Override
	public List<Manpower> getManpower() {
		HibernateFactory factory = new HibernateFactory();
		try {
			session = factory.getSession();
			manpowers = session.createQuery("from Manpower").list();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			factory.closeSession(session);
		}
		return manpowers;
	}

}
