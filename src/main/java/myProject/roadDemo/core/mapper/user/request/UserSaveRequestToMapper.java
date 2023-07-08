package myProject.roadDemo.core.mapper.user.request;

import myProject.roadDemo.user.payload.request.CreateUserRequest;
import myProject.roadDemo.journey.entity.Journey;
import myProject.roadDemo.vehicle.entity.Vehicle;
import myProject.roadDemo.user.entity.User;

public class UserSaveRequestToMapper {
    public static User toEntity(CreateUserRequest createUserRequest,
                                Journey journey,
                                Vehicle vehicle
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
