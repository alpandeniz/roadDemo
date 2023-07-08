package myProject.roadDemo.vehicle.service;

import myProject.roadDemo.vehicle.payload.request.CreateBrandRequest;

public interface BrandService {
	void save(CreateBrandRequest createBrandRequest);
	
}
