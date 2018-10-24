package crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import entity.Review;
import entity.Student;
//one to many
public class GetCourseFromStudent {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Student student = session.get(Student.class, 2);
			printCourse(student);
			session.getTransaction().commit();
			
			System.out.println("\nTransaction successful.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
	
	private static void printCourse(Student student) {
		if(student != null) {
			System.out.println("Courses for: " + student.getFirstName());
			for(Course course : student.getCourses())
				System.out.println("\n" + course);
		} else {
			System.out.println("empty");
		}
	}

}
