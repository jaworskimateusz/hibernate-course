package training.entity;

import javax.persistence.*;

@Entity
@Table(name="cars")
public class Car {
	
	@Id
	@Column(name="id")
	private int Id;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="color")
	private String color;
	
	@Column(name="body")
	private String body;
	
	public Car() {
		
	}

	public Car(String brand, String color, String body) {
		this.brand = brand;
		this.color = color;
		this.body = body;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	@Override
	public String toString() {
		return "Car [Id=" + Id + 
				", brand=" + brand + 
				", color=" + color + 
				", body=" + body + "]";
	}
	
}
