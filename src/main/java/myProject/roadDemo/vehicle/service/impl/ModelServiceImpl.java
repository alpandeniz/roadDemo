package myProject.roadDemo.vehicle.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import myProject.roadDemo.core.rules.ModelBusinessRules;
import myProject.roadDemo.core.exceptions.BusinessException;
import myProject.roadDemo.vehicle.repository.BrandRepository;
import myProject.roadDemo.vehicle.payload.response.VehicleGetResponse;
import myProject.roadDemo.vehicle.entity.Brand;
import myProject.roadDemo.core.mapper.model.request.ModelSaveRequestToModelMapper;
import myProject.roadDemo.core.mapper.model.response.ModelToModelResponseMapper;
import org.springframework.stereotype.Service;

import myProject.roadDemo.vehicle.service.ModelService;
import myProject.roadDemo.core.mappers.ModelMapperService;
import myProject.roadDemo.vehicle.repository.VehicleRepository;
import myProject.roadDemo.vehicle.payload.request.CreateModelRequest;
import myProject.roadDemo.vehicle.payload.response.GetAllModelsResponse;
import myProject.roadDemo.vehicle.entity.Vehicle;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

	private final ModelMapperService modelMapperService;
	private final VehicleRepository vehicleRepository;
	private final ModelBusinessRules modelBusinessRules;
	private final BrandRepository brandRepository;


	
	@Override
	public VehicleGetResponse save(CreateModelRequest createModelRequest) throws Exception {


			Brand brand = brandRepository.findById(createModelRequest.getBrandId())
					.orElseThrow(()->new Exception("Böyle bir brand yok."));

			Vehicle vehicle = ModelSaveRequestToModelMapper.toEntity(createModelRequest,brand);
			modelBusinessRules.checkIfModelNameExists(createModelRequest.getName());
			vehicle = vehicleRepository.save(vehicle);


		return ModelToModelResponseMapper.toDto(vehicle);

	}

	/**
	 * ID değeri verilen model'e erişmek için kullanılır.
	 * @param modelId
	 * @return
	 */
	@Override
	public VehicleGetResponse getModelById(
			Integer modelId
	) {
		Vehicle vehicleFromDb = vehicleRepository.findById(modelId)
				.orElseThrow(()->new BusinessException("Verilen id değerine sahip bir model bulunamadı."));

		return null;
	}


	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Vehicle> vehicles = vehicleRepository.findAll();
		
		List<GetAllModelsResponse> modelResponse = vehicles.stream().map(model->this.modelMapperService.forResponse()
				.map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
		return modelResponse;
	}

	@Override
	public VehicleGetResponse updateModelById(Integer modelId) {
		return null;
	}

	@Override
	public boolean deleteModelById(Integer modelId) {
		return false;
	}







	
	
	
}
