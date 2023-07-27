package myProject.roadDemo.vehicle.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import myProject.roadDemo.journey.entity.Journey;
import myProject.roadDemo.user.entity.User;

import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="models")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="name")
	private String name;

	@Column(name="hp")
	private Double horsepower;

	@Column(name="cc")
	private Double displacement;

	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	@OneToMany(
			mappedBy = "vehicle",
			fetch = FetchType.LAZY
	)
	private List<Journey> journeys;

	public void addJourney(Journey journey){
		this.journeys.add(journey);
		journey.setVehicle(this);
	}

}
