package myProject.roadDemo.user.controller;

import java.util.List;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
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
import org.springframework.web.bind.annotation.RestController;

import myProject.roadDemo.user.service.UserService;
import myProject.roadDemo.user.payload.request.CreateUserRequest;
import myProject.roadDemo.journey.payload.response.GetAllJourneyByUserId;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {

	private final UserService userService;

	@PostMapping //createUser
	public ResponseEntity<?> add(
			@RequestBody
			@Valid
			CreateUserRequest createUserRequest
	) {
		try {
			return ResponseEntity.ok(userService.save(createUserRequest));
		} catch (Exception exception){
			return  new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping(path="/{id}")
	public List<GetAllJourneyByUserId> getAllById( 
			@PathVariable int id
	){
		try {
			 return userService.getAllByUserId(id);
		} catch (Exception exception){
			return null;
		}

	}
}
