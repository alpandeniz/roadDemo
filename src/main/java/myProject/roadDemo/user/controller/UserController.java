package myProject.roadDemo.user.controller;

import java.util.List;

import javax.validation.Valid;

import myProject.roadDemo.user.entity.User;
import myProject.roadDemo.user.mapper.UserToUserSavedResponseMapper;
import myProject.roadDemo.user.payload.response.UserSavedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import myProject.roadDemo.user.service.UserService;
import myProject.roadDemo.dto.requests.CreateUserRequest;
import myProject.roadDemo.dto.responses.GetAllJourneyByUserId;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

	private UserService userService;
	
	@PostMapping
	public ResponseEntity<UserSavedResponse> add(@RequestBody() @Valid() CreateUserRequest createUserRequest) {
		User user = userService.save(createUserRequest);
		UserSavedResponse response = UserToUserSavedResponseMapper.toDto(user);

		return ResponseEntity.ok(response);
	}
	
	@GetMapping(path="/{id}")
	public List<GetAllJourneyByUserId> getAllById( 
			@PathVariable int id){
		try {
			 return userService.getAllByUserId(id);
		} catch (Exception exception){
			return null;
		}

	}
}