package com.stage2A.WebAppstage2A.model;

import lombok.Data;

@Data
public class EntrepriseStructure {

	private Integer numdepartement;
	
	private String nomdepartement;
	private String description;
	private Integer numdeptparent;
}
