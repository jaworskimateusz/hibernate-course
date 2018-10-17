package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class UpdateStudent {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("\nUpdate a student object.");
			session.beginTransaction();
			Student student = session.get(Student.class, 2);
			//student.setFirstName("Jack"); or 
			session.createQuery("UPDATE Student set email='poker@gmail.com'"
					+ " WHERE firstName='Jack'")
					.executeUpdate();
			session.getTransaction().commit();
			System.out.println("\nTransaction successful.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
}
