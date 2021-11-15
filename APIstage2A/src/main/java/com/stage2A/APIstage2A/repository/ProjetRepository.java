package com.stage2A.APIstage2A.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stage2A.APIstage2A.model.Projet;

@Repository
public interface ProjetRepository extends CrudRepository<Projet, Integer>{

}
