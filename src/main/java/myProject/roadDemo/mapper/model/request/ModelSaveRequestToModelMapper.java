package myProject.roadDemo.mapper.model.request;

import myProject.roadDemo.dto.requests.CreateModelRequest;
import myProject.roadDemo.entities.concretes.Brand;
import myProject.roadDemo.entities.concretes.Model;

public class ModelSaveRequestToModelMapper {

    public static Model toEntity(CreateModelRequest request, Brand brand){
        return Model.builder()
                .name(request.getName())
                .brand(
                    brand
                )
                .horsepower(request.getHorsepower())
                .displacement(request.getDisplacement())
                .build();

    }
}
