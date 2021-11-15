package com.stage2A.APIstage2A.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stage2A.APIstage2A.model.Candidat;
import com.stage2A.APIstage2A.model.Conge;
import com.stage2A.APIstage2A.model.Congedemande;
import com.stage2A.APIstage2A.model.Congeemployequota;
import com.stage2A.APIstage2A.model.Congetype;
import com.stage2A.APIstage2A.model.Employe;
import com.stage2A.APIstage2A.model.Entreprise;
import com.stage2A.APIstage2A.model.EntrepriseStructure;
import com.stage2A.APIstage2A.model.Historiquecandidatemploi;
import com.stage2A.APIstage2A.model.Offre;
import com.stage2A.APIstage2A.model.Poste;
import com.stage2A.APIstage2A.model.Projet;
import com.stage2A.APIstage2A.service.EntrepriseService;

@RestController
public class EntrepriseController {

	@Autowired
	private EntrepriseService entrepriseService;
	
	
	@GetMapping("/entreprise/{id}")
	public Entreprise getEntreprise(@PathVariable("id") final Integer id) {
		Optional<Entreprise> entreprise = entrepriseService.getEntreprise(id);
		if(entreprise.isPresent()) {
			return entreprise.get();
		} else {
			return null;
		}
	}
	
	@PutMapping("/entreprise/{id}")
	public Entreprise updateEntreprise(@PathVariable("id") final Integer id, @RequestBody Entreprise entreprise) {
		Optional<Entreprise> e = entrepriseService.getEntreprise(id);
		if(e.isPresent()) {
			Entreprise currentEntreprise = e.get();
			
			String nomEntreprise = entreprise.getNom();
			if(nomEntreprise != null) {
				currentEntreprise.setNom(nomEntreprise);
			}
			
			String adresse1 = entreprise.getAdresse1();
			if(adresse1 != null) {
				currentEntreprise.setAdresse1(adresse1);
			}
			String adresse2 = entreprise.getAdresse2();
			if(adresse2 != null) {
				currentEntreprise.setAdresse2(adresse2);
			}
			String region = entreprise.getRegion();
			if(region != null) {
				currentEntreprise.setRegion(region);
			}
			String ville = entreprise.getVille();
			if(ville != null) {
				currentEntreprise.setVille(ville);
			}
			String pays = entreprise.getPays();
			if(pays != null) {
				currentEntreprise.setPays(pays);
			}
			String codepostal = entreprise.getCodepostal();
			if(codepostal != null) {
				currentEntreprise.setCodepostal(codepostal);
			}
			String tel = entreprise.getTelephone();
			if(tel != null) {
				currentEntreprise.setTelephone(tel);
			}
			String fax = entreprise.getFax();
			if(fax != null) {
				currentEntreprise.setFax(fax);
			}
			String description = entreprise.getDescription();
			if(description != null) {
				currentEntreprise.setDescription(description);
			}
			entrepriseService.saveEntreprise(currentEntreprise);
			return currentEntreprise;
		} else {
			return null;
		}
	}
	
	@GetMapping("/departement/{id}")
	public EntrepriseStructure getDepartement(@PathVariable("id") final Integer id) {
		Optional<EntrepriseStructure> departement = entrepriseService.getDepartement(id);
		if(departement.isPresent()) {
			return departement.get();
		} else {
			return null;
		}
	}
	
	@GetMapping("/departements/{id}")
	public Iterable<EntrepriseStructure> getDepartements(@PathVariable("id") final Integer id) {
		return entrepriseService.getDepartements(id);
	}
	
	@PostMapping("/createDepartement")
	public EntrepriseStructure createDepartement(@RequestBody EntrepriseStructure es) {
		return entrepriseService.saveDepartement(es);
	}
	
	
	@DeleteMapping("/departement/{id}")
	public void deleteDepartement(@PathVariable("id") final Integer id) {
		entrepriseService.deleteDepartement(id);
	}
	
	
	@GetMapping("/postes")
	public Iterable<Poste> getPostes() {
		return entrepriseService.getPostes();
	}
	
