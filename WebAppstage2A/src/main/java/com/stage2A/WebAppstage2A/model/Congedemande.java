package com.stage2A.WebAppstage2A.model;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Congedemande {

	private Integer id_congedemande;
	
	private Integer id_employe;
	
	private String congetypecode;
	
	private String congetypenom;
	private Date datedebutconge;
	private String congecommentaire;
}
