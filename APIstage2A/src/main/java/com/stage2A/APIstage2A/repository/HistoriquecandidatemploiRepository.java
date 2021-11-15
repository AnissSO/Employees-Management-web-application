package com.stage2A.APIstage2A.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stage2A.APIstage2A.model.EntrepriseStructure;
import com.stage2A.APIstage2A.model.Historiquecandidatemploi;

@Repository
public interface HistoriquecandidatemploiRepository extends CrudRepository<Historiquecandidatemploi, Integer>{

	@Query("select q from Historiquecandidatemploi q where q.id_candidat = ?1")
	Iterable<Historiquecandidatemploi> getHistoriquecandidatemploiOffreCandidat(final Integer id);
	
}
