package myProject.roadDemo.vehicle.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModelResponse {
    private Integer id;
    private String name;
    private String brandName;
}
