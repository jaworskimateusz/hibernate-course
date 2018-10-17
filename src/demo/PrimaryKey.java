package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class PrimaryKey {

public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			realizeTransaction(session, createStudent("Mike", "Apple", "apple@email.com"));
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	private static Student createStudent(String firstName, String lastName, String email) {
		return new Student(firstName, lastName, email);
	}
	
	private static void realizeTransaction(Session session, Student car) {
		session.beginTransaction();
		session.save(car);
		session.getTransaction().commit();
		getTransactionResult();
	}
	
	private static void getTransactionResult() {
		System.out.println("\nTransaction successful");
	}

}
