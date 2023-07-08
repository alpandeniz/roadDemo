package myProject.roadDemo.business.abstracts;

import myProject.roadDemo.dto.requests.CreateBrandRequest;

public interface BrandService {
	void save(CreateBrandRequest createBrandRequest);
	
}
