package myProject.roadDemo.mapper.model.response;


import myProject.roadDemo.dto.responses.ModelResponse;
import myProject.roadDemo.entities.concretes.Model;

public class ModelToModelResponseMapper {

    public static ModelResponse toDto(Model model){
        return ModelResponse.builder()
                .id(model.getId())
                .name(model.getName())
                .brandName(model.getBrand().getName())
                .build();
    }

}
