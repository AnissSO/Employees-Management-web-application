package com.stage2A.APIstage2A.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stage2A.APIstage2A.model.Congeemployequota;
import com.stage2A.APIstage2A.model.CongeemployequotaId;

@Repository
public interface CongeemployequotaRepository extends CrudRepository<Congeemployequota, CongeemployequotaId>{

}
