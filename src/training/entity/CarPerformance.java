package training.entity;

import javax.persistence.*;

@Entity
@Table(name="car_performance")
public class CarPerformance {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="horsepower")
	private int horsepower;
	
	@Column(name="acceleration")
	private int acceleration;
	
	public CarPerformance() {
		
	}

	public CarPerformance(int horsepower, int acceleration) {
		this.horsepower = horsepower;
		this.acceleration = acceleration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}

	public int getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(int acceleration) {
		this.acceleration = acceleration;
	}

	@Override
	public String toString() {
		return "CarPerformance [id=" + id +
				", horsepower=" + horsepower +
				", acceleration=" + acceleration + "]";
	}
	
}
