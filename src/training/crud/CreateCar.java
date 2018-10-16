package training.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import training.entity.Car;

public class CreateCar {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Car.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			realizeTransaction(session, createCar("BMW", "Blue", "Hatchback"));
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	private static Car createCar(String brand, String color, String body) {
		return new Car(brand, color, body);
	}
	
	private static void realizeTransaction(Session session, Car car) {
		session.beginTransaction();
		session.save(car);
		session.getTransaction().commit();
		getTransactionResult();
	}
	
	private static void getTransactionResult() {
		System.out.println("\nTransaction successful");
	}

}
