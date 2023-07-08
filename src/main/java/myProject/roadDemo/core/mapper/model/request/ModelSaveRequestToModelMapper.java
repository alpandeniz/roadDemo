package myProject.roadDemo.core.mapper.model.request;

import myProject.roadDemo.vehicle.payload.request.CreateModelRequest;
import myProject.roadDemo.vehicle.entity.Brand;
import myProject.roadDemo.vehicle.entity.Vehicle;

public class ModelSaveRequestToModelMapper {

    public static Vehicle toEntity(CreateModelRequest request, Brand brand){
        return Vehicle.builder()
                .name(request.getName())
                .brand(
                    brand
                )
                .horsepower(request.getHorsepower())
                .displacement(request.getDisplacement())
                .build();

    }
}
