package myProject.roadDemo.core.mapper.model.response;


import myProject.roadDemo.vehicle.payload.response.VehicleGetResponse;
import myProject.roadDemo.vehicle.entity.Vehicle;

public class ModelToModelResponseMapper {

    public static VehicleGetResponse toDto(Vehicle vehicle){
        return VehicleGetResponse.builder()
                .id(vehicle.getId())
                .name(vehicle.getName())
                .brandName(vehicle.getBrand().getName())
                .build();
    }

}
