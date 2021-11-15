package com.stage2A.APIstage2A.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "projet")
public class Projet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_projet;
	
	private String nomprojet;
	private String descriptionprojet;
	private String nomclient;
	private Integer etat;

}
