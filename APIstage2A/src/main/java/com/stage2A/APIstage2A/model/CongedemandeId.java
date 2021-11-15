package com.stage2A.APIstage2A.model;

import java.io.Serializable;
import java.util.Objects;

public class CongedemandeId implements Serializable{

	private Integer id_congedemande;
	
	private Integer id_employe;
	
	private String congetypecode;
	
	public CongedemandeId() {
		
	}
	
	public CongedemandeId(Integer id_congedemande, Integer id_employe, String congetypecode) {
		this.id_congedemande = id_congedemande;
		this.id_employe = id_employe;
		this.congetypecode = congetypecode;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CongedemandeId accountId = (CongedemandeId) o;
        return id_congedemande.equals(accountId.id_congedemande) &&
        		id_employe.equals(accountId.id_employe) &&
        		congetypecode.equals(accountId.congetypecode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_congedemande, id_employe,congetypecode);
    }
    
}
