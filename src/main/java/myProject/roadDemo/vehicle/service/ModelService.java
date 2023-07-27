package myProject.roadDemo.vehicle.service;

import java.util.List;

import myProject.roadDemo.vehicle.payload.request.CreateModelRequest;
import myProject.roadDemo.vehicle.payload.response.GetAllModelsResponse;
import myProject.roadDemo.vehicle.payload.response.VehicleGetResponse;

public interface ModelService {

	VehicleGetResponse save(CreateModelRequest createModelRequest) throws Exception;

	VehicleGetResponse getModelById(Integer modelId);

	List<GetAllModelsResponse> getAll();

	VehicleGetResponse updateModelById(Integer modelId);

	boolean deleteModelById(Integer modelId);

//s	void calculate(CalculateFuelResponse calculateFuelResponse);
}
