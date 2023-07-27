package myProject.roadDemo.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import myProject.roadDemo.vehicle.entity.Vehicle;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {


    boolean existsByName(String name);


}
