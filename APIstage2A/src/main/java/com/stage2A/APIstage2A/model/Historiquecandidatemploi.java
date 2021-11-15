package com.stage2A.APIstage2A.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "historiquecandidatemploi")
public class Historiquecandidatemploi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_hist_cand_emp;
	
	private Integer id_offre;
	private Integer id_candidat;
	private String nomoffre;
	private Integer action;
	private LocalDate dateaction;
	private String note;
	private Integer entretien;

}
