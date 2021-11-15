package com.stage2A.APIstage2A.model;

import java.io.Serializable;
import java.util.Objects;

public class CongeemployequotaId implements Serializable{
	
	private String congetypecode;
	private Integer id_employe;
	
	public CongeemployequotaId() {
		
	}
	
	public CongeemployequotaId(String congetypecode, Integer id_employe) {
		this.congetypecode = congetypecode;
		this.id_employe = id_employe;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CongeemployequotaId accountId = (CongeemployequotaId) o;
        return congetypecode.equals(accountId.congetypecode) &&
        		id_employe.equals(accountId.id_employe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(congetypecode, id_employe);
    }
	
}
