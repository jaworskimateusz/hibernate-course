package training.entity;

import java.util.ArrayList;
import java.util.List;

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
	
	@OneToMany(fetch=FetchType.LAZY,
				cascade=CascadeType.ALL)
	@JoinColumn(name="rim_id")
	private List<Tire> tires;

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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Tire> getTires() {
		return tires;
	}

	public void setTires(List<Tire> tires) {
		this.tires = tires;
	}
	
	public void addTire(Tire tire) {
		if(tires == null) {
			tires = new ArrayList<Tire>();
		}
		tires.add(tire);
	}

	@Override
	public String toString() {
		return "Rim [id=" + id + ", inches=" + inches + ", car=" + car + "]";
	}
	
}
