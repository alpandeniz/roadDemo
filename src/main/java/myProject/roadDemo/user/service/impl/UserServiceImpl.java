package myProject.roadDemo.user.service.impl;

import java.util.List;

import lombok.RequiredArgsConstructor;
import myProject.roadDemo.business.rules.UserBusinessRules;
import myProject.roadDemo.journey.repo.JourneyRepository;
import myProject.roadDemo.dataAccess.abstracts.ModelRepository;
import myProject.roadDemo.entities.concretes.journeyMapper.JourneyMapper;
import org.springframework.stereotype.Service;

import myProject.roadDemo.user.service.UserService;
import myProject.roadDemo.core.utilities.mappers.ModelMapperService;
import myProject.roadDemo.user.repo.UserRepository;
import myProject.roadDemo.dto.requests.CreateUserRequest;
import myProject.roadDemo.dto.responses.GetAllJourneyByUserId;
import myProject.roadDemo.journey.entity.Journey;
import myProject.roadDemo.user.entity.User;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	private final ModelMapperService modelMapperService;
	private final UserRepository userRepository;
	private final JourneyMapper journeyMapper;
	private final UserBusinessRules userBusinessRules;
	private final ModelRepository modelRepository;
	private  final JourneyRepository journeyRepository;


	@Override
	public User save(
			CreateUserRequest createUserRequest
	){

		User user = new User();
		user.setName(createUserRequest.getName());

		/*
		if(createUserRequest.getJourneyId() != null){
			Journey journey = journeyRepository.findById(createUserRequest.getJourneyId())
					.orElseThrow(()->new RuntimeException("Journey not found by the given id: "+
							createUserRequest.getJourneyId()));
			user.addJourney(journey);
		}

		if(createUserRequest.getModelId() != null){
			// TODO : İlgili modeli bulmayı dene ve atama yap.
		}
		 */

		return userRepository.save(user);


		/*
		Model model = modelRepository.findById(createUserRequest.getModelId())
				.orElseThrow(()-> new Exception("Böyle bir model yok."));
		Journey journey = journeyRepository.findById(createUserRequest.getJourneyId())
				.orElseThrow(()->new Exception("Böyle bir yolculuk yok."));

		//User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);
		userBusinessRules.checkIfUserNameExists(createUserRequest.getName());
		userRepository.save(user);
		 */
		
	}

	/**
	 * ID üzerinden erişilen user'e ait journeylerin tamamını geriye döndürür.
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<GetAllJourneyByUserId> getAllByUserId(
			int id
	) throws Exception {
		// Try Catch (Exception Handling)
		// Static Kullanımı.
		// ToString metodunun ezilmesi.
		// Equals Hash vb metodların ezilmesi, custom yazılması.

		User user = userRepository.findById(id)
				.orElseThrow(()->new Exception("Belirtilen id değerine sahip bir kullanıcı bulunamadı."));

		List<Journey> journeyList = user.getJourneys();

		System.out.println(journeyList.toString());

		/*
		List<GetAllJourneyByUserId> response = journeyList.stream().map(journey->this.modelMapperService.forResponse()
				.map(journeyList, GetAllJourneyByUserId.class)).collect(Collectors.toList());

		 */

		return journeyMapper.toDtoList(journeyList);
	}
	
}
