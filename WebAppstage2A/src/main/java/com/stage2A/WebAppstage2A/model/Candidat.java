package com.stage2A.WebAppstage2A.model;

import java.sql.Date;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Candidat {
	
	private Integer id_candidat;
	
	private String nom;
	private String prenom;
	private String email;
	private String numtelephone;
	private String commentaire;
	private LocalDate datedepostulation;
	private byte[] cv;
	private String password;
	private Integer status;
	

}
