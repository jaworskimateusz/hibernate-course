package training.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import training.entity.Car;
import training.entity.CarPerformance;
import training.entity.Rim;

public class CreateRim {


	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Car.class)
				.addAnnotatedClass(CarPerformance.class)
				.addAnnotatedClass(Rim.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
		try {
			session.beginTransaction();
			Car car = session.get(Car.class, 2);
			Rim rim = new Rim(19);
			car.addRim(rim);
			session.save(rim);
			session.getTransaction().commit();
			System.out.println("\nSuccesfull!");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

}
