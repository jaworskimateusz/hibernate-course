package crud;

import org.hibernate.Session;
//many to many
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import entity.Review;
import entity.Student;
public class CreateCourseAndStudent {

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
			
			Course course = new Course("Spring & Hibernate for begginers");
			session.save(course);
			Student studentOne = new Student("John", "Doe", "john@doe.com");
			Student studentTwo = new Student("Matthew", "Jey", "mj@email.com");
			
			course.addStudent(studentTwo);
			course.addStudent(studentOne);
			
			session.save(studentOne);
			session.save(studentTwo);
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
