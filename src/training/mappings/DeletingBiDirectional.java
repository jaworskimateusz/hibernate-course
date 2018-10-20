package training.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import training.entity.Car;
import training.entity.CarPerformance;

public class DeletingBiDirectional {


	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Car.class)
				.addAnnotatedClass(CarPerformance.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		CarPerformance carPerformance;
		int id = getId();
		
		try {
			session.beginTransaction();
			carPerformance = session.get(CarPerformance.class,id);
			carPerformance.getCar().setCarPerformance(null);
			deleteIfNotNull(carPerformance, session);
			session.getTransaction().commit();
			System.out.println("\nSuccesfull!");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

	private static void deleteIfNotNull(CarPerformance carPerformance, Session session) {
		if(carPerformance != null) {
			session.delete(carPerformance);
		} else {
			System.out.println("Cannot found.");
		}
	}

	private static int getId() {
		return 6;
	}
}
