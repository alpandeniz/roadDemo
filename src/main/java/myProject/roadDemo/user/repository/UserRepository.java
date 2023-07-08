package myProject.roadDemo.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import myProject.roadDemo.journey.entity.Journey;
import myProject.roadDemo.user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	boolean existsByName(String name);
	//List<Journey> findAllById(int id);
	Optional<List<Journey>> findAllById(Integer id);



}
