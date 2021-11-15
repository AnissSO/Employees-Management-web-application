package com.stage2A.APIstage2A.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "entreprisestructure")
public class EntrepriseStructure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numdepartement;
	
	private String nomdepartement;
	private String description;
	private Integer numdeptparent;

}
