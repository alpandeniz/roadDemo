package myProject.roadDemo.journey.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import myProject.roadDemo.journey.service.JourneyService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import myProject.roadDemo.core.utilities.mappers.ModelMapperService;
import myProject.roadDemo.journey.repo.JourneyRepository;
import myProject.roadDemo.dto.requests.CreateJourneyRequest;
import myProject.roadDemo.dto.responses.GetAllJourneyResponse;
import myProject.roadDemo.journey.entity.Journey;

//@AllArgsConstructor
@RequiredArgsConstructor
@Service
public class JourneyServiceImpl implements JourneyService {

	private final ModelMapperService modelMapperService;
	private final JourneyRepository journeyRepository;
	

	@Override
	public void save(CreateJourneyRequest createJourneyRequest) {
		
		
		
		Journey journey = this.modelMapperService.forRequest().map(createJourneyRequest, Journey.class);
		//calculateFuelCost(createJourneyRequest.getFuelConsumption(), createJourneyRequest.getRange());
		//journey.setPay(calculateFuelCost(createJourneyRequest.getFuelConsumption(), createJourneyRequest.getRange()));
		calculateFuelCostForJourney(journey,createJourneyRequest);
		journeyRepository.save(journey);
		
	}
		
//	public Double calculateFuelCost(Double fuelConsumption, Double range) {
//        Double fuelUsed = (fuelConsumption / 100) * range; 
//        return fuelUsed * 25; 
//    }

	public void calculateFuelCostForJourney(Journey journey, CreateJourneyRequest request ){
		Double fuelConsumption = request.getFuelConsumption();
		Double range = request.getRange();
		Double fuelUsed = (fuelConsumption / 100) * range;
		journey.setPay(fuelUsed*25);
	}

	@Override
	public List<GetAllJourneyResponse> getAll() {
		List<Journey> journeys = this.journeyRepository.findAll();
		List<GetAllJourneyResponse> response = journeys.stream()
				.map(journey-> this.modelMapperService.forResponse()
						.map(journeys, GetAllJourneyResponse.class)).collect(Collectors.toList());
		return response;
	}

	
}
