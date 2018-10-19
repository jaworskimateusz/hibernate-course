package crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Instructor;
import entity.InstructorDetail;
import entity.Student;

public class Delete {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		Instructor instructor;
		try {
			session.beginTransaction();
			instructor = session.get(Instructor.class, 4);
			isNull(instructor, session);
			session.getTransaction().commit();
			System.out.println("\nTransaction successful.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
	
	private static void isNull(Instructor instructor, Session session) {
		if(instructor != null) {
			session.delete(instructor);
		} else {
			System.out.println("Cannot found");
		}
	}
}
