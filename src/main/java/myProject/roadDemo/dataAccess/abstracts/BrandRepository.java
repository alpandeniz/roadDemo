package myProject.roadDemo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import myProject.roadDemo.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
	boolean existsByName(String name);
}
