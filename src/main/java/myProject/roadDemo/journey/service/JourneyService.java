package myProject.roadDemo.journey.service;

import java.util.List;

import myProject.roadDemo.dto.requests.CreateJourneyRequest;
import myProject.roadDemo.dto.responses.GetAllJourneyResponse;

public interface JourneyService {
	void save(CreateJourneyRequest createJourneyRequest);
	List<GetAllJourneyResponse> getAll();
	//List<GetAllJourneyByUserId> getAllByUserId(int id);
}
