package management;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.OperSys;

public class QueryTheDB {
	public static void main(String[] args) throws Exception {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(OperSys.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			// query the data
			List<OperSys> theOS = session.createQuery("from OperSys").list();

			// display all data
			for (OperSys tempOS : theOS) {
				System.out.println(tempOS);
			}

			session.getTransaction().commit();

		} finally {

			factory.close();
		}

	}

}
