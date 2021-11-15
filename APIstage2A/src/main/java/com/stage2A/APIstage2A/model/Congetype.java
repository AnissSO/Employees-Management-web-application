package com.stage2A.APIstage2A.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "congetype")
public class Congetype {
	
	@Id
	private String congetypecode;
	
	private String congetypenom;
	private Integer nombrejours;
	private Integer nombreheures;
	private Integer nbresemavaccouchement;
	private Integer nbresemapresaccouchement;
	private String congetypedescription;

}