	@PostMapping("/poste")
	public Poste createPoste(@RequestBody Poste p) {
		return entrepriseService.savePoste(p);
	}
	
	
	@DeleteMapping("/poste/{id}")
	public void deletePoste(@PathVariable("id") final String id) {
		entrepriseService.deletePoste(id);
	}
	
	@GetMapping("/employe/{id}")
	public Employe getEmploye(@PathVariable("id") final Integer id) {
		Optional<Employe> employee = entrepriseService.getEmploye(id);
		if(employee.isPresent()) {
			return employee.get();
		} else {
			return null;
		}
	}
	
	@GetMapping("/employes")
	public Iterable<Employe> getEmployes() {
		return entrepriseService.getEmployes();
	}
	
	@DeleteMapping("/employe/{id}")
	public void deleteEmploye(@PathVariable("id") final Integer id) {
		entrepriseService.deleteEmploye(id);
	}
	
	@PostMapping("/employer")
	public Employe createEmployee(@RequestBody Employe employee) {
		System.out.println("Voilà l'employé" + employee);
		return entrepriseService.saveEmployee(employee);
	}
	
	@PutMapping("/employe/{id}")
	public Employe updateEmployee(@PathVariable("id") final Integer id, @RequestBody Employe employee) {
		Optional<Employe> e = entrepriseService.getEmploye(id);
		if(e.isPresent()) {
			Employe currentEmployee = e.get();
			
			String prenom = employee.getPrenom();
			if(prenom != null) {
				currentEmployee.setPrenom(prenom);
			}
			
			String nom = employee.getNom();
			if(nom != null) {
				currentEmployee.setNom(nom);
			}
			
			String numtel = employee.getNumtelephone();
			if(numtel != null) {
				currentEmployee.setNumtelephone(numtel);
			}
			
			
			Integer status = employee.getStatus();
			if(status != null) {
				currentEmployee.setStatus(status);
			}
			
			String postenom = employee.getPostenom();
			if(postenom != null) {
				currentEmployee.setPostenom(postenom);
			}
			
			LocalDate datedebut = employee.getDatedebut();
			if(datedebut != null) {
				currentEmployee.setDatedebut(datedebut);
			}
			
			String sitEmploi = employee.getSituationemploi();
			if(sitEmploi != null) {
				currentEmployee.setSituationemploi(sitEmploi);
			}
			
			String email = employee.getEmail();
			if(email != null) {
				currentEmployee.setEmail(email);
			}
			
			String pass = employee.getPassword();
			if(pass != null) {
				currentEmployee.setPassword(pass);
			}
			
			entrepriseService.saveEmployee(currentEmployee);
			return currentEmployee;
		} else {
			return null;
		}
	}
	
	@GetMapping("/projets")
	public Iterable<Projet> getProjets() {
		return entrepriseService.getProjets();
	}
	
	@DeleteMapping("/projet/{id}")
	public void deleteProjet(@PathVariable("id") final Integer id) {
		entrepriseService.deleteProjet(id);
	}
	
	@PostMapping("/projet")
	public Projet createProjet(@RequestBody Projet employee) {
		return entrepriseService.saveProjet(employee);
	}

	@GetMapping("/congetype/{id}")
	public Congetype getConge(@PathVariable("id") final String id) {
		Optional<Congetype> employee = entrepriseService.getConge(id);
		if(employee.isPresent()) {
			return employee.get();
		} else {
			return null;
		}
	}
	
	@GetMapping("/congetypes")
	public Iterable<Congetype> getConges() {
		return entrepriseService.getConges();
	}
	
