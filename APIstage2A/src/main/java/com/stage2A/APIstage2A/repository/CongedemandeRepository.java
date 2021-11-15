package com.stage2A.APIstage2A.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stage2A.APIstage2A.model.Congedemande;
import com.stage2A.APIstage2A.model.CongedemandeId;
import com.stage2A.APIstage2A.model.EntrepriseStructure;

@Repository
public interface CongedemandeRepository extends CrudRepository<Congedemande, CongedemandeId>{

	@Query("select q from Congedemande q where q.id_employe = ?1")
	Iterable<Congedemande> getCongedemande(Integer id);
}
