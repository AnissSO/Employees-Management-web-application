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
@Table(name = "candidat")
public class Candidat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