	@PutMapping("/congetype/{id}")
	public Congetype updateConge(@PathVariable("id") final String id, @RequestBody Congetype employee) {
		Optional<Congetype> e = entrepriseService.getConge(id);
		if(e.isPresent()) {
			Congetype currentEmployee = e.get();
			
			Integer nbreJours = employee.getNombrejours();
			if(nbreJours != null) {
				currentEmployee.setNombrejours(nbreJours);
			}
			Integer nbreHeures = employee.getNombreheures();
			if(nbreHeures != null) {
				currentEmployee.setNombreheures(nbreHeures);
			}
			Integer avant = employee.getNbresemavaccouchement();
			if(avant != null) {
				currentEmployee.setNbresemavaccouchement(avant);
			}
			Integer apres = employee.getNbresemapresaccouchement();
			if(apres != null) {
				currentEmployee.setNbresemapresaccouchement(apres);
			}
			
			entrepriseService.saveConge(currentEmployee);
			return currentEmployee;
		} else {
			return null;
		}
	}
	
	@PostMapping("/congeemployequota")
	public Congeemployequota createCongeemployequota(@RequestBody Congeemployequota employee) {
		return entrepriseService.saveCongeemployequota(employee);
	}
	
	@PutMapping("/congeemployequota/{id}")
	public Congeemployequota updateCongeemployequota(@PathVariable("id") final Integer id, @RequestBody Congeemployequota employee) {
		Optional<Congeemployequota> e =entrepriseService.getCongeemployequota(id);
		if(e.isPresent()) {
			Congeemployequota currentEmployee = e.get();
			
			Integer firstName = employee.getNbredejoursalloues();
			if(firstName != null) {
				currentEmployee.setNbredejoursalloues(firstName);
			}
			Integer lastName = employee.getNbredejourspris();
			if(lastName != null) {
				currentEmployee.setNbredejourspris(lastName);
			}
			Integer mail = employee.getBalance();
			if(mail != null) {
				currentEmployee.setBalance(mail);
			}
			
			entrepriseService.saveCongeemployequota(currentEmployee);
			return currentEmployee;
		} else {
			return null;
		}
	}
	
	@GetMapping("/candidatByEmail/{emailUser}")
	public Candidat findCandidatByEmail(@PathVariable("emailUser") final String emailUser) {
		Optional<Candidat> user = entrepriseService.findCandidatByEmail(emailUser);
		if(user.isPresent()) {
			return user.get();
		}
		else {
			return null;
		}
	}
	
	@GetMapping("/userByEmail/{emailUser}")
	public Employe findEmployeByEmail(@PathVariable("emailUser") final String emailUser) {
		Optional<Employe> user = entrepriseService.findUserByEmail(emailUser);
		if(user.isPresent()) {
			return user.get();
		}
		else {
			return null;
		}
	}
	
	@GetMapping("/congeemployequota/{id}")
	public Congeemployequota getCongeemployequota(@PathVariable("id") final Integer id) {
		Optional<Congeemployequota> employee = entrepriseService.getCongeemployequota(id);
		if(employee.isPresent()) {
			return employee.get();
		} else {
			return null;
		}
	}
	
	
	@PostMapping("/congedemande")
	public Congedemande createCongedemande(@RequestBody Congedemande employee) {
		return entrepriseService.saveCongedemande(employee);
	}
	
	@PostMapping("/congee")
	public Conge createConge(@RequestBody Conge employee) {
		return entrepriseService.saveConge(employee);
	}
	
	@PutMapping("/conge/{id}")
	public Conge updateConge(@PathVariable("id") final Integer id, @RequestBody Conge employee) {
		Optional<Conge> e = entrepriseService.getConge(id);
		if(e.isPresent()) {
			Conge currentEmployee = e.get();
			
			Integer status = employee.getCongestatus();
			if(status != null) {
				currentEmployee.setCongestatus(status);
			}
			String comm = employee.getCongecommentaire();
			if(comm != null) {
				currentEmployee.setCongecommentaire(comm);
			}
			
			entrepriseService.saveConge(currentEmployee);
			return currentEmployee;
		} else {
			return null;
		}
	}
	
