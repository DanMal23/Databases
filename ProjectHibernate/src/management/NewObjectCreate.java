package management;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.OperSys;

public class NewObjectCreate {
	public static void main(String[] args) throws Exception {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(OperSys.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			OperSys tempOS = new OperSys("Ubuntu touch", 2013);
			session.beginTransaction();
			session.save(tempOS);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}
