package training.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;
import training.entity.Car;

public class ReadCar {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Car.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("\nReading a car object.");
			session.beginTransaction();
			System.out.println(getNewCar(session, new Car(), 2));
			session.getTransaction().commit();
			System.out.println("\nTransaction successful.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
	
	private static String getNewCar(Session session, Car car, int id) {
		car = session.get(Car.class, id);
		return (car != null) ? car.toString()
				: "Car not found";
	}

}
