package myProject.roadDemo.journey.mapper;

import myProject.roadDemo.journey.payload.response.JourneyDefaultResponse;
import myProject.roadDemo.journey.entity.Journey;

public class JourneyToJourneyDefaultResponseMapper {

    public static JourneyDefaultResponse toDto(
        Journey journey
    ){
        return JourneyDefaultResponse.builder()
                .id(journey.getId())
                .name(journey.getJourneyName())
                .pay(journey.getPay())
                .range(journey.getRange())
                .fuelConsumption(journey.getFuelConsumption())
                .date(journey.getDate())
                .build();
    }

}
