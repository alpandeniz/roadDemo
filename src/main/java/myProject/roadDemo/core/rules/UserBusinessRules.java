package myProject.roadDemo.core.rules;

import lombok.RequiredArgsConstructor;
import myProject.roadDemo.core.exceptions.BusinessException;
import myProject.roadDemo.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserBusinessRules {
	private final UserRepository userRepository;
	public void checkIfUserNameExists(String name)
			throws BusinessException
	{
		if(this.userRepository.existsByName(name)) {
			throw new BusinessException("User name already exists!");
		}
	}
}
