package myProject.roadDemo.vehicle.mapper;

import myProject.roadDemo.vehicle.entity.Vehicle;
import myProject.roadDemo.vehicle.payload.response.VehicleGetResponse;


public class VehicleMapper {

    public static VehicleGetResponse toGetResponse(
            Vehicle vehicle
    ){
        return VehicleGetResponse.builder()
                .id(vehicle.getId())
                .name(vehicle.getName())
                .brandName(
                        vehicle.getBrand().getName()
                )
                .userName(vehicle.getUser().getName())
                .build();
    }

}
