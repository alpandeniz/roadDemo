package myProject.roadDemo.journey.mapper.request;

import myProject.roadDemo.journey.entity.Journey;
import myProject.roadDemo.journey.payload.request.CreateJourneyRequest;

public class JourneyCreateRequestToJourneyMapper {

    public static Journey toDto(
            CreateJourneyRequest request
    ) {
        return Journey.builder()
                .journeyName(request.getName())
                .date(request.getDate())
                .range(request.getRange())
                .fuelConsumption(request.getFuelConsumption())
                .build();

    }
}
