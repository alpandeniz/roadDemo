package myProject.roadDemo.entities.concretes.journeyMapper;


import myProject.roadDemo.dto.responses.GetAllJourneyByUserId;
import myProject.roadDemo.journey.entity.Journey;

import java.util.ArrayList;
import java.util.List;

public class JourneyMapper {

    public GetAllJourneyByUserId toDto(
            Journey journey
    ){
        return GetAllJourneyByUserId
                .builder()
                .name(journey.getJourneyName())
                .id(journey.getId())
                .pay(journey.getPay())
                .range(journey.getRange())
                .fuelConsumption(journey.getFuelConsumption())
                .userName(journey.getJourneyName())
                .build();
    }

    public List<GetAllJourneyByUserId> toDtoList(
            List<Journey> journeyList
    ){
        List<GetAllJourneyByUserId> dtoList = new ArrayList<>();

        for (Journey journeyEntity :
                journeyList) {
            dtoList.add(toDto(journeyEntity));
        }

        return dtoList;

    }

}
