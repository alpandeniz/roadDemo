package myProject.roadDemo.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import myProject.roadDemo.vehicle.entity.Brand;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
	boolean existsByName(String name);
}
