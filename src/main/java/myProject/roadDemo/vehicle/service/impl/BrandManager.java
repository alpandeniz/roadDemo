package myProject.roadDemo.vehicle.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import myProject.roadDemo.vehicle.service.BrandService;
import myProject.roadDemo.core.rules.BrandBusinessRules;
import myProject.roadDemo.core.mappers.ModelMapperService;
import myProject.roadDemo.vehicle.repository.BrandRepository;
import myProject.roadDemo.vehicle.payload.request.CreateBrandRequest;
import myProject.roadDemo.vehicle.entity.Brand;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
	private final BrandRepository brandRepository;
	private final ModelMapperService modelMapperService;
	private final BrandBusinessRules brandBusinessRules;
	@Override
	public void save(CreateBrandRequest createBrandRequest) {
		try {
			this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
			Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
			this.brandRepository.save(brand);
		}catch (Exception exception){
			exception.getMessage();
		}

	}

}
