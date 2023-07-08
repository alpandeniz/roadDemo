package myProject.roadDemo.core.mapper.model.response;


import myProject.roadDemo.vehicle.payload.response.ModelResponse;
import myProject.roadDemo.vehicle.entity.Vehicle;

public class ModelToModelResponseMapper {

    public static ModelResponse toDto(Vehicle vehicle){
        return ModelResponse.builder()
                .id(vehicle.getId())
                .name(vehicle.getName())
                .brandName(vehicle.getBrand().getName())
                .build();
    }

}
