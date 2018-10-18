package training.entity;

import javax.persistence.*;

@Entity
@Table(name="car")
public class Car {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="color")
	private String color;
	
	@Column(name="body")
	private String body;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="car_performance_id")
	private CarPerformance carPerformance;
	
	public Car() {
		
	}

	public Car(String brand, String color, String body) {
		this.brand = brand;
		this.color = color;
		this.body = body;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public CarPerformance getCarPerformance() {
		return carPerformance;
	}

	public void setCarPerformance(CarPerformance carPerformance) {
		this.carPerformance = carPerformance;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + 
				", color=" + color + ", body=" + body + 
				", carPerformance=" + carPerformance + "]";
	}
	
	
}
