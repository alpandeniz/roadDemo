package myProject.roadDemo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import myProject.roadDemo.entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {


    boolean existsByName(String name);


}
