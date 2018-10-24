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
public class AddCourseToStudent {

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
			
			Course javaCourse = new Course("Spring & Hibernate for begginers");
			Course dotNetCourse = new Course("ASP.NET MVC");
			session.save(javaCourse);
			session.save(dotNetCourse);
			Student student = session.get(Student.class, 2);
			javaCourse.addStudent(student);
			dotNetCourse.addStudent(student);
			session.save(student);
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
