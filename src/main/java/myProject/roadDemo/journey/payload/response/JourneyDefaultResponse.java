package myProject.roadDemo.journey.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JourneyDefaultResponse {
    private Integer id;
    private String name;
    private Double pay;
    private Double range;
    private Double fuelConsumption;
    private LocalDateTime date;
}
