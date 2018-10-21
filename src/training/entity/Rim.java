package training.entity;

import javax.persistence.*;

@Entity
@Table(name="rim")
public class Rim {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="inches")
	private int inches;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="car_id")
	private Car car;
	
	public Rim() {
		
	}

	public Rim(int inches) {
		this.inches = inches;
	}

	public int getInches() {
		return inches;
	}

	public void setInches(int inches) {
		this.inches = inches;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Rim [id=" + id + ", inches=" + inches + ", car=" + car + "]";
	}
	
}
