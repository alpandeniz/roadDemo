package myProject.roadDemo.user.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import myProject.roadDemo.journey.entity.Journey;
import myProject.roadDemo.journey.payload.response.JourneyDefaultResponse;
import myProject.roadDemo.vehicle.payload.response.VehicleGetResponse;

import java.util.List;

/**
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSavedResponse {
    private Integer id;
    private String name;
    private JourneyDefaultResponse journey;
    private VehicleGetResponse vehicle;
}
