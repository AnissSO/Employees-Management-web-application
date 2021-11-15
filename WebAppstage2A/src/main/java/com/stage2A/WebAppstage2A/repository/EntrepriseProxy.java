package com.stage2A.WebAppstage2A.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EntrepriseProxy {

	@Autowired
	private CustomProperties props;
	
	public Entreprise getEntreprise(Integer id) {
		String baseApiUrl = props.getApiUrl();
		String getEntrepriseUrl = baseApiUrl + "/entreprise/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Entreprise> response = restTemplate.exchange(
				getEntrepriseUrl, 
				HttpMethod.GET, 
				null,
				Entreprise.class
			);
		
		log.debug("Get Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Entreprise updateEntreprise(Entreprise e) {
		String baseApiUrl = props.getApiUrl();
		String updateEntrepriseUrl = baseApiUrl + "/entreprise/" + e.getId_entreprise();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Entreprise> request = new HttpEntity<Entreprise>(e);
		ResponseEntity<Entreprise> response = restTemplate.exchange(
				updateEntrepriseUrl, 
				HttpMethod.PUT, 
				request, 
				Entreprise.class);
		
		log.debug("Update Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public EntrepriseStructure getDepartement(Integer id) {
		String baseApiUrl = props.getApiUrl();
		String getEmployeeUrl = baseApiUrl + "/departement/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<EntrepriseStructure> response = restTemplate.exchange(
				getEmployeeUrl, 
				HttpMethod.GET, 
				null,
				EntrepriseStructure.class
			);
		
		log.debug("Get Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Iterable<EntrepriseStructure> getDepartements(Integer id) {

		String baseApiUrl = props.getApiUrl();
		String getEmployeesUrl = baseApiUrl + "/departements/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<EntrepriseStructure>> response = restTemplate.exchange(
				getEmployeesUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<EntrepriseStructure>>() {}
			);
		
		log.debug("Get Employees call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public EntrepriseStructure createDepartement(EntrepriseStructure e) {
		String baseApiUrl = props.getApiUrl();
		String createEmployeeUrl = baseApiUrl + "/createDepartement";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<EntrepriseStructure> request = new HttpEntity<EntrepriseStructure>(e);
		ResponseEntity<EntrepriseStructure> response = restTemplate.exchange(
				createEmployeeUrl, 
				HttpMethod.POST, 
				request, 
				EntrepriseStructure.class);
		
		log.debug("Create Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public void deleteDepartement(Integer id) {
		String baseApiUrl = props.getApiUrl();
		String deleteEmployeeUrl = baseApiUrl + "/departement/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteEmployeeUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
		
		log.debug("Delete Employee call " + response.getStatusCode().toString());
	}

	
	public Iterable<Poste> getPostes() {

		String baseApiUrl = props.getApiUrl();
		String getEmployeesUrl = baseApiUrl + "/postes";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Poste>> response = restTemplate.exchange(
				getEmployeesUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<Poste>>() {}
			);
		
		log.debug("Get Employees call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Poste createPoste(Poste p) {
		String baseApiUrl = props.getApiUrl();
		String createEmployeeUrl = baseApiUrl + "/poste";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Poste> request = new HttpEntity<Poste>(p);
		ResponseEntity<Poste> response = restTemplate.exchange(
				createEmployeeUrl, 
				HttpMethod.POST, 
				request, 
				Poste.class);
		
		log.debug("Create Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public void deletePoste(String id) {
		String baseApiUrl = props.getApiUrl();
		String deleteEmployeeUrl = baseApiUrl + "/poste/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteEmployeeUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
		
		log.debug("Delete Employee call " + response.getStatusCode().toString());
	}
	
	public Employe getEmploye(Integer id) {
		String baseApiUrl = props.getApiUrl();
		String getEmployeeUrl = baseApiUrl + "/employe/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Employe> response = restTemplate.exchange(
				getEmployeeUrl, 
				HttpMethod.GET, 
				null,
				Employe.class
			);
		
		log.debug("Get Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Iterable<Employe> getEmployes() {

		String baseApiUrl = props.getApiUrl();
		String getEmployeesUrl = baseApiUrl + "/employes";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Employe>> response = restTemplate.exchange(
				getEmployeesUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<Employe>>() {}
			);
		
		log.debug("Get Employees call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public void deleteEmploye(Integer id) {
		String baseApiUrl = props.getApiUrl();
		String deleteEmployeeUrl = baseApiUrl + "/employe/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteEmployeeUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
		
		log.debug("Delete Employee call " + response.getStatusCode().toString());
	}
	
	public Employe createEmployee(Employe e) {
		String baseApiUrl = props.getApiUrl();
		String createEmployeeUrl = baseApiUrl + "/employer";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Employe> request = new HttpEntity<Employe>(e);
		ResponseEntity<Employe> response = restTemplate.exchange(
				createEmployeeUrl, 
				HttpMethod.POST, 
				request, 
				Employe.class);
		
		log.debug("Create Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Employe updateEmployee(Employe e) {
		String baseApiUrl = props.getApiUrl();
		String updateEmployeeUrl = baseApiUrl + "/employe/" + e.getId_employe();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Employe> request = new HttpEntity<Employe>(e);
		ResponseEntity<Employe> response = restTemplate.exchange(
				updateEmployeeUrl, 
				HttpMethod.PUT, 
				request, 
				Employe.class);
		
		log.debug("Update Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Iterable<Projet> getProjets() {

		String baseApiUrl = props.getApiUrl();
		String getEmployeesUrl = baseApiUrl + "/projets";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Projet>> response = restTemplate.exchange(
				getEmployeesUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<Projet>>() {}
			);
		
		log.debug("Get Employees call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public void deleteProjet(Integer id) {
		String baseApiUrl = props.getApiUrl();
		String deleteEmployeeUrl = baseApiUrl + "/projet/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteEmployeeUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
		
		log.debug("Delete Employee call " + response.getStatusCode().toString());
	}
	
	public Projet createProjet(Projet e) {
		String baseApiUrl = props.getApiUrl();
		String createEmployeeUrl = baseApiUrl + "/projet";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Projet> request = new HttpEntity<Projet>(e);
		ResponseEntity<Projet> response = restTemplate.exchange(
				createEmployeeUrl, 
				HttpMethod.POST, 
				request, 
				Projet.class);
		
		log.debug("Create Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Congetype getConge(String id) {
		String baseApiUrl = props.getApiUrl();
		String getEmployeeUrl = baseApiUrl + "/congetype/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Congetype> response = restTemplate.exchange(
				getEmployeeUrl, 
				HttpMethod.GET, 
				null,
				Congetype.class
			);
		
		log.debug("Get Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Iterable<Congetype> getConges() {

		String baseApiUrl = props.getApiUrl();
		String getEmployeesUrl = baseApiUrl + "/congetypes";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Congetype>> response = restTemplate.exchange(
				getEmployeesUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<Congetype>>() {}
			);
		
		log.debug("Get Employees call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Congetype updateConge(Congetype e) {
		String baseApiUrl = props.getApiUrl();
		String updateEmployeeUrl = baseApiUrl + "/congetype/" + e.getCongetypecode();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Congetype> request = new HttpEntity<Congetype>(e);
		ResponseEntity<Congetype> response = restTemplate.exchange(
				updateEmployeeUrl, 
				HttpMethod.PUT, 
				request, 
				Congetype.class);
		
		log.debug("Update Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Congeemployequota saveCongeemployequota(Congeemployequota e) {
		String baseApiUrl = props.getApiUrl();
		String createEmployeeUrl = baseApiUrl + "/congeemployequota";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Congeemployequota> request = new HttpEntity<Congeemployequota>(e);
		ResponseEntity<Congeemployequota> response = restTemplate.exchange(
				createEmployeeUrl, 
				HttpMethod.POST, 
				request, 
				Congeemployequota.class);
		
		log.debug("Create Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Candidat findCandidatByEmail(String emailUser) {
		String baseApiUrl = props.getApiUrl();
		String getUserByEmailUrl = baseApiUrl + "/candidatByEmail/" + emailUser;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Candidat> response = restTemplate.exchange(getUserByEmailUrl, HttpMethod.GET, null, Candidat.class);
		
		log.debug("Get Survey call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	public Employe findEmployeByEmail(String emailUser) {
		String baseApiUrl = props.getApiUrl();
		String getUserByEmailUrl = baseApiUrl + "/userByEmail/" + emailUser;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Employe> response = restTemplate.exchange(getUserByEmailUrl, HttpMethod.GET, null, Employe.class);
		
		log.debug("Get Survey call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Congeemployequota getCongeemployequota(Integer idEmploye) {
		String baseApiUrl = props.getApiUrl();
		String getEmployeeUrl = baseApiUrl + "/congeemployequota/" + idEmploye;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Congeemployequota> response = restTemplate.exchange(
				getEmployeeUrl, 
				HttpMethod.GET, 
				null,
				Congeemployequota.class
			);
		
		log.debug("Get Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Congedemande createCongedemande(Congedemande e) {
		String baseApiUrl = props.getApiUrl();
		String createEmployeeUrl = baseApiUrl + "/congedemande";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Congedemande> request = new HttpEntity<Congedemande>(e);
		ResponseEntity<Congedemande> response = restTemplate.exchange(
				createEmployeeUrl, 
				HttpMethod.POST, 
				request, 
				Congedemande.class);
		
		log.debug("Create Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	public Conge createConge(Conge e) {
		String baseApiUrl = props.getApiUrl();
		String createEmployeeUrl = baseApiUrl + "/congee";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Conge> request = new HttpEntity<Conge>(e);
		ResponseEntity<Conge> response = restTemplate.exchange(
				createEmployeeUrl, 
				HttpMethod.POST, 
				request, 
				Conge.class);
		
		log.debug("Create Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	
	public Congeemployequota updateCongeemployequota(Congeemployequota e) {
		String baseApiUrl = props.getApiUrl();
		String updateEmployeeUrl = baseApiUrl + "/congeemployequota/" + e.getId_employe();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Congeemployequota> request = new HttpEntity<Congeemployequota>(e);
		ResponseEntity<Congeemployequota> response = restTemplate.exchange(
				updateEmployeeUrl, 
				HttpMethod.PUT, 
				request, 
				Congeemployequota.class);
		
		log.debug("Update Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	public Conge updateConge(Conge e) {
		String baseApiUrl = props.getApiUrl();
		String updateEmployeeUrl = baseApiUrl + "/conge/" + e.getId_conge();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Conge> request = new HttpEntity<Conge>(e);
		ResponseEntity<Conge> response = restTemplate.exchange(
				updateEmployeeUrl, 
				HttpMethod.PUT, 
				request, 
				Conge.class);
		
		log.debug("Update Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	public Conge getConge(int id) {
		String baseApiUrl = props.getApiUrl();
		String getEmployeeUrl = baseApiUrl + "/conge/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Conge> response = restTemplate.exchange(
				getEmployeeUrl, 
				HttpMethod.GET, 
				null,
				Conge.class
			);
		
		log.debug("Get Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Iterable<Congedemande> getCongedemande(Integer id) {
		String baseApiUrl = props.getApiUrl();
		String getEmployeeUrl = baseApiUrl + "/congedemande/" + id;

		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Congedemande>> response = restTemplate.exchange(
				getEmployeeUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<Congedemande>>() {}
			);
		
		log.debug("Get Employees call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	
	public Conge getCongeForcongedemande(Integer id) {
		String baseApiUrl = props.getApiUrl();
		String getEmployeeUrl = baseApiUrl + "/congeForcongedemande/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Conge> response = restTemplate.exchange(
				getEmployeeUrl, 
				HttpMethod.GET, 
				null,
				Conge.class
			);
		
		log.debug("Get Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Iterable<Congedemande> getCongedemandes() {

		String baseApiUrl = props.getApiUrl();
		String getEmployeesUrl = baseApiUrl + "/congedemandes";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Congedemande>> response = restTemplate.exchange(
				getEmployeesUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<Congedemande>>() {}
			);
		
		log.debug("Get Employees call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Iterable<Conge> getListConges() {

		String baseApiUrl = props.getApiUrl();
		String getEmployeesUrl = baseApiUrl + "/listConges";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Conge>> response = restTemplate.exchange(
				getEmployeesUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<Conge>>() {}
			);
		
		log.debug("Get Employees call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Offre getOffre(Integer id) {
		String baseApiUrl = props.getApiUrl();
		String getEmployeeUrl = baseApiUrl + "/offre/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Offre> response = restTemplate.exchange(
				getEmployeeUrl, 
				HttpMethod.GET, 
				null,
				Offre.class
			);
		
		log.debug("Get Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	public Iterable<Offre> getOffres() {

		String baseApiUrl = props.getApiUrl();
		String getEmployeesUrl = baseApiUrl + "/offres";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Offre>> response = restTemplate.exchange(
				getEmployeesUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<Offre>>() {}
			);
		
		log.debug("Get Employees call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public void deleteOffre(int id) {
		String baseApiUrl = props.getApiUrl();
		String deleteEmployeeUrl = baseApiUrl + "/offre/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteEmployeeUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
		
		log.debug("Delete Employee call " + response.getStatusCode().toString());
	}
	
	public Offre createOffre(Offre e) {
		String baseApiUrl = props.getApiUrl();
		String createEmployeeUrl = baseApiUrl + "/offre";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Offre> request = new HttpEntity<Offre>(e);
		ResponseEntity<Offre> response = restTemplate.exchange(
				createEmployeeUrl, 
				HttpMethod.POST, 
				request, 
				Offre.class);
		
		log.debug("Create Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	/**
	 * Update an employee - using the PUT HTTP Method.
	 * @param e Existing employee to update
	 */
	public Offre updateOffre(Offre e) {
		String baseApiUrl = props.getApiUrl();
		String updateEmployeeUrl = baseApiUrl + "/offre/" + e.getId_offre();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Offre> request = new HttpEntity<Offre>(e);
		ResponseEntity<Offre> response = restTemplate.exchange(
				updateEmployeeUrl, 
				HttpMethod.PUT, 
				request, 
				Offre.class);
		
		log.debug("Update Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Candidat createCandidat(Candidat e) {
		String baseApiUrl = props.getApiUrl();
		String createEmployeeUrl = baseApiUrl + "/candidat";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Candidat> request = new HttpEntity<Candidat>(e);
		ResponseEntity<Candidat> response = restTemplate.exchange(
				createEmployeeUrl, 
				HttpMethod.POST, 
				request, 
				Candidat.class);
		
		log.debug("Create Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	public Historiquecandidatemploi createHistoriquecandidatemploi(Historiquecandidatemploi e) {
		String baseApiUrl = props.getApiUrl();
		String createEmployeeUrl = baseApiUrl + "/historiquecandidatemploi";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Historiquecandidatemploi> request = new HttpEntity<Historiquecandidatemploi>(e);
		ResponseEntity<Historiquecandidatemploi> response = restTemplate.exchange(
				createEmployeeUrl, 
				HttpMethod.POST, 
				request, 
				Historiquecandidatemploi.class);
		
		log.debug("Create Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	public Iterable<Candidat> getCandidatsOffre(Integer id) {

		String baseApiUrl = props.getApiUrl();
		String getEmployeesUrl = baseApiUrl + "/candidatsOffre/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Candidat>> response = restTemplate.exchange(
				getEmployeesUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<Candidat>>() {}
			);
		
		log.debug("Get Employees call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	public Candidat getCandidat(int id) {
		String baseApiUrl = props.getApiUrl();
		String getEmployeeUrl = baseApiUrl + "/candidat/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Candidat> response = restTemplate.exchange(
				getEmployeeUrl, 
				HttpMethod.GET, 
				null,
				Candidat.class
			);
		
		log.debug("Get Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	public Iterable<Historiquecandidatemploi> getHistoriquecandidatemploiOffreCandidat(int id) {

		String baseApiUrl = props.getApiUrl();
		String getEmployeesUrl = baseApiUrl + "/historiquecandidatemploiOC/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Historiquecandidatemploi>> response = restTemplate.exchange(
				getEmployeesUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<Historiquecandidatemploi>>() {}
			);
		
		log.debug("Get Employees call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	public Candidat updateCandidat(Candidat e) {
		String baseApiUrl = props.getApiUrl();
		String updateEmployeeUrl = baseApiUrl + "/candidat/" + e.getId_candidat();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Candidat> request = new HttpEntity<Candidat>(e);
		ResponseEntity<Candidat> response = restTemplate.exchange(
				updateEmployeeUrl, 
				HttpMethod.PUT, 
				request, 
				Candidat.class);
		
		log.debug("Update Employee call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
}
