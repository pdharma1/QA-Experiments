package isp.dal.impls;

import java.util.List;

import org.hibernate.Session;

import isp.dal.beans.Constitution;
import isp.dal.conn.HibernateFactory;
import isp.dal.interfaces.IConstitution;

public class ConstitutionImpl implements IConstitution {

	private List<Constitution> constitutions = null;
	private Session session = null;
	private HibernateFactory factory = new HibernateFactory();

	public List<Constitution> getAllConstitutions() {

		try {
			session = factory.getSession();
			session.beginTransaction();
			constitutions = session.createQuery("from Constitution").list();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return constitutions;
	}

}
