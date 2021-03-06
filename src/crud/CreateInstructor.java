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
public class CreateInstructor {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Instructor instructor =
					new Instructor("Chad", "Darby", "chad.darby@yahoo.com");
			
			InstructorDetail instructorDetail = 
					new InstructorDetail(
							"http://www.luv2code.com/youtube",
							"coding");
			instructor.setInstructorDetail(instructorDetail);
			session.save(instructor);
			
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
