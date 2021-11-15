package com.stage2A.WebAppstage2A.model;

import java.sql.Date;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Conge {
	
	private Integer id_conge;
	
	private Integer id_congedemande;
	
	private Integer id_employe;
	
	private String congetypecode;
	private Date congedate;
	private Integer congenbrejours;
	private Integer congestatus;
	private String congecommentaire;

}
