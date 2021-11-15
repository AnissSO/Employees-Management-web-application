package com.stage2A.APIstage2A.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stage2A.APIstage2A.model.Employe;

@Repository
public interface EmployeRepository extends CrudRepository<Employe, Integer>{
	
	@Query("select q from Employe q where q.email = ?1")
	Optional<Employe> findUserByEmail(String emailUser);

}
