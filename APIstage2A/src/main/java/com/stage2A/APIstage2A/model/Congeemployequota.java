package com.stage2A.APIstage2A.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "congeemployequota")
@IdClass(CongeemployequotaId.class)
public class Congeemployequota implements Serializable{
	
	@Id
	private String congetypecode;
	
	@Id
	private Integer id_employe;
	
	private Integer nbredejoursalloues;
	private Integer nbredejourspris;
	private Integer balance;
}
