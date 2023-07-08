package myProject.roadDemo.user.mapper;

import myProject.roadDemo.journey.mapper.JourneyToJourneyDefaultResponseMapper;
import myProject.roadDemo.user.entity.User;
import myProject.roadDemo.user.payload.response.UserSavedResponse;

import java.util.stream.Collectors;

public class UserToUserSavedResponseMapper {

    public static UserSavedResponse toDto(
            User user
    ) {
        return UserSavedResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .journey(
                        user.getJourneys().stream()
                                .map(JourneyToJourneyDefaultResponseMapper::toDto)
                                .collect(Collectors.toList())
                )
                .build();

    }
}
