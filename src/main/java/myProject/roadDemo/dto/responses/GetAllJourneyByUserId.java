package myProject.roadDemo.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllJourneyByUserId {
	private String name;
	private int id;
	private Double pay;
	private Double range;
	private Double fuelConsumption;
	private String userName;
}
