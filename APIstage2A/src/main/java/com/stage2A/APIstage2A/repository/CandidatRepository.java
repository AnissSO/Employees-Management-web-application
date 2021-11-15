package com.stage2A.APIstage2A.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stage2A.APIstage2A.model.Candidat;
import com.stage2A.APIstage2A.model.Employe;
import com.stage2A.APIstage2A.model.EntrepriseStructure;

@Repository
public interface CandidatRepository extends CrudRepository<Candidat, Integer>{

	@Query("select q from Candidat q where q.status = ?1")
	Iterable<Candidat> getCandidatsOffre(Integer id);
	
	@Query("select q from Candidat q where q.email = ?1")
	Optional<Candidat> findCandidatByEmail(String emailUser);
}
