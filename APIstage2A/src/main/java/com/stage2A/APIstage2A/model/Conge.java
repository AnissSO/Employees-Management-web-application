package com.stage2A.APIstage2A.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "conge")
@IdClass(CongeId.class)
public class Conge {
	@Id
	private Integer id_conge;
	@Id
	private Integer id_congedemande;
	@Id
	private Integer id_employe;
	@Id
	private String congetypecode;
	
	private Date congedate;
	private Integer congenbrejours;
	private Integer congestatus;
	private String congecommentaire;

}
