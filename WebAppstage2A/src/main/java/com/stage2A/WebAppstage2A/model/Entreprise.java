package com.stage2A.WebAppstage2A.model;

import lombok.Data;

@Data
public class Entreprise {
	
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
