package myProject.roadDemo.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import myProject.roadDemo.business.abstracts.ModelService;
import myProject.roadDemo.dto.requests.CreateModelRequest;
import myProject.roadDemo.dto.responses.GetAllModelsResponse;

@RestController
@AllArgsConstructor
@RequestMapping("/api/models")
public class ModelController {

	private ModelService modelService;
	
	@PostMapping
	//@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody @Valid CreateModelRequest createModelRequest) {
		try {
			return ResponseEntity.ok(modelService.save(createModelRequest));
		} catch (Exception exception){
			return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		}

	}	
	
	@GetMapping
	public List<GetAllModelsResponse> getAll(

	){
		return modelService.getAll();
	}
}
