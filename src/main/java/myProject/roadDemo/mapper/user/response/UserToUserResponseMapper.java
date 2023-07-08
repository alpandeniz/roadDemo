package myProject.roadDemo.mapper.user.response;

import myProject.roadDemo.dto.responses.UserResponse;
import myProject.roadDemo.user.entity.User;

public class UserToUserResponseMapper {
    public  static UserResponse toDto(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                //TODO******* BURADA KULLANICI ÜZERİNDEN MODEL ID ÇEKMEYE ÇALIŞTIM ANCAK OLMADI
               // .modelId(user.getModels())
                .build();
    }
}
