package com.stage2A.APIstage2A.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stage2A.APIstage2A.model.Candidat;
import com.stage2A.APIstage2A.model.Conge;
import com.stage2A.APIstage2A.model.Congedemande;
import com.stage2A.APIstage2A.model.Congeemployequota;
import com.stage2A.APIstage2A.model.CongeemployequotaId;
import com.stage2A.APIstage2A.model.Congetype;
import com.stage2A.APIstage2A.model.Employe;
import com.stage2A.APIstage2A.model.Entreprise;
import com.stage2A.APIstage2A.model.EntrepriseStructure;
import com.stage2A.APIstage2A.model.Historiquecandidatemploi;
import com.stage2A.APIstage2A.model.Offre;
import com.stage2A.APIstage2A.model.Poste;
import com.stage2A.APIstage2A.model.Projet;
import com.stage2A.APIstage2A.repository.CandidatRepository;
import com.stage2A.APIstage2A.repository.CongeRepository;
import com.stage2A.APIstage2A.repository.CongedemandeRepository;
import com.stage2A.APIstage2A.repository.CongeemployequotaRepository;
import com.stage2A.APIstage2A.repository.CongetypeRepository;
import com.stage2A.APIstage2A.repository.EmployeRepository;
import com.stage2A.APIstage2A.repository.EntrepriseRepository;
import com.stage2A.APIstage2A.repository.EntrepriseStructureRepository;
import com.stage2A.APIstage2A.repository.HistoriquecandidatemploiRepository;
import com.stage2A.APIstage2A.repository.OffreRepository;
import com.stage2A.APIstage2A.repository.PosteRepository;
import com.stage2A.APIstage2A.repository.ProjetRepository;

import lombok.Data;

@Data
@Service
public class EntrepriseService {
	
	@Autowired
	public EntrepriseRepository entrepriseRepository;
	
	@Autowired
	public EntrepriseStructureRepository entrepriseStructureRepository;
	
	@Autowired 
	public PosteRepository posteRepository;
	
	@Autowired
	public EmployeRepository employeRepository;
	
	@Autowired
	public ProjetRepository projetRepository;
	
	@Autowired
	public CongetypeRepository congetypeRepository;
	
	@Autowired
	public CongeemployequotaRepository congeemployequotaRepository;
	
	@Autowired
	public CongedemandeRepository congedemandeRepository;
	
	@Autowired
	public CongeRepository congeRepository;
	
	@Autowired
	public OffreRepository offreRepository;
	
	@Autowired
	public CandidatRepository candidatRepository;
	
	@Autowired
	public HistoriquecandidatemploiRepository hce;
	
	public Optional<Entreprise> getEntreprise(final Integer id){
		return entrepriseRepository.findById(id);
	}
	
	public Entreprise saveEntreprise(Entreprise entreprise){
		Entreprise savedEntreprise = entrepriseRepository.save(entreprise);
		return savedEntreprise;
	}

	public Optional<EntrepriseStructure> getDepartement(final Integer id) {
		return entrepriseStructureRepository.findById(id);
	}
	
	public Iterable<EntrepriseStructure> getDepartements(final Integer id) {
		return entrepriseStructureRepository.getDepartements(id);
	}
	
	public EntrepriseStructure saveDepartement(EntrepriseStructure es) {
		EntrepriseStructure savedes = entrepriseStructureRepository.save(es);
		System.out.println(es);
		return savedes;
	}
	
	public void deleteDepartement(final Integer id) {
		entrepriseStructureRepository.deleteById(id);
	}
	
	public Iterable<Poste> getPostes() {
		return posteRepository.findAll();
	}
	
	public Poste savePoste(Poste p) {
		Poste savedPoste = posteRepository.save(p);
		return savedPoste;
	}
	
	public void deletePoste(final String id) {
		posteRepository.deleteById(id);
	}
	
	public Optional<Employe> getEmploye(final Integer id) {
		return employeRepository.findById(id);
	}
	
