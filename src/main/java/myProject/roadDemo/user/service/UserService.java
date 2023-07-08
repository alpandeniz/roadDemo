package myProject.roadDemo.user.service;

import java.util.List;

import myProject.roadDemo.dto.requests.CreateUserRequest;
import myProject.roadDemo.dto.responses.GetAllJourneyByUserId;
import myProject.roadDemo.user.entity.User;

public interface UserService {
	User save(CreateUserRequest createUserRequest);

	List<GetAllJourneyByUserId> getAllByUserId(int userId) throws Exception;
}
