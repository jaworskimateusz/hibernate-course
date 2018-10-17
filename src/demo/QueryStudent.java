package demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class QueryStudent {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			realizeQuery(new ArrayList<Student>(), session,
					"FROM Student");
			realizeQuery(new ArrayList<Student>(), session,
					"FROM Student x WHERE x.lastName='Black'");
			realizeQuery(new ArrayList<Student>(), session,
					"FROM Student x WHERE x.email LIKE '%email.com'");
			realizeQuery(new ArrayList<Student>(), session,
					"FROM Student x WHERE x.lastName='Wick' OR x.lastName='Apple'");
			
			session.getTransaction().commit();
			System.out.println("\nTransaction successful.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	private static void realizeQuery(List<Student> students, Session session, String queryContent) {
		students = session.createQuery(queryContent).getResultList();
		System.out.println("\n\nSELECT * " + queryContent + "\n");
		printRealizedQuery(students);
	}

	private static void printRealizedQuery(List<Student> students) {
		for(Student student : students) {
			System.out.println(student);
		}
	}

}
