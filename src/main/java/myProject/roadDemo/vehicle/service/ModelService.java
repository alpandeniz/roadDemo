package myProject.roadDemo.vehicle.service;

import java.util.List;

import myProject.roadDemo.vehicle.payload.request.CreateModelRequest;
import myProject.roadDemo.vehicle.payload.response.GetAllModelsResponse;
import myProject.roadDemo.vehicle.payload.response.ModelResponse;

public interface ModelService {

	ModelResponse save(CreateModelRequest createModelRequest) throws Exception;

	ModelResponse getModelById(Integer modelId);

	List<GetAllModelsResponse> getAll();

	ModelResponse updateModelById(Integer modelId);

	boolean deleteModelById(Integer modelId);

//s	void calculate(CalculateFuelResponse calculateFuelResponse);
}
