package training.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import training.entity.Car;
import training.entity.CarPerformance;
import training.entity.Rim;

public class GetCarRims {


	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Car.class)
				.addAnnotatedClass(CarPerformance.class)
				.addAnnotatedClass(Rim.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		int id = 2;
		
		try {
			session.beginTransaction();
			Car car = session.get(Car.class, id);
			printRims(car);
			session.getTransaction().commit();
			System.out.println("\nSuccesfull!");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
		
	}
	
	private static void printRims(Car car) {
		if(car != null) {
			for(Rim rim : car.getRims()) {
				System.out.println("\n" + rim);
			}
		} else {
			System.out.println("Cannot found");
		}
	}

}