	@GetMapping("/conge/{id}")
	public Conge getConge(@PathVariable("id") final Integer id) {
		Optional<Conge> employee = entrepriseService.getConge(id);
		if(employee.isPresent()) {
			return employee.get();
		} else {
			return null;
		}
	}
	
	
	@GetMapping("/congedemande/{id}")
	public Iterable<Congedemande> getCongedemande(@PathVariable("id") final Integer id) {
		return entrepriseService.getCongedemande(id);
		
	}
	
	
	@GetMapping("/congeForcongedemande/{id}")
	public Conge getCongeForcongedemande(@PathVariable("id") final Integer id) {
		Optional<Conge> employee = entrepriseService.getCongeForcongedemande(id);
		if(employee.isPresent()) {
			return employee.get();
		} else {
			return null;
		}
	}
	
	@GetMapping("/congedemandes")
	public Iterable<Congedemande> getCongedemandes() {
		return entrepriseService.getCongedemandes();
	}
	@GetMapping("/listConges")
	public Iterable<Conge> getListConges() {
		return entrepriseService.getListConges();
	}
	
	@GetMapping("/offre/{id}")
	public Offre getOffre(@PathVariable("id") final Integer id) {
		Optional<Offre> employee = entrepriseService.getOffre(id);
		if(employee.isPresent()) {
			return employee.get();
		} else {
			return null;
		}
	}
	
	@GetMapping("/offres")
	public Iterable<Offre> getOffres() {
		return entrepriseService.getOffres();
	}
	@DeleteMapping("/offre/{id}")
	public void deleteOffre(@PathVariable("id") final Integer id) {
		entrepriseService.deleteOffre(id);
	}
	
	@PostMapping("/offre")
	public Offre createOffre(@RequestBody Offre employee) {
		return entrepriseService.saveOffre(employee);
	}
	@PutMapping("/offre/{id}")
	public Offre updateOffre(@PathVariable("id") final Integer id, @RequestBody Offre employee) {
		Optional<Offre> e = entrepriseService.getOffre(id);
		if(e.isPresent()) {
			Offre currentEmployee = e.get();
			
			Integer status = employee.getStatus();
			if(status != null) {
				currentEmployee.setStatus(status);
			}
			
			entrepriseService.saveOffre(currentEmployee);
			return currentEmployee;
		} else {
			return null;
		}
	}
	@PostMapping("/candidat")
	public Candidat createCandidat(@RequestBody Candidat employee) {
		return entrepriseService.saveCandidat(employee);
	}
	@PostMapping("/historiquecandidatemploi")
	public Historiquecandidatemploi createHistoriquecandidatemploi(@RequestBody Historiquecandidatemploi employee) {
		return entrepriseService.saveHistoriquecandidatemploi(employee);
	}
	
	@GetMapping("/candidatsOffre/{id}")
	public Iterable<Candidat> getCandidatsOffre(@PathVariable("id") final Integer id) {
		return entrepriseService.getCandidatsOffre(id);
	}
	
	@GetMapping("/candidat/{id}")
	public Candidat getCandidat(@PathVariable("id") final Integer id) {
		Optional<Candidat> employee = entrepriseService.getCandidat(id);
		if(employee.isPresent()) {
			return employee.get();
		} else {
			return null;
		}
	}
	
	@GetMapping("/historiquecandidatemploiOC/{id}")
	public Iterable<Historiquecandidatemploi> getHistoriquecandidatemploiOffreCandidat(@PathVariable("id") final Integer id) {
		return entrepriseService.getHistoriquecandidatemploiOffreCandidat(id);
		
	}
	@PutMapping("/candidat/{id}")
	public Candidat updateCandidat(@PathVariable("id") final Integer id, @RequestBody Candidat employee) {
		Optional<Candidat> e = entrepriseService.getCandidat(id);
		if(e.isPresent()) {
			Candidat currentEmployee = e.get();
			
			String firstName = employee.getPassword();
			if(firstName != null) {
				currentEmployee.setPassword(firstName);
			}
			
			entrepriseService.saveCandidat(currentEmployee);
			return currentEmployee;
		} else {
			return null;
		}
	}
	
}
