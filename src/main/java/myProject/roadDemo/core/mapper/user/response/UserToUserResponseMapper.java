package myProject.roadDemo.core.mapper.user.response;

import myProject.roadDemo.user.payload.response.UserResponse;
import myProject.roadDemo.user.entity.User;

public class UserToUserResponseMapper {
    public  static UserResponse toDto(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }
}
