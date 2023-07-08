package myProject.roadDemo.journey.service;

import java.util.List;

import myProject.roadDemo.journey.entity.Journey;
import myProject.roadDemo.journey.payload.request.CreateJourneyRequest;
import myProject.roadDemo.journey.payload.response.GetAllJourneyResponse;

public interface JourneyService {
	public Journey save(CreateJourneyRequest createJourneyRequest);
	List<GetAllJourneyResponse> getAll();
	//List<GetAllJourneyByUserId> getAllByUserId(int id);
}
