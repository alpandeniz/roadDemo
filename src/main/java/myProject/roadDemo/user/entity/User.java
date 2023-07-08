package myProject.roadDemo.user.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import myProject.roadDemo.journey.entity.Journey;
import myProject.roadDemo.vehicle.entity.Vehicle;


@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "user")
	private List<Journey> journeys = new ArrayList<>();

	@OneToMany(
			mappedBy = "users",
			fetch = FetchType.LAZY
	)
	private List<Vehicle> vehicles;

	public void addJourney(Journey journey){
		this.journeys.add(journey);
		journey.setUser(this);
	}


}
