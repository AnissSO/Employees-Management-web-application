package com.stage2A.APIstage2A.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employe")
public class Employe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_employe;
	
	private String email;
	private String password;
	private String prenom;
	private String nom;
	private String numtelephone;
	private LocalDate datenaissance;
	private Integer status;
	private String postenom;
	private LocalDate datedebut;
	private String situationemploi;
}
