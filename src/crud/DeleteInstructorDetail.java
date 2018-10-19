package crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Instructor;
import entity.InstructorDetail;
import entity.Student;

public class DeleteInstructorDetail {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		InstructorDetail instructorDetail;
		int id = 5;
		try {
			session.beginTransaction();
			instructorDetail =
					session.get(InstructorDetail.class, id);
			//deleteInstructorDetail(instructorDetail, session);
			//do this step if you want delete only instructorDetail
			//without linked Instructor... one code line below
			//breaking two-way link for this relationship
			
			instructorDetail.getInstructor().setInstructorDetail(null);;
			deleteInstructorDetail(instructorDetail, session);
			session.getTransaction().commit();
			System.out.println("\nTransaction successful.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
	
	private static void deleteInstructorDetail(InstructorDetail instructorDetail, Session session) {
		if(instructorDetail != null) {
			session.delete(instructorDetail);
		} else {
			System.out.println("Cannot found");
		}
	}
}
