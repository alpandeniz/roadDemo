package myProject.roadDemo.journey.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class CreateJourneyRequest {
	
	private String name;
	private LocalDateTime date;	//Example Post Data 2023-07-08T10:30:00
	private Double range;
	private Double fuelConsumption;
	private Integer userId;
	private Integer vehicleId;
	
}
