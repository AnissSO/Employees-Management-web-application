package com.stage2A.APIstage2A.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stage2A.APIstage2A.model.EntrepriseStructure;

@Repository
public interface EntrepriseStructureRepository extends CrudRepository<EntrepriseStructure, Integer>{

	@Query("select q from EntrepriseStructure q where q.numdeptparent = ?1")
	Iterable<EntrepriseStructure> getDepartements(Integer id);
	
	
}
