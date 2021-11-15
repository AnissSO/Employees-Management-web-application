package com.stage2A.WebAppstage2A.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stage2A.WebAppstage2A.CustomProperties;
import com.stage2A.WebAppstage2A.model.Candidat;
import com.stage2A.WebAppstage2A.model.Conge;
import com.stage2A.WebAppstage2A.model.Congedemande;
import com.stage2A.WebAppstage2A.model.Congeemployequota;
import com.stage2A.WebAppstage2A.model.Congetype;
import com.stage2A.WebAppstage2A.model.Employe;
import com.stage2A.WebAppstage2A.model.Entreprise;
import com.stage2A.WebAppstage2A.model.EntrepriseStructure;
import com.stage2A.WebAppstage2A.model.Historiquecandidatemploi;
import com.stage2A.WebAppstage2A.model.Offre;
import com.stage2A.WebAppstage2A.model.Poste;
import com.stage2A.WebAppstage2A.model.Projet;
import com.stage2A.WebAppstage2A.repository.EntrepriseProxy;

import lombok.Data;


@Data
@Service
public class EntrepriseService {

	@Autowired
	private EntrepriseProxy entrepriseProxy;
	
	public Entreprise getEntreprise(final Integer id) {
		return entrepriseProxy.getEntreprise(id);
	}
	
	public Entreprise saveEntreprise(Entreprise entreprise) {
		Entreprise savedEntreprise;
		savedEntreprise = entrepriseProxy.updateEntreprise(entreprise);
		
		
		return savedEntreprise;
	}
	
	public EntrepriseStructure getDepartement(final Integer id) {
		return entrepriseProxy.getDepartement(id);
	}
	
	public Iterable<EntrepriseStructure> getDepartements(final Integer id) {
		return entrepriseProxy.getDepartements(id);
	}
	
	public EntrepriseStructure saveDepartement(EntrepriseStructure es) {
		EntrepriseStructure savedes;
		
		savedes = entrepriseProxy.createDepartement(es);
		
		return savedes;
	}
	
	public void deleteDepartement(final Integer id) {
		entrepriseProxy.deleteDepartement(id);
	}
	
	public Iterable<Poste> getPostes() {
		return entrepriseProxy.getPostes();
	}
	
	public Poste savePoste(Poste poste) {
		Poste savedPoste;

		savedPoste = entrepriseProxy.createPoste(poste);
		
		
		return savedPoste;
	}

	public void deletePoste(final String id) {
		entrepriseProxy.deletePoste(id);
	}
	
	public Employe getEmploye(final Integer id) {
		return entrepriseProxy.getEmploye(id);
	}
	
	public Iterable<Employe> getEmployes() {
		return entrepriseProxy.getEmployes();
	}
	
	public void deleteEmploye(final Integer id) {
		entrepriseProxy.deleteEmploye(id);
	}
	
	public Employe saveEmploye(Employe employee) {
		Employe savedEmployee;
		

		if(employee.getId_employe() == null) {
			// If id is null, then it is a new employee.
			System.out.println("THIS ONE");
			savedEmployee = entrepriseProxy.createEmployee(employee);
		} else {
			savedEmployee = entrepriseProxy.updateEmployee(employee);
		}
		
		return savedEmployee;
	}
	
	public Iterable<Projet> getProjets() {
		return entrepriseProxy.getProjets();
	}
	
	public void deleteProjet(final Integer id) {
		entrepriseProxy.deleteProjet(id);
	}
	
	public Projet saveProjet(Projet p) {
		Projet savedProjet;
		
		
		savedProjet = entrepriseProxy.createProjet(p);
		
		return savedProjet;
	}
	
	public Congetype getConge(final String id) {
		return entrepriseProxy.getConge(id);
	}
	
	public Iterable<Congetype> getConges() {
		return entrepriseProxy.getConges();
	}
	
	public Congetype saveConge(Congetype employee) {
		Congetype savedEmployee;
		
		
		savedEmployee = entrepriseProxy.updateConge(employee);
		
		
		return savedEmployee;
	}
	
