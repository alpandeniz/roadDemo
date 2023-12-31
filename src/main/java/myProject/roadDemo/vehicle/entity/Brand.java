package myProject.roadDemo.vehicle.entity;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import myProject.roadDemo.vehicle.entity.Vehicle;

@Table(name="brands ")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;

	@OneToMany(
			mappedBy = "brand",
			fetch = FetchType.LAZY
	)
	private List<Vehicle> vehicles;
}
