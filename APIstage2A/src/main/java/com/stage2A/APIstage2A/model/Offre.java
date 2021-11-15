package com.stage2A.APIstage2A.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "offre")
public class Offre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_offre;
	
	private String nompostevacant;
	private String descriptionpostevacant;
	private Integer status;
	private LocalDate datedecreation;
	private String postecode;

}
