package isp.dal.impls;

import java.util.List;

import org.hibernate.Session;

import isp.dal.beans.Activity;
import isp.dal.conn.HibernateFactory;
import isp.dal.interfaces.IActivity;

public class ActivityImpl implements IActivity {

	private List<Activity> activities = null;

	@Override
	public List<Activity> getActivities() {

		HibernateFactory factory = new HibernateFactory();
		Session session = null;
		try {
			session = factory.getSession();
			activities = session.createQuery("from Activity").list();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			factory.closeSession(session);
		}

		return activities;
	}

}
