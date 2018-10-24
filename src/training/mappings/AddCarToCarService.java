package training.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import training.entity.Car;
import training.entity.CarPerformance;
import training.entity.CarService;
import training.entity.Rim;
import training.entity.Tire;

public class AddCarToCarService {


	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Car.class)
				.addAnnotatedClass(CarPerformance.class)
				.addAnnotatedClass(Rim.class)
				.addAnnotatedClass(Tire.class)
				.addAnnotatedClass(CarService.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		Car car;
		CarService carService;
		
		try {
			session.beginTransaction();
			car = new Car("Aston Martin", "Silver", "Coupe");
			session.save(car);
			carService = new CarService("The Fasters", "Green Street 1", 512412523);
			carService.addCarToService(car);
			session.save(carService);
			session.getTransaction().commit();
			System.out.println("\nSuccesfull!");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

}
