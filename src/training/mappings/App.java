package training.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import training.entity.Car;
import training.entity.CarPerformance;
import training.entity.Rim;
import training.entity.Tire;

public class App {


	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Car.class)
				.addAnnotatedClass(CarPerformance.class)
				.addAnnotatedClass(Rim.class)
				.addAnnotatedClass(Tire.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		Car car;
		CarPerformance carPerformance;
		
		try {
			session.beginTransaction();
			car = new Car("Audi", "White", "Sedan");
			carPerformance = new CarPerformance(180,8);
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
