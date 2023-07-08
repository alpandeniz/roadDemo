package myProject.roadDemo.journey.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import myProject.roadDemo.journey.mapper.request.JourneyCreateRequestToJourneyMapper;
import myProject.roadDemo.journey.service.JourneyService;
import myProject.roadDemo.user.entity.User;
import myProject.roadDemo.user.repository.UserRepository;
import myProject.roadDemo.vehicle.entity.Vehicle;
import myProject.roadDemo.vehicle.repository.ModelRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import myProject.roadDemo.core.mappers.ModelMapperService;
import myProject.roadDemo.journey.repo.JourneyRepository;
import myProject.roadDemo.journey.payload.request.CreateJourneyRequest;
import myProject.roadDemo.journey.payload.response.GetAllJourneyResponse;
import myProject.roadDemo.journey.entity.Journey;

//@AllArgsConstructor
@Service
@RequiredArgsConstructor
public class JourneyServiceImpl implements JourneyService {

	private final ModelMapperService modelMapperService;
	private final JourneyRepository journeyRepository;
	private final UserRepository userRepository;
	private final ModelRepository modelRepository;
	
	@Override
	public Journey save(
			CreateJourneyRequest request
	) {
		Journey journey = JourneyCreateRequestToJourneyMapper.toDto(request);

		if(request.getUserId() != null){
			User user = userRepository.findById(request.getUserId())
					.orElseThrow(()-> new RuntimeException("User not found with given id: "
					+request.getUserId()));
			user.addJourney(journey);
		}

		if(request.getVehicleId() != null){
			Vehicle vehicle =modelRepository.findById(request.getVehicleId())
					.orElseThrow(()->new RuntimeException("Vehicle not found with given id: "
							+ request.getVehicleId()));
			vehicle.addJourney(journey);
		}


		calculateFuelCostForJourney(journey);


		return journeyRepository.save(journey);
	}


	public void calculateFuelCostForJourney(Journey journey){
		Double fuelConsumption = journey.getFuelConsumption();
		Double range = journey.getRange();
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
