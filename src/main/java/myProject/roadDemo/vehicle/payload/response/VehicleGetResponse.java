package myProject.roadDemo.vehicle.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleGetResponse {
    private Integer id;
    private String name;
    private String brandName;
    private String userName;
}
