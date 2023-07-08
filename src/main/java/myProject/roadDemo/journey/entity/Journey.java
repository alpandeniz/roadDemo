package myProject.roadDemo.journey.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import myProject.roadDemo.user.entity.User;
import myProject.roadDemo.vehicle.entity.Vehicle;

import java.time.LocalDateTime;

@Table(name="journeys")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Journey {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id; // TODO Wrapper Olarak Kullan -> Integer.
	
	@Column(name="name")
	private String journeyName;
	
	@Column(name="date") //
	private LocalDateTime date;
	
	@Column(name="range")
	private Double range;

	@Column(name="fuelConsumption")
	private Double fuelConsumption;

	@Column(name="pay")
	private Double pay;
	
	@ManyToOne(
			fetch = FetchType.LAZY
	)
	@JoinColumn(name="user_id")
	private User user;


	@ManyToOne(
			fetch = FetchType.LAZY
	)
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;

	@Override
	public String toString(){
		return "[" + id + ", " + journeyName +
				", "+date+", "+range+", "+
				fuelConsumption +", "+ pay +"]\n";
	}

	
}
