package com.stage2A.WebAppstage2A.model;

import java.sql.Date;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Offre {
	
	private Integer id_offre;
	
	private String nompostevacant;
	private String descriptionpostevacant;
	private Integer status;
	private LocalDate datedecreation;
	private String postecode;
}
