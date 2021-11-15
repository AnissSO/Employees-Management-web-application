package com.stage2A.WebAppstage2A.model;

import java.time.LocalDate;
import java.util.Date;

import lombok.Data;

@Data
public class Employe {

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
