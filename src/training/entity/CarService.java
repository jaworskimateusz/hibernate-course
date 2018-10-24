package training.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="car_services")
public class CarService {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone_number")
	private int phoneNumber;
	
	@OneToMany(fetch=FetchType.LAZY,
			   cascade= {CascadeType.DETACH, CascadeType.MERGE,
					   	 CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="service_car",
				joinColumns=@JoinColumn(name="service_id"),
				inverseJoinColumns=@JoinColumn(name="car_id"))
	private List<Car> serviceCars;
	
	public CarService() {
		
	}

	public CarService(String name, String address, int phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public List<Car> getServiceCars() {
		return serviceCars;
	}

	public void setServiceCars(List<Car> serviceCars) {
		this.serviceCars = serviceCars;
	}
	
	public void addCarToService(Car car) {
		if(serviceCars == null) {
			serviceCars = new ArrayList<>();
		}
		serviceCars.add(car);
	}

	@Override
	public String toString() {
		return "CarService [id=" + id + ", name=" + name + 
				", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}
	
}

