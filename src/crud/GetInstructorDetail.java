package crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Instructor;
import entity.InstructorDetail;
import entity.Student;

public class GetInstructorDetail {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		Instructor instructor;
		InstructorDetail instructorDetail;
		int id = 4;
		try {
			session.beginTransaction();
			instructorDetail =
					session.get(InstructorDetail.class, id);
			System.out.println("InstructorDetail: " + instructorDetail);
			System.out.println("the associated instructor: " +
								instructorDetail.getInstructor());
			session.getTransaction().commit();
			System.out.println("\nTransaction successful.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
