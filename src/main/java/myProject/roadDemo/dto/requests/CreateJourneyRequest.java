package myProject.roadDemo.dto.requests;

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
	
	private String journeyName;
	private LocalDateTime date;	//Example Post Data 2023-07-08T10:30:00
	private Double range;
	private int userId;
	
	private Double fuelConsumption;
	
}
