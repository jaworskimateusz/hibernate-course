package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class ReadStudent {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("\nReading a student object.");
			session.beginTransaction();
			System.out.println(getNewStudent(session, new Student(), 1));
			session.getTransaction().commit();
			System.out.println("\nTransaction successful.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
	private static String getNewStudent(Session session, Student student, int id) {
		student = session.get(Student.class, id);
		return (student != null) ? student.toString()
				: "Student not found";
	}

}
