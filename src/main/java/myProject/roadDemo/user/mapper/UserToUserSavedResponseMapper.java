package myProject.roadDemo.user.mapper;

import myProject.roadDemo.journey.entity.Journey;
import myProject.roadDemo.journey.mapper.JourneyToJourneyDefaultResponseMapper;
import myProject.roadDemo.user.entity.User;
import myProject.roadDemo.user.payload.response.UserSavedResponse;
import myProject.roadDemo.vehicle.entity.Vehicle;
import myProject.roadDemo.vehicle.mapper.VehicleMapper;

import java.util.stream.Collectors;

public class UserToUserSavedResponseMapper {

    /**
     *
     * @param user
     * @return
     */
    public static UserSavedResponse toDto(
            User user,
            Vehicle vehicle,
            Journey journey
    ) {
        return UserSavedResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .journey(
                        JourneyToJourneyDefaultResponseMapper.toDto(journey)
                )
                .vehicle(
                        VehicleMapper.toGetResponse(vehicle)
                )
                .build();
    }
}
