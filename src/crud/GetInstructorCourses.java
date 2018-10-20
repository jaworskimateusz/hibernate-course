package crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import entity.Student;
//one to many
public class GetInstructorCourses {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		int id = 3;
		try {
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, id);
			printCourses(instructor);
			session.getTransaction().commit();
			System.out.println("\nTransaction successful.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
	
	private static void printCourses(Instructor instructor) {
		if(instructor != null) {
			for(Course course : instructor.getCourses())
				System.out.println("\n " + course);
		} else {
			System.out.println("empty");
		}
	}

}