	public Iterable<Employe> getEmployes() {
		return employeRepository.findAll();
	}
	
	public void deleteEmploye(final Integer id) {
		employeRepository.deleteById(id);
	}
	
	public Employe saveEmployee(Employe employee) {
		Employe savedEmployee = employeRepository.save(employee);
		return savedEmployee;
	}

	public Iterable<Projet> getProjets() {
		return projetRepository.findAll();
	}
	
	public void deleteProjet(final Integer id) {
		projetRepository.deleteById(id);
	}
	
	public Projet saveProjet(Projet employee) {
		Projet savedEmployee = projetRepository.save(employee);
		return savedEmployee;
	}
	
	public Optional<Congetype> getConge(final String id) {
		return congetypeRepository.findById(id);
	}
	
	public Iterable<Congetype> getConges() {
		return congetypeRepository.findAll();
	}
	
	public Congetype saveConge(Congetype employee) {
		Congetype savedEmployee = congetypeRepository.save(employee);
		return savedEmployee;
	}
	
	public Congeemployequota saveCongeemployequota(Congeemployequota employee) {
		Congeemployequota savedEmployee = congeemployequotaRepository.save(employee);
		return savedEmployee;
	}
	public Optional<Employe> findUserByEmail(final String emailUser){
		return employeRepository.findUserByEmail(emailUser);
	}
	public Optional<Candidat> findCandidatByEmail(final String emailUser){
		return candidatRepository.findCandidatByEmail(emailUser);
	}
	
	public Optional<Congeemployequota> getCongeemployequota(final Integer id) {
		CongeemployequotaId congeemployequotaId = new CongeemployequotaId("1",id);
		return congeemployequotaRepository.findById(congeemployequotaId);
	}
	public Congedemande saveCongedemande(Congedemande employee) {
		Congedemande savedEmployee = congedemandeRepository.save(employee);
		return savedEmployee;
	}
	public Conge saveConge(Conge employee) {
		Conge savedEmployee = congeRepository.save(employee);
		return savedEmployee;
	}
	public Optional<Conge> getConge(final Integer id) {
		return congeRepository.getConge(id);
	}
	
	
	public Iterable<Congedemande> getCongedemande(final Integer id) {
		return congedemandeRepository.getCongedemande(id);
	}
	
	public Optional<Conge> getCongeForcongedemande(final Integer id) {
		return congeRepository.getCongeForcongedemande(id);
	}
	public Iterable<Congedemande> getCongedemandes() {
		return congedemandeRepository.findAll();
	}
	public Iterable<Conge> getListConges() {
		return congeRepository.findAll();
	}
	public Optional<Offre> getOffre(final Integer id) {
		return offreRepository.findById(id);
	}
	public Iterable<Offre> getOffres() {
		return offreRepository.findAll();
	}
	public void deleteOffre(final Integer id) {
		offreRepository.deleteById(id);
	}
	public Offre saveOffre(Offre employee) {
		Offre savedEmployee = offreRepository.save(employee);
		return savedEmployee;
	}
	public Candidat saveCandidat(Candidat employee) {
		Candidat savedEmployee = candidatRepository.save(employee);
		return savedEmployee;
	}
	public Historiquecandidatemploi saveHistoriquecandidatemploi(Historiquecandidatemploi employee) {
		Historiquecandidatemploi savedEmployee = hce.save(employee);
		return savedEmployee;
	}
	public Iterable<Candidat> getCandidatsOffre(final Integer id) {
		return candidatRepository.getCandidatsOffre(id);
	}
	public Optional<Candidat> getCandidat(final Integer id) {
		return candidatRepository.findById(id);
	}
	public Iterable<Historiquecandidatemploi> getHistoriquecandidatemploiOffreCandidat(final Integer id) {
		return hce.getHistoriquecandidatemploiOffreCandidat(id);
	}
	
}
