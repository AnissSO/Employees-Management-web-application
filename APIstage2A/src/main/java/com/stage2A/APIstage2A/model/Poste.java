package com.stage2A.APIstage2A.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "poste")
public class Poste {
	@Id
	private String postecode;
	
	private String postenom;
	private String postedescription;
	private Integer estactif;

}
