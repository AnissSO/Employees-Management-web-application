package com.stage2A.APIstage2A.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "entreprise")
public class Entreprise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_entreprise;
	
	private String nom;
	private String adresse1;
	private String adresse2;
	private String region;
	private String ville;
	private String pays;
	private String codepostal;
	private String telephone;
	private String fax;
	private String description;
}
