package myProject.roadDemo.journey.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import myProject.roadDemo.journey.entity.Journey;

public interface JourneyRepository  extends JpaRepository<Journey, Integer>{

}
