package eagervslazy;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;

public class FetchJoinDemo {

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
			
			//load the instructor and courses at once
			Query<Instructor> query =
					session.createQuery("SELECT i FROM Instructor i "
										+ "JOIN FETCH i.courses "
										+ "WHERE i.id=:instructorId", 
							Instructor.class);

			query.setParameter("instructorId", id);
			
			//load instructor and courses all at once
			Instructor instructor = query.getSingleResult();
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
			System.out.println("Instructor: " + instructor + "\n");
			for(Course course : instructor.getCourses())
				System.out.println("\n " + course);
		} else {
			System.out.println("empty");
		}
	}

}
