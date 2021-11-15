package com.stage2A.APIstage2A.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stage2A.APIstage2A.model.Conge;
import com.stage2A.APIstage2A.model.CongeId;
import com.stage2A.APIstage2A.model.EntrepriseStructure;

@Repository
public interface CongeRepository extends CrudRepository<Conge, CongeId>{

	@Query("select q from Conge q where q.id_conge = ?1")
	Optional<Conge> getConge(Integer id);
	
	@Query("select q from Conge q where q.id_congedemande = ?1")
	Optional<Conge> getCongeForcongedemande(Integer id);
}
