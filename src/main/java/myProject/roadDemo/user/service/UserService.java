package myProject.roadDemo.user.service;

import java.util.List;

import myProject.roadDemo.user.payload.request.CreateUserRequest;
import myProject.roadDemo.journey.payload.response.GetAllJourneyByUserId;
import myProject.roadDemo.user.entity.User;
import myProject.roadDemo.user.payload.response.UserResponse;
import myProject.roadDemo.user.payload.response.UserSavedResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	UserSavedResponse save(CreateUserRequest createUserRequest) throws Exception;

	List<GetAllJourneyByUserId> getAllByUserId(int userId) throws Exception;
}
