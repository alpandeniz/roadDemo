package myProject.roadDemo.vehicle.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import myProject.roadDemo.vehicle.service.BrandService;
import myProject.roadDemo.vehicle.payload.request.CreateBrandRequest;
//@AllArgsConstructor
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/brands")
public class BrandController {
	private final BrandService brandService;

	//Api Best Practices
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(
			@RequestBody @Valid CreateBrandRequest createBrandRequest
	) {
		this.brandService.save(createBrandRequest);
	}


	/*
	@PostMapping
	public ResponseEntity<?> saveBrand(
			@RequestBody @Valid CreateBrandRequest request
	){
		this.brandService.add(request);

		return ResponseEntity(request,HttpStatus.CREATED);
	}

	 */
}
