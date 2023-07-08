package myProject.roadDemo.journey.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import myProject.roadDemo.journey.service.JourneyService;
import myProject.roadDemo.dto.requests.CreateJourneyRequest;
import myProject.roadDemo.dto.responses.GetAllJourneyResponse;

@AllArgsConstructor
@RestController
@RequestMapping("/api/journeys")
public class JourneyController {
	private JourneyService journeyService;
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateJourneyRequest createJourneyRequest) {
		this.journeyService.save(createJourneyRequest);
	}
	
	@GetMapping
	public List<GetAllJourneyResponse> getAll(

	){
		return journeyService.getAll();
	}
	
}