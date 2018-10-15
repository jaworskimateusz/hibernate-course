package training.crud;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import training.entity.Car;

public class QueryCar {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Car.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			realizeSession(new ArrayList<Car>(), session, "FROM Car");
			realizeSession(new ArrayList<Car>(), session, "FROM Car WHERE color='black'");
			realizeSession(new ArrayList<Car>(), session, "FROM Car WHERE body='Hatchback'");
			realizeSession(new ArrayList<Car>(), session, "FROM Car WHERE brand like'A%'");
			
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	private static void realizeSession(List<Car> cars,
			Session session, String query) {
		cars = session.createQuery(query).getResultList();
		printRealizedQuery(cars, query);
	}

	private static void printRealizedQuery(List<Car> cars, String query) {
		System.out.println("\nSELECT * " + query);
		for(Car car : cars) {
			System.out.println(car);
		}
	}

}
