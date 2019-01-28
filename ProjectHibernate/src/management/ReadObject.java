package management;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.OperSys;

public class ReadObject {
	public static void main(String[] args) throws Exception {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(OperSys.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			OperSys tempOS = new OperSys("Chromium OS", 2009);
			session.beginTransaction();
			System.out.println("Saving object: ");
			System.out.println(tempOS);
			session.save(tempOS);
			session.getTransaction().commit();
			// =======================================================
			// retrieving the object from 'mydb' databases

			session = factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Getting year for the saved OS: " + tempOS.getYear());

			OperSys myOS = session.get(OperSys.class, tempOS.getYear());

			System.out.println("Complete: " + myOS);

			session.getTransaction().commit();

		} finally {

			factory.close();
		}

	}

}
