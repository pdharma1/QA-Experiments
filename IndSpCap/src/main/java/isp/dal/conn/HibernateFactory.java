package isp.dal.conn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateFactory {

	private SessionFactory sessionFactory = null;

	public HibernateFactory() {

		try {
			Configuration config = new Configuration();
			config.configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			this.sessionFactory = config.buildSessionFactory(serviceRegistry);
		} catch (Exception ex) {
			System.out.println("Error in Hibernate Factory");
			ex.printStackTrace();
		}
	}

	public Session getSession() throws Exception {

		return this.sessionFactory.openSession();
	}

	public void closeSession(Session session) {

		try {
			session.close();
			sessionFactory.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
