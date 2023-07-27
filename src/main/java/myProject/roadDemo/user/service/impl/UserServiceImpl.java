package myProject.roadDemo.user.service.impl;

import java.util.List;

import lombok.RequiredArgsConstructor;
import myProject.roadDemo.core.mapper.user.request.UserSaveRequestToMapper;
import myProject.roadDemo.core.mapper.user.response.UserToUserResponseMapper;
import myProject.roadDemo.core.rules.UserBusinessRules;
import myProject.roadDemo.journey.repo.JourneyRepository;
import myProject.roadDemo.user.mapper.UserToUserSavedResponseMapper;
import myProject.roadDemo.user.payload.response.UserResponse;
import myProject.roadDemo.user.payload.response.UserSavedResponse;
import myProject.roadDemo.vehicle.entity.Vehicle;
import myProject.roadDemo.vehicle.repository.VehicleRepository;
import myProject.roadDemo.journey.mapper.JourneyMapper;
import org.springframework.stereotype.Service;

import myProject.roadDemo.user.service.UserService;
import myProject.roadDemo.core.mappers.ModelMapperService;
import myProject.roadDemo.user.repository.UserRepository;
import myProject.roadDemo.user.payload.request.CreateUserRequest;
import myProject.roadDemo.journey.payload.response.GetAllJourneyByUserId;
import myProject.roadDemo.journey.entity.Journey;
import myProject.roadDemo.user.entity.User;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ModelMapperService modelMapperService;
    private final UserRepository userRepository;
    private final JourneyMapper journeyMapper;
    private final UserBusinessRules userBusinessRules;
    private final VehicleRepository vehicleRepository;
    private final JourneyRepository journeyRepository;


    @Override
    public UserSavedResponse save(
            CreateUserRequest createUserRequest
    ) throws Exception {

        User user = UserSaveRequestToMapper.toEntity(createUserRequest);
        userBusinessRules.checkIfUserNameExists(createUserRequest.getName());
        user = userRepository.save(user);

        Journey journey = journeyRepository.findById(createUserRequest.getJourneyId())
				.orElseThrow(() -> new RuntimeException("böyle bir journey yok."));

        Vehicle vehicle = vehicleRepository.findById(createUserRequest.getModelId())
				.orElseThrow(() -> new RuntimeException("böyle bir model yok"));


        journey.setUser(user);
        vehicle.setUser(user);
        vehicleRepository.save(vehicle);
        journeyRepository.save(journey);




        return UserToUserSavedResponseMapper.toDto(user,vehicle,journey);
    }


		/*
		Model model = modelRepository.findById(createUserRequest.getModelId())
				.orElseThrow(()-> new Exception("Böyle bir model yok."));
		Journey journey = journeyRepository.findById(createUserRequest.getJourneyId())
				.orElseThrow(()->new Exception("Böyle bir yolculuk yok."));

		//User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);
		userBusinessRules.checkIfUserNameExists(createUserRequest.getName());
		userRepository.save(user);
		 */


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
                .orElseThrow(() -> new Exception("Belirtilen id değerine sahip bir kullanıcı bulunamadı."));

        List<Journey> journeyList = user.getJourneys();

        System.out.println(journeyList.toString());

		/*
		List<GetAllJourneyByUserId> response = journeyList.stream().map(journey->this.modelMapperService.forResponse()
				.map(journeyList, GetAllJourneyByUserId.class)).collect(Collectors.toList());

		 */

        return journeyMapper.toDtoList(journeyList);
    }

}
