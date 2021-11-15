package com.stage2A.WebAppstage2A.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Historiquecandidatemploi {
	
	private Integer id_hist_cand_emp;
	
	private Integer id_offre;
	private Integer id_candidat;
	private String nomoffre;
	private Integer action;
	private LocalDate dateaction;
	private String note;
	private Integer entretien;

}
