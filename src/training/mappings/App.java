package training.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import training.entity.Car;
import training.entity.CarPerformance;

public class App {


	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Car.class)
				.addAnnotatedClass(CarPerformance.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		Car car;
		CarPerformance carPerformance;
		
		try {
			session.beginTransaction();
			car = new Car("Aston Martin", "Silver", "Hatchback");
			carPerformance = new CarPerformance(420,5);
			car.setCarPerformance(carPerformance);
			session.save(car);
			session.getTransaction().commit();
			System.out.println("\nSuccesfull!");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

}
