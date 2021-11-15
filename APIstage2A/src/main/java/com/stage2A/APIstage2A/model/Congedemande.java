package com.stage2A.APIstage2A.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "congedemande")
@IdClass(CongedemandeId.class)
public class Congedemande implements Serializable{
	@Id
	private Integer id_congedemande;
	
	@Id
	private Integer id_employe;
	@Id
	private String congetypecode;
	
	private String congetypenom;
	private Date datedebutconge;
	private String congecommentaire;

}
