package myProject.roadDemo.mapper.user.request;

import myProject.roadDemo.dto.requests.CreateUserRequest;
import myProject.roadDemo.journey.entity.Journey;
import myProject.roadDemo.entities.concretes.Model;
import myProject.roadDemo.user.entity.User;

public class UserSaveRequestToMapper {
    public static User toEntity(CreateUserRequest createUserRequest,
                                Journey journey,
                                Model model
    ){

        return  User.builder()
                .name(createUserRequest.getName())
                /*------->>> .journeys(
                        journey.getId()
                )
                .models(
                        List<model>
                ) <<<---------*/
                .build();
    }
}
