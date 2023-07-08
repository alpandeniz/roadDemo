package myProject.roadDemo.user.service;

import java.util.List;

import myProject.roadDemo.user.payload.request.CreateUserRequest;
import myProject.roadDemo.journey.payload.response.GetAllJourneyByUserId;
import myProject.roadDemo.user.entity.User;

public interface UserService {
	User save(CreateUserRequest createUserRequest);

	List<GetAllJourneyByUserId> getAllByUserId(int userId) throws Exception;
}
