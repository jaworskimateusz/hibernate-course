package crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Instructor;
import entity.InstructorDetail;
import entity.Student;
//one to one uni
public class Create {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Instructor instructor =
					new Instructor("Done", "Joe", "don.joe@email.com");
			
			InstructorDetail instructorDetail = 
					new InstructorDetail(
							"http://www.coding.com/youtube",
							"coding");
			instructor.setInstructorDetail(instructorDetail);
			session.save(instructor);
			
			session.getTransaction().commit();
			System.out.println("\nTransaction successful.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
