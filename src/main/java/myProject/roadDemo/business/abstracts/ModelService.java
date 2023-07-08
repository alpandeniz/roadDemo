package myProject.roadDemo.business.abstracts;

import java.util.List;

import myProject.roadDemo.dto.requests.CreateModelRequest;
import myProject.roadDemo.dto.responses.GetAllModelsResponse;
import myProject.roadDemo.dto.responses.ModelResponse;

public interface ModelService {

	ModelResponse save(CreateModelRequest createModelRequest) throws Exception;

	ModelResponse getModelById(Integer modelId);

	List<GetAllModelsResponse> getAll();

	ModelResponse updateModelById(Integer modelId);

	boolean deleteModelById(Integer modelId);

//s	void calculate(CalculateFuelResponse calculateFuelResponse);
}
