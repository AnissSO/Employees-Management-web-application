package com.stage2A.APIstage2A.model;

import java.io.Serializable;
import java.util.Objects;

public class CongeId implements Serializable{
	
	private Integer id_conge;
	
	private Integer id_congedemande;
	
	private Integer id_employe;
	private String congetypecode;
	
	public CongeId() {
		
	}
	
	public CongeId(Integer id_conge, Integer id_congedemande, Integer id_employe, String congetypecode) {
		this.id_conge = id_conge;
		this.id_congedemande = id_congedemande;
		this.id_employe = id_employe;
		this.congetypecode = congetypecode;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CongeId accountId = (CongeId) o;
        return id_conge.equals(accountId.id_conge) &&
        		id_congedemande.equals(accountId.id_congedemande) &&
        		id_employe.equals(accountId.id_employe) &&
        		congetypecode.equals(accountId.congetypecode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_conge, id_congedemande,id_employe, congetypecode);
    }
    

}