	public Congeemployequota saveCongeemployequota(Congeemployequota ceq) {
		Congeemployequota savedceq;
		

		//if(employee.getId() == null) {
			// If id is null, then it is a new employee.
		savedceq = entrepriseProxy.saveCongeemployequota(ceq);
		/*} else {
			savedEmployee = employeeProxy.updateEmployee(employee);
		}*/
		
		return savedceq;
	}
	public Congeemployequota updateCongeemployequota(Congeemployequota ceq) {
		Congeemployequota savedceq;
		

		//if(employee.getId() == null) {
			// If id is null, then it is a new employee.
		savedceq = entrepriseProxy.updateCongeemployequota(ceq);
		/*} else {
			savedEmployee = employeeProxy.updateEmployee(employee);
		}*/
		
		return savedceq;
	}
	public Employe findEmployeByEmail(String emailEmploye){
		return entrepriseProxy.findEmployeByEmail(emailEmploye);
	}
	
	public Candidat findCandidatByEmail(String emailEmploye){
		return entrepriseProxy.findCandidatByEmail(emailEmploye);
	}
	
	public Congeemployequota getCongeemployequota(final Integer idEmploye) {
		return entrepriseProxy.getCongeemployequota(idEmploye);
	}
	public Congedemande saveCongedemande(Congedemande congedemande) {
		Congedemande savedCongedemande;
		
		savedCongedemande = entrepriseProxy.createCongedemande(congedemande);
		
		return savedCongedemande;
	}
	
	public Conge saveConge(Conge employee) {
		Conge savedEmployee;
		

		if(employee.getId_conge() == null) {
			// If id is null, then it is a new employee.
			Random r = new Random();
			int low = 1;
			int high = 1000;
			int result = r.nextInt(high-low) + low;
			employee.setId_conge(result);
			System.out.println(employee);
			savedEmployee = entrepriseProxy.createConge(employee);
			System.out.println(savedEmployee);
		} else {
			savedEmployee = entrepriseProxy.updateConge(employee);
		}
		
		return savedEmployee;
	}
	
	public Conge getConge(final Integer id) {
		return entrepriseProxy.getConge(id);
	}
	
	public Iterable<Conge> getListConges() {
		return entrepriseProxy.getListConges();
	}
	
	public Iterable<Congedemande> getCongedemande(final Integer id) {
		return entrepriseProxy.getCongedemande(id);
	}
	
	public Conge getCongeForcongedemande(final Integer id) {
		return entrepriseProxy.getCongeForcongedemande(id);
	}
	
	public Iterable<Congedemande> getCongedemandes(){
		return entrepriseProxy.getCongedemandes();
	}
	
	public Offre getOffre(final Integer id) {
		return entrepriseProxy.getOffre(id);
	}
	
	public Iterable<Offre> getOffres() {
		return entrepriseProxy.getOffres();
	}
	
	public void deleteOffre(final Integer id) {
		entrepriseProxy.deleteOffre(id);
	}
	
	public Offre saveOffre(Offre employee) {
		Offre savedEmployee;
		
		
		if(employee.getId_offre() == null) {
			// If id is null, then it is a new employee.
			savedEmployee = entrepriseProxy.createOffre(employee);
		} else {
			savedEmployee = entrepriseProxy.updateOffre(employee);
		}
		
		return savedEmployee;
	}
	public Candidat saveCandidat(Candidat employee) {
		Candidat savedEmployee;
		
		if(employee.getId_candidat() == null) {
			// If id is null, then it is a new employee.
			savedEmployee = entrepriseProxy.createCandidat(employee);
		} else {
			savedEmployee = entrepriseProxy.updateCandidat(employee);
		}
		
		return savedEmployee;
	}
	public Historiquecandidatemploi saveHistoriquecandidatemploi(Historiquecandidatemploi employee) {
		Historiquecandidatemploi savedEmployee;
		
		
		//if(employee.getId_hist_cand_emp() == null) {
			// If id is null, then it is a new employee.
			savedEmployee = entrepriseProxy.createHistoriquecandidatemploi(employee);
		/*} else {
			savedEmployee = employeeProxy.updateEmployee(employee);
		}*/
		
		return savedEmployee;
	}
	
	public Iterable<Candidat> getCandidatsOffre(final Integer id) {
		return entrepriseProxy.getCandidatsOffre(id);
	}
	
	public Candidat getCandidat(final int id) {
		return entrepriseProxy.getCandidat(id);
	}
	public Iterable<Historiquecandidatemploi> getHistoriquecandidatemploiOffreCandidat(final int id) {
		return entrepriseProxy.getHistoriquecandidatemploiOffreCandidat(id);
	}
	
}
