package myProject.roadDemo.journey.controller;

import java.util.List;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import myProject.roadDemo.journey.entity.Journey;
import myProject.roadDemo.journey.mapper.JourneyToJourneyDefaultResponseMapper;
import myProject.roadDemo.journey.payload.response.JourneyDefaultResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myProject.roadDemo.journey.service.JourneyService;
import myProject.roadDemo.journey.payload.request.CreateJourneyRequest;
import myProject.roadDemo.journey.payload.response.GetAllJourneyResponse;

@RestController
@RequestMapping("/api/journeys")
@RequiredArgsConstructor
public class JourneyController {

	private final JourneyService journeyService;


	@PostMapping
	public ResponseEntity<?> save(
			@RequestBody @Valid CreateJourneyRequest request
	) {

		Journey journey = journeyService.save(request);
		JourneyDefaultResponse response = JourneyToJourneyDefaultResponseMapper.toDto(journey);

		return ResponseEntity.ok(response);
	}

	/*
	@GetMapping
	public List<GetAllJourneyResponse> getAll(

	){
		return journeyService.getAll();
	}

	 */
	
}