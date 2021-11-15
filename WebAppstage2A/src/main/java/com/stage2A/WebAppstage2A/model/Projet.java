package com.stage2A.WebAppstage2A.model;

import lombok.Data;

@Data
public class Projet {
	
	private Integer id_projet;
	
	private String nomprojet;
	private String descriptionprojet;
	private String nomclient;
	private Integer etat;

}
