package myProject.roadDemo.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import myProject.roadDemo.business.rules.ModelBusinessRules;
import myProject.roadDemo.core.utilities.exceptions.BusinessException;
import myProject.roadDemo.dataAccess.abstracts.BrandRepository;
import myProject.roadDemo.dto.responses.ModelResponse;
import myProject.roadDemo.entities.concretes.Brand;
import myProject.roadDemo.mapper.model.request.ModelSaveRequestToModelMapper;
import myProject.roadDemo.mapper.model.response.ModelToModelResponseMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import myProject.roadDemo.business.abstracts.ModelService;
import myProject.roadDemo.core.utilities.mappers.ModelMapperService;
import myProject.roadDemo.dataAccess.abstracts.ModelRepository;
import myProject.roadDemo.dto.requests.CreateModelRequest;
import myProject.roadDemo.dto.responses.GetAllModelsResponse;
import myProject.roadDemo.entities.concretes.Model;

@Service
@RequiredArgsConstructor
public class ModelManager implements ModelService {

	private final ModelMapperService modelMapperService;
	private final ModelRepository modelRepository;
	private final ModelBusinessRules modelBusinessRules;
	private final BrandRepository brandRepository;


	
	@Override
	public ModelResponse save(CreateModelRequest createModelRequest) throws Exception {


			Brand brand = brandRepository.findById(createModelRequest.getBrandId())
					.orElseThrow(()->new Exception("Böyle bir brand yok."));

			Model model = ModelSaveRequestToModelMapper.toEntity(createModelRequest,brand);
			modelBusinessRules.checkIfModelNameExists(createModelRequest.getName());
			model = modelRepository.save(model);


		return ModelToModelResponseMapper.toDto(model);

	}

	/**
	 * ID değeri verilen model'e erişmek için kullanılır.
	 * @param modelId
	 * @return
	 */
	@Override
	public ModelResponse getModelById(
			Integer modelId
	) {
		Model modelFromDb = modelRepository.findById(modelId)
				.orElseThrow(()->new BusinessException("Verilen id değerine sahip bir model bulunamadı."));

		return null;
	}


	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = modelRepository.findAll();
		
		List<GetAllModelsResponse> modelResponse = models.stream().map(model->this.modelMapperService.forResponse()
				.map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
		return modelResponse;
	}

	@Override
	public ModelResponse updateModelById(Integer modelId) {
		return null;
	}

	@Override
	public boolean deleteModelById(Integer modelId) {
		return false;
	}







	
	
	
}
