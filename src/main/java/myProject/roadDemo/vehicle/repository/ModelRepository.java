package myProject.roadDemo.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import myProject.roadDemo.vehicle.entity.Vehicle;

public interface ModelRepository extends JpaRepository<Vehicle, Integer> {


    boolean existsByName(String name);


}
