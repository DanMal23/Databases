package management;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.OperSys;

public class QueryDataDisplay {
	public static void main(String[] args) throws Exception {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(OperSys.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			List<OperSys> theOS = session.createQuery("from OperSys").getResultList(); // or .list()

			displayOSes(theOS);

			// query and display
			theOS = session.createQuery("from OperSys o where o.year>='2000'").getResultList();
			System.out.println("\nOSes from mydb released after 2000\n");
			displayOSes(theOS);

			System.out.println("\nOSes which name in mydb ends in 'OS'\n");
			theOS = session.createQuery("from OperSys o where o.osname LIKE '%OS'").getResultList();
			displayOSes(theOS);

			System.out.println("\nOSes released after 1970 AND whose name starts with 'A'\n");
			theOS = session.createQuery("from OperSys o where " + "o.year>='1970' AND o.osname LIKE 'A%'")
					.getResultList();
			displayOSes(theOS);

			session.getTransaction().commit();

		} finally {

			factory.close();
		}

	}

	private static void displayOSes(List<OperSys> theOS) {
		for (OperSys tempOS : theOS) { // Refactor > extract Method > create dispalyOSes(theOS) method
			System.out.println(tempOS);
		}
	}

}
