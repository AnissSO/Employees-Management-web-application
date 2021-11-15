package com.stage2A.WebAppstage2A.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
import com.stage2A.WebAppstage2A.service.EntrepriseService;

import lombok.Data;

@Data
@Controller
public class EntrepriseController {

	@Autowired
	private EntrepriseService entrepriseService;
	
	@GetMapping("/")
	public String home(Model model) {
		Entreprise entreprise = entrepriseService.getEntreprise(1);
		model.addAttribute("entreprise", entreprise);
		Iterable<Offre> listOffres = entrepriseService.getOffres();
		
		model.addAttribute("listOffres", listOffres);
		return "home";
	}
	
	@GetMapping("/showEntreprise")
	public String showEntreprise(Model model) {
		Entreprise entreprise = entrepriseService.getEntreprise(1);
		Iterable<EntrepriseStructure> listDepartements =  entrepriseService.getDepartements(1);
		model.addAttribute("listDepartements", listDepartements);
		model.addAttribute("entreprise", entreprise);
		//getPostes
		return "showEntrepriseInfos";
	}
	
	@GetMapping("/connexion")
	public String loginPage(Model model) {
		Employe employe = new Employe();
		model.addAttribute("employe", employe);
		return "connexionPage";
	}

	@GetMapping("/adminPasswordIncorrect")
	public String loginPagePasswordIncorrect(Model model) {
		Employe employe = new Employe();
		model.addAttribute("employe", employe);
		return "connexionPagePasswordIncorrect";
	}
	
	@PostMapping("formLogin")
	public ModelAndView formLogin(@ModelAttribute Employe employe, Model model) {
		Employe employDB = entrepriseService.findEmployeByEmail(employe.getEmail());
		Candidat candidat = entrepriseService.findCandidatByEmail(employe.getEmail());
		if(employe.getEmail().equals("admin@gmail.com")) {
			System.out.println("Email Admin correct");
			if(employe.getPassword().equals("admin")) {
				System.out.println("Mot de passe Admin correct");
				return new ModelAndView("redirect:/adminHomePage");
			}
			else {
				System.out.println("Mot de passe Admin Incorrect");
				
				return new ModelAndView("redirect:/adminPasswordIncorrect");
			}
		}
		else if(employDB == null){
			System.out.println("false 1");
			if(candidat == null) {
				System.out.println("false 1");
				return new ModelAndView("redirect:/adminPasswordIncorrect");
			}
			else {
				if(candidat.getPassword().equals(employe.getPassword())) {
					System.out.println("Candidat "+ employe.getNom());
					return new ModelAndView("redirect:/candidatAccount/" + candidat.getId_candidat());
				}
				else {
					System.out.println("false Candidat");
					return new ModelAndView("redirect:/adminPasswordIncorrect");
				}
			}
		}
		else {
			if(employDB.getPassword().equals(employe.getPassword())) {
				System.out.println("Employé"+ employe.getNom());
				return new ModelAndView("redirect:/homeUser/" + employDB.getId_employe());
			}
			else {
				System.out.println("false 2");
				return new ModelAndView("redirect:/adminPasswordIncorrect");
			}
			
		}
		
		
	}
	
	@GetMapping("/adminHomePage")
	public String adminHomePage(Model model) {
		Entreprise entreprise = entrepriseService.getEntreprise(1);
		model.addAttribute("entreprise", entreprise);
		
		Iterable<EntrepriseStructure> listDepartements =  entrepriseService.getDepartements(1);
		model.addAttribute("listDepartements", listDepartements);
		
		Iterable<Poste> listPostes = entrepriseService.getPostes();
		model.addAttribute("listPostes", listPostes);
		
		Iterable<Projet> listProjets = entrepriseService.getProjets();
		model.addAttribute("listProjets", listProjets);
		
		Iterable<Employe> listEmployes = entrepriseService.getEmployes();
		model.addAttribute("listEmployes", listEmployes);
		return "adminHomePage";
	}
	
	@GetMapping("/editEntreprise")
	public String editEntreprise(Model model) {
		Entreprise entreprise = entrepriseService.getEntreprise(1);
		model.addAttribute("entreprise", entreprise);
		return "updateEntreprise";
	}
	
	@PostMapping("/updateCompany")
	public ModelAndView updateCompany(@ModelAttribute Entreprise entreprise) {
		entreprise.setId_entreprise(1);
		entrepriseService.saveEntreprise(entreprise);
		return new ModelAndView("redirect:/adminHomePage");
	}
	
	@GetMapping("/addDepartement")
	public String addDepartement(Model model) {
		EntrepriseStructure es = new EntrepriseStructure();
		
		model.addAttribute("departement", es);
		return "addDepartement";
	}
	
	
	@GetMapping("/addSousDepartement/{id}")
	public String addSousDepartement(Model model, @PathVariable("id") final Integer id) {
		EntrepriseStructure es = new EntrepriseStructure();
		es.setNumdeptparent(id);
		model.addAttribute("sousdepartement", es);
		model.addAttribute("numDeptPar", id);
		return "addSousDepartement";
	}
	
	
	@PostMapping("/addNewSousDept")
	public ModelAndView addNewSousDept(@ModelAttribute EntrepriseStructure es) {
		System.out.println(es);
		entrepriseService.saveDepartement(es);
		return new ModelAndView("redirect:/showDepartement/" + es.getNumdeptparent());	
	}
	
	
	@PostMapping("/addNewDept")
	public ModelAndView addNewDept(@ModelAttribute EntrepriseStructure es) {
		es.setNumdeptparent(1);
		entrepriseService.saveDepartement(es);
		return new ModelAndView("redirect:/adminHomePage");	
	}
	
	
	@GetMapping("/deleteDepartement/{id}")
	public ModelAndView deleteDepartement(@PathVariable("id") final Integer id) {
		entrepriseService.deleteDepartement(id);
		return new ModelAndView("redirect:/adminHomePage");		
	}
	
	
	@GetMapping("/deleteSousDepartement/{id}")
	public ModelAndView deleteSousDepartement(@PathVariable("id") final Integer id) {
		EntrepriseStructure es = entrepriseService.getDepartement(id);
		entrepriseService.deleteDepartement(id);
		return new ModelAndView("redirect:/showDepartement/" + es.getNumdeptparent());		
	}
	
	
	@GetMapping("/showDepartementHome/{id}")
	public String showDepartementHome(Model model, @PathVariable("id") final Integer id) {
		EntrepriseStructure es = entrepriseService.getDepartement(id);
		
		Iterable<EntrepriseStructure> listDepartements =  entrepriseService.getDepartements(id);
		model.addAttribute("listDepartements", listDepartements);
		model.addAttribute("departement", es);
		return "showDepartementHome";
	}
	
	@GetMapping("/showDepartement/{id}")
	public String showDepartement(Model model, @PathVariable("id") final Integer id) {
		EntrepriseStructure es = entrepriseService.getDepartement(id);
		
		Iterable<EntrepriseStructure> listDepartements =  entrepriseService.getDepartements(id);
		model.addAttribute("listDepartements", listDepartements);
		model.addAttribute("departement", es);
		return "showDepartement";
	}
	
	@GetMapping("/addPoste")
	public String addPoste(Model model) {
		Poste p = new Poste();
		Random r = new Random();
		int low = 1;
		int high = 1000;
		int result = r.nextInt(high-low) + low;
		
		System.out.println("JOB" + result);
		String s = "JOB" + Integer.toString(result);
		p.setPostecode(s);
		p.setEstactif(1);
		model.addAttribute("poste", p);
		model.addAttribute("postecod", s);
		model.addAttribute("posteactif", 1);
		return "formNewPoste";
	}
	
	
	@PostMapping("/addNewPoste")
	public ModelAndView addNewPoste(@ModelAttribute Poste poste) {
		System.out.println(poste);
		
		entrepriseService.savePoste(poste);
		return new ModelAndView("redirect:/adminHomePage");	
	}
	
	@GetMapping("/deletePoste/{id}")
	public ModelAndView deletePoste(@PathVariable("id") final String id) {
		entrepriseService.deletePoste(id);
		return new ModelAndView("redirect:/adminHomePage");		
	}
	
	
	@GetMapping("/addEmploye")
	public String addEmploye(Model model) {
		Employe employe = new Employe();
		Iterable<Poste> listPostes = entrepriseService.getPostes();
		employe.setStatus(1);
		model.addAttribute("statu", 1);
		LocalDate ld = java.time.LocalDate.now();
		employe.setDatedebut(ld);
		model.addAttribute("datee", ld);
		model.addAttribute("listPostes", listPostes);
		model.addAttribute("employe", employe);
		return "formNewEmploye";
	}
	
	@PostMapping("/addNewEmploye")
	public ModelAndView addNewEmploye(@ModelAttribute Employe employe) {
		System.out.println(employe);
		//employe.setDatedebut(LocalDate.now());
		Employe employeSaved = entrepriseService.saveEmploye(employe);
		Congeemployequota congeemployequota = new Congeemployequota();
		congeemployequota.setCongetypecode("1");
		congeemployequota.setId_employe(employeSaved.getId_employe());
		Congetype congetype = entrepriseService.getConge("1");
		congeemployequota.setNbredejoursalloues(congetype.getNombrejours());
		congeemployequota.setBalance(congetype.getNombrejours());
		congeemployequota.setNbredejourspris(0);
		Congeemployequota f = entrepriseService.saveCongeemployequota(congeemployequota);
		System.out.println(f);
		return new ModelAndView("redirect:/adminHomePage");	
	}
	
	
	@GetMapping("/showEmploye/{id}")
	public String showEmploye(Model model, @PathVariable("id") final Integer id) {
		Employe es = entrepriseService.getEmploye(id);
		
		model.addAttribute("employe", es);
		return "showEmploye";
	}
	
	
	@GetMapping("/editEmploye/{id}")
	public String editEmploye(Model model, @PathVariable("id") final Integer id) {
		Employe es = entrepriseService.getEmploye(id);
		Iterable<Poste> listPostes = entrepriseService.getPostes();
		model.addAttribute("listPostes", listPostes);
		model.addAttribute("employe", es);
		model.addAttribute("idemp", id);
		
		return "updateEmploye";
	}
	@PostMapping("/updateEmployePost")
	public ModelAndView updateEmployePost(@ModelAttribute Employe employee) {
		
		entrepriseService.saveEmploye(employee);
		return new ModelAndView("redirect:/adminHomePage");	
	}
	
	
	@GetMapping("/deleteEmploye/{id}")
	public ModelAndView deleteEmploye(@PathVariable("id") final int id) {
		entrepriseService.deleteEmploye(id);
		return new ModelAndView("redirect:/adminHomePage");		
	}
	
	
	@GetMapping("/addProjet")
	public String addProjet(Model model) {
		Projet projet = new Projet();
		projet.setEtat(1);
		model.addAttribute("projet", projet);
		model.addAttribute("state", 1);
		return "formNewProjet";
	}
	
	
	@PostMapping("/addNewProjet")
	public ModelAndView addNewProjet(@ModelAttribute Projet projet) {
		System.out.println(projet);
		//employe.setDatedebut(LocalDate.now());
		entrepriseService.saveProjet(projet);
		return new ModelAndView("redirect:/adminHomePage");	
	}
	
	
	@GetMapping("/deleteProjet/{id}")
	public ModelAndView deleteProjet(@PathVariable("id") final Integer id) {
		entrepriseService.deleteProjet(id);
		return new ModelAndView("redirect:/adminHomePage");		
	}
	
	
	@GetMapping("/conge")
	public String conge(Model model) {
		Iterable<Congetype> listConges = entrepriseService.getConges();
		
		model.addAttribute("listConges", listConges);
		
		Iterable<Congedemande> listCongedemande = entrepriseService.getCongedemandes();
		model.addAttribute("listCongedemande", listCongedemande);
		for(Congedemande cd : listCongedemande) {
			Conge listConge = entrepriseService.getCongeForcongedemande(cd.getId_employe());
		}
		Iterable<Conge> listCongesTables = entrepriseService.getListConges();
		model.addAttribute("listCongesTables", listCongesTables);
		
		Iterable<Employe> listEmployes = entrepriseService.getEmployes();
		model.addAttribute("listEmployes", listEmployes);
	
		return "adminConge";
	}
	
	
	@GetMapping("/refuseConge/{id}")
	public ModelAndView refuseConge(Model model, @PathVariable("id") final Integer id) {
		Iterable<Congedemande> listFCongedemandes = entrepriseService.getCongedemandes();
		System.out.println(id);
		for(Congedemande cd : listFCongedemandes) {
			System.out.println(cd);
			if(cd.getId_congedemande().equals(id)) {
				Conge listFinalConge = entrepriseService.getCongeForcongedemande(cd.getId_congedemande());
				listFinalConge.setCongestatus(3);
				System.out.println(listFinalConge);
				
				Conge congefinal = entrepriseService.saveConge(listFinalConge);
				System.out.println(congefinal);
			}
		}
		Iterable<Congetype> listConges = entrepriseService.getConges();
		
		model.addAttribute("listConges", listConges);
		
		Iterable<Congedemande> listCongedemande = entrepriseService.getCongedemandes();
		model.addAttribute("listCongedemande", listCongedemande);
		for(Congedemande cd : listCongedemande) {
			Conge listConge = entrepriseService.getCongeForcongedemande(cd.getId_employe());
		}
		Iterable<Conge> listCongesTables = entrepriseService.getListConges();
		model.addAttribute("listCongesTables", listCongesTables);
		
		Iterable<Employe> listEmployes = entrepriseService.getEmployes();
		model.addAttribute("listEmployes", listEmployes);
		return new ModelAndView("redirect:/conge");		
	}
	
	@GetMapping("/acceptConge/{id}")
	public ModelAndView acceptConge(Model model, @PathVariable("id") final Integer id) {
		Iterable<Congedemande> listFCongedemandes = entrepriseService.getCongedemandes();
		System.out.println(id);
		for(Congedemande cd : listFCongedemandes) {
			System.out.println(cd);
			if(cd.getId_congedemande().equals(id)) {
				Conge listFinalConge = entrepriseService.getCongeForcongedemande(cd.getId_congedemande());
				listFinalConge.setCongestatus(2);
				System.out.println(listFinalConge);
				
				if(cd.getCongetypecode().equals("1")) {
					Congeemployequota c = entrepriseService.getCongeemployequota(cd.getId_employe());
					c.setNbredejourspris(c.getNbredejourspris() + listFinalConge.getCongenbrejours());
					c.setBalance(c.getNbredejoursalloues() - c.getNbredejourspris());
					entrepriseService.updateCongeemployequota(c);
				}
				
				Conge congefinal = entrepriseService.saveConge(listFinalConge);
				System.out.println(congefinal);
			}
		}
		Iterable<Congetype> listConges = entrepriseService.getConges();
		
		model.addAttribute("listConges", listConges);
		
		Iterable<Congedemande> listCongedemande = entrepriseService.getCongedemandes();
		model.addAttribute("listCongedemande", listCongedemande);
		for(Congedemande cd : listCongedemande) {
			Conge listConge = entrepriseService.getCongeForcongedemande(cd.getId_employe());
		}
		Iterable<Conge> listCongesTables = entrepriseService.getListConges();
		model.addAttribute("listCongesTables", listCongesTables);
		
		Iterable<Employe> listEmployes = entrepriseService.getEmployes();
		model.addAttribute("listEmployes", listEmployes);
		return new ModelAndView("redirect:/conge");		
	}
	
	@GetMapping("/editCongetype/{id}")
	public String editCongetype(Model model, @PathVariable("id") final String id) {
		Congetype congetype = entrepriseService.getConge(id);
		String code = congetype.getCongetypecode();
		String co = congetype.getCongetypecode();
		model.addAttribute("congetype", congetype);
		model.addAttribute("code", code);
		model.addAttribute("co", co);
		return "editCongetype";
	}
	
	@PostMapping("/updateCongetype")
	public ModelAndView updateCongetype(@ModelAttribute Congetype congetype) {
		System.out.println(congetype);
		//employe.setDatedebut(LocalDate.now());
		entrepriseService.saveConge(congetype);
		return new ModelAndView("redirect:/conge");	
	}
	
	@GetMapping("/showCongetype/{id}")
	public String showCongetype(Model model, @PathVariable("id") final String id) {
		Congetype congetype = entrepriseService.getConge(id);
		String code = congetype.getCongetypecode();
		model.addAttribute("code", code);
		model.addAttribute("congetype", congetype);
		return "showCongetype";
	}
	
	
	@GetMapping("/homeUser/{id}")
	public String homeUser(Model model, @PathVariable("id") final Integer id) {
		Employe employe = entrepriseService.getEmploye(id);
		model.addAttribute("employe", employe);
		Congeemployequota congeemployequota = entrepriseService.getCongeemployequota(employe.getId_employe());
		model.addAttribute("congeemployequota", congeemployequota);
		return "homeUser";
	}
	
	
	@GetMapping("/editemailMdp/{id}")
	public String editemailMdp(Model model, @PathVariable("id") final Integer id) {
		Employe employe = entrepriseService.getEmploye(id);
		model.addAttribute("employe", employe);
		model.addAttribute("idem", employe.getId_employe());
		return "editemailMdp";
	}
	
	
	@PostMapping("/updateemailMdp")
	public ModelAndView updateemailMdp(@ModelAttribute Employe employe) {
		
		//employe.setDatedebut(LocalDate.now());
		entrepriseService.saveEmploye(employe);
		return new ModelAndView("redirect:/homeUser/" + employe.getId_employe());	
	}
	
	@GetMapping("/congeUser/{id}")
	public String congeUser(Model model, @PathVariable("id") final Integer id) {
		Employe employe = entrepriseService.getEmploye(id);
		System.out.println("L'employé EST : " + employe);
		Congeemployequota ceq = entrepriseService.getCongeemployequota(id);
		model.addAttribute("employe", employe);
		model.addAttribute("ceq", ceq);
		Iterable<Congetype> listConges = entrepriseService.getConges();
		
		Iterable<Congedemande> cd = entrepriseService.getCongedemande(id);
		
		Iterable<Conge> listDesConges = entrepriseService.getListConges();
		//Conge conge = entrepriseService.getCongeForcongedemande(cd.iterator().next().getId_congedemande());
		//model.addAttribute("conge", conge);
		model.addAttribute("cd", cd);
		model.addAttribute("listDesConges", listDesConges);
		model.addAttribute("listConges", listConges);
		return "congeUser";
	}
	
	
	@GetMapping("/demandecongeAP/{id}")
	public String demandecongeAP(Model model, @PathVariable("id") final Integer id) {
		Employe employe = entrepriseService.getEmploye(id);
		//Congeemployequota ceq = entrepriseService.getCongeemployequota(id);
		model.addAttribute("employe", employe);
		//model.addAttribute("ceq", ceq);
		Iterable<Congetype> listConges = entrepriseService.getConges();
		Congedemande congedemande = new Congedemande();
		congedemande.setId_employe(id);
		model.addAttribute("listConges", listConges);
		model.addAttribute("congedemande", congedemande);
		model.addAttribute("idemploy", id);
		
		String ctc = "1";
		model.addAttribute("ctc", ctc);
		Congeemployequota congeemployequota = entrepriseService.getCongeemployequota(id);
		model.addAttribute("ceq", congeemployequota);
		return "demandecongeAP";
	}
	
	

	@PostMapping("/addDemandeCongeAP")
	public ModelAndView addDemandeCongeAP(@ModelAttribute Congedemande congedemande) {
		Random r = new Random();
		int low = 1;
		int high = 1000;
		int result = r.nextInt(high-low) + low;
		Integer nbrJ = Integer.parseInt(congedemande.getCongetypenom());
		System.out.println(nbrJ);
		System.out.println(congedemande.getCongetypecode());
		congedemande.setCongetypecode("1");
		Congetype congetype = entrepriseService.getConge(congedemande.getCongetypecode());
		System.out.println("WORKS");
		congedemande.setCongetypenom(congetype.getCongetypenom());
		congedemande.setId_congedemande(result);
		System.out.println(congedemande);
		Congedemande congedemandeDB = entrepriseService.saveCongedemande(congedemande);
		System.out.println(congedemandeDB);
		Conge conge = new Conge();
		
		conge.setId_congedemande(congedemandeDB.getId_congedemande());
		conge.setId_employe(congedemandeDB.getId_employe());
		conge.setCongetypecode(congedemandeDB.getCongetypecode());
		conge.setCongedate(congedemandeDB.getDatedebutconge());
		conge.setCongenbrejours(nbrJ);
		conge.setCongestatus(1);
		//conge.setCongecommentaire(congedemandeDB.getCongecommentaire());
		System.out.println(conge);
		Conge congeDB = entrepriseService.saveConge(conge);
		System.out.println(congeDB);
		//employe.setDatedebut(LocalDate.now());
		//entrepriseService.saveEmploye(employe);
		return new ModelAndView("redirect:/congeUser/" + congedemande.getId_employe());	
	}
	
	@GetMapping("/demandeconge/{id}")
	public String demandeconge(Model model, @PathVariable("id") final Integer id) {
		Employe employe = entrepriseService.getEmploye(id);
		//Congeemployequota ceq = entrepriseService.getCongeemployequota(id);
		model.addAttribute("employe", employe);
		//model.addAttribute("ceq", ceq);
		Iterable<Congetype> listConges = entrepriseService.getConges();
		Congedemande congedemande = new Congedemande();
		congedemande.setId_employe(id);
		model.addAttribute("listConges", listConges);
		model.addAttribute("congedemande", congedemande);
		model.addAttribute("idemploy", id);
		
		
		return "demandeconge";
	}
	
	@PostMapping("/addDemandeConge")
	public ModelAndView addDemandeConge(@ModelAttribute Congedemande congedemande) {
		Random r = new Random();
		int low = 1;
		int high = 1000;
		int result = r.nextInt(high-low) + low;
		Congetype congetype = entrepriseService.getConge(congedemande.getCongetypecode());
		congedemande.setCongetypenom(congetype.getCongetypenom());
		congedemande.setId_congedemande(result);
		System.out.println(congedemande);
		Congedemande congedemandeDB = entrepriseService.saveCongedemande(congedemande);
		System.out.println(congedemandeDB);
		Conge conge = new Conge();
		
		conge.setId_congedemande(congedemandeDB.getId_congedemande());
		conge.setId_employe(congedemandeDB.getId_employe());
		conge.setCongetypecode(congedemandeDB.getCongetypecode());
		conge.setCongedate(congedemandeDB.getDatedebutconge());
		conge.setCongenbrejours(congetype.getNombrejours());
		conge.setCongestatus(1);
		//conge.setCongecommentaire(congedemandeDB.getCongecommentaire());
		System.out.println(conge);
		Conge congeDB = entrepriseService.saveConge(conge);
		System.out.println(congeDB);
		//employe.setDatedebut(LocalDate.now());
		//entrepriseService.saveEmploye(employe);
		return new ModelAndView("redirect:/congeUser/" + congedemande.getId_employe());	
	}
	
	
	@GetMapping("/recrutement")
	public String recrutement(Model model) {
		Iterable<Offre> listOffres = entrepriseService.getOffres();
		
		model.addAttribute("listOffres", listOffres);
		//model.addAttribute("congedemande", congedemande);
		//model.addAttribute("idemploy", id);
		
		
		return "recrutement";
	}
	
	@GetMapping("/addOffre")
	public String addOffre(Model model) {
		Offre newOffre = new Offre();
		Iterable<Poste> listPostes = entrepriseService.getPostes();
		model.addAttribute("newOffre", newOffre);
		model.addAttribute("listPostes", listPostes);
		//model.addAttribute("idemploy", id);
		
		
		return "addOffre";
	}
	
	@PostMapping("/addNewOffre")
	public ModelAndView addNewOffre(@ModelAttribute Offre offre) {
		offre.setStatus(1);
		LocalDate ld = java.time.LocalDate.now();
		offre.setDatedecreation(ld);
		//employe.setDatedebut(LocalDate.now());
		entrepriseService.saveOffre(offre);
		return new ModelAndView("redirect:/recrutement");	
	}
	
	
	@GetMapping("/deleteOffre/{id}")
	public ModelAndView deleteOffre(@PathVariable("id") final Integer id) {
		entrepriseService.deleteOffre(id);
		return new ModelAndView("redirect:/recrutement");		
	}
	
	@GetMapping("/postuler/{id}")
	public String postuler(Model model, @PathVariable("id") final Integer id) {
		Offre offre = entrepriseService.getOffre(id);
		System.out.println(offre);
		Candidat candidat = new Candidat();
		candidat.setStatus(id);
		model.addAttribute("offre", offre);
		model.addAttribute("candidat", candidat);
		model.addAttribute("idoff", id);
		
		
		return "postuler";
	}
	
	@PostMapping("/addNewCandidat")
	public ModelAndView addNewCandidat(@ModelAttribute Candidat candidat) {
		System.out.println(candidat);
		LocalDate ld = java.time.LocalDate.now();
		candidat.setDatedepostulation(ld);
		//employe.setDatedebut(LocalDate.now());
		Candidat newC = entrepriseService.saveCandidat(candidat);
		Historiquecandidatemploi hce = new Historiquecandidatemploi();
		hce.setId_offre(candidat.getStatus());
		System.out.println(candidat.getStatus());
		Offre offre = entrepriseService.getOffre(candidat.getStatus());
		hce.setId_candidat(newC.getId_candidat());
		hce.setNomoffre(offre.getNompostevacant());
		hce.setAction(1);
		hce.setDateaction(candidat.getDatedepostulation());
		entrepriseService.saveHistoriquecandidatemploi(hce);
		return new ModelAndView("redirect:/");	
	}
	
	@GetMapping("/showOffre/{id}")
	public String showOffre(Model model, @PathVariable("id") final Integer id) {
		Offre offre = entrepriseService.getOffre(id);
		Iterable<Candidat> listCandidats = entrepriseService.getCandidatsOffre(id);
		
		
		model.addAttribute("offre", offre);
		model.addAttribute("listCandidats", listCandidats);
		
		
		
		return "showOffre";
	}
	
	@GetMapping("/showCandidat/{id}")
	public String showCandidat(Model model, @PathVariable("id") final Integer id) {
		Candidat candidat = entrepriseService.getCandidat(id);
		
		Offre offre = entrepriseService.getOffre(candidat.getStatus());
		
		Iterable<Historiquecandidatemploi> listhce = entrepriseService.getHistoriquecandidatemploiOffreCandidat(id);
		Historiquecandidatemploi hcedernier = new Historiquecandidatemploi();
		for(Historiquecandidatemploi hce : listhce) {
			hcedernier = hce;
		}
		
		model.addAttribute("candidat", candidat);
		model.addAttribute("offre", offre);
		model.addAttribute("listhce", listhce);
		
			return "showCandidat";
		
	}
	
	@GetMapping("/preselectionner/{id}")
	public String preselectionner(Model model, @PathVariable("id") final Integer id) {
		Candidat candidat = entrepriseService.getCandidat(id);
		
		Offre offre = entrepriseService.getOffre(candidat.getStatus());
		
		//Iterable<Historiquecandidatemploi> listhce = entrepriseService.getHistoriquecandidatemploiOffreCandidat(id);
		
		
		model.addAttribute("candidat", candidat);
		model.addAttribute("offre", offre);
		model.addAttribute("idCandidat", id);
		//model.addAttribute("listhce", listhce);
		
		return "preselectionner";
	}
	
	@GetMapping("/embaucher/{id}")
	public String embaucher(Model model, @PathVariable("id") final Integer id) {
		Candidat candidat = entrepriseService.getCandidat(id);
		
		Offre offre = entrepriseService.getOffre(candidat.getStatus());
		
		//Iterable<Historiquecandidatemploi> listhce = entrepriseService.getHistoriquecandidatemploiOffreCandidat(id);
		Iterable<Historiquecandidatemploi> listhce = entrepriseService.getHistoriquecandidatemploiOffreCandidat(candidat.getId_candidat());
		Historiquecandidatemploi examplehce = listhce.iterator().next();
		/*Historiquecandidatemploi hce = new Historiquecandidatemploi();
		
		hce.setId_offre(examplehce.getId_offre());
		hce.setId_candidat(examplehce.getId_candidat());
		hce.setNomoffre(examplehce.getNomoffre());
		hce.setAction(4);
		LocalDate ld = java.time.LocalDate.now();
		hce.setDateaction(ld);
		entrepriseService.saveHistoriquecandidatemploi(hce);
		*/
		
		model.addAttribute("candidat", candidat);
		model.addAttribute("offre", offre);
		model.addAttribute("idCandidat", id);
		model.addAttribute("listhce", listhce);
		
		return "embaucher";
	}
	
	
	@GetMapping("/embaucherFinal/{id}")
	public String embaucherFinal(Model model, @PathVariable("id") final Integer id) {
		Candidat candidat = entrepriseService.getCandidat(id);
		
		Offre offre = entrepriseService.getOffre(candidat.getStatus());
		
		//Iterable<Historiquecandidatemploi> listhce = entrepriseService.getHistoriquecandidatemploiOffreCandidat(id);
		Iterable<Historiquecandidatemploi> listhce = entrepriseService.getHistoriquecandidatemploiOffreCandidat(candidat.getId_candidat());
		Historiquecandidatemploi examplehce = listhce.iterator().next();
		/**/Historiquecandidatemploi hce = new Historiquecandidatemploi();
		
		hce.setId_offre(examplehce.getId_offre());
		hce.setId_candidat(examplehce.getId_candidat());
		hce.setNomoffre(examplehce.getNomoffre());
		hce.setAction(4);
		LocalDate ld = java.time.LocalDate.now();
		hce.setDateaction(ld);
		entrepriseService.saveHistoriquecandidatemploi(hce);
		Iterable<Historiquecandidatemploi> listhceFinal = entrepriseService.getHistoriquecandidatemploiOffreCandidat(candidat.getId_candidat());
		
		
		model.addAttribute("candidat", candidat);
		model.addAttribute("offre", offre);
		model.addAttribute("idCandidat", id);
		model.addAttribute("listhce", listhceFinal);
		
		
		return "finalCandidat";
	}
	@GetMapping("/finalCandidat/{id}")
	public String finalCandidat(Model model, @PathVariable("id") final Integer id) {
		Candidat candidat = entrepriseService.getCandidat(id);
		
		Offre offre = entrepriseService.getOffre(candidat.getStatus());
		
		Iterable<Historiquecandidatemploi> listhce = entrepriseService.getHistoriquecandidatemploiOffreCandidat(id);
		
		
		model.addAttribute("candidat", candidat);
		model.addAttribute("offre", offre);
		model.addAttribute("idCandidat", id);
		model.addAttribute("listhce", listhce);
		
		return "finalCandidat";
	}
	
	
	@PostMapping("/addPasswordCandidat")
	public ModelAndView addPasswordCandidat(@ModelAttribute Candidat candidat) {
		entrepriseService.saveCandidat(candidat);
		Iterable<Historiquecandidatemploi> listhce = entrepriseService.getHistoriquecandidatemploiOffreCandidat(candidat.getId_candidat());
		Historiquecandidatemploi examplehce = listhce.iterator().next();
		Historiquecandidatemploi hce = new Historiquecandidatemploi();
		
		hce.setId_offre(examplehce.getId_offre());
		hce.setId_candidat(examplehce.getId_candidat());
		hce.setNomoffre(examplehce.getNomoffre());
		hce.setAction(2);
		LocalDate ld = java.time.LocalDate.now();
		hce.setDateaction(ld);
		entrepriseService.saveHistoriquecandidatemploi(hce);
		
		
		
		return new ModelAndView("redirect:/embaucher/" + candidat.getId_candidat());	
	}
	
	
	@GetMapping("/refuserCandidat/{id}")
	public ModelAndView refuserCandidat(Model model, @PathVariable("id") final Integer id) {
		Candidat candidat = entrepriseService.getCandidat(id);
		Iterable<Historiquecandidatemploi> listhce = entrepriseService.getHistoriquecandidatemploiOffreCandidat(candidat.getId_candidat());
		Historiquecandidatemploi examplehce = listhce.iterator().next();
		Historiquecandidatemploi hce = new Historiquecandidatemploi();
		
		hce.setId_offre(examplehce.getId_offre());
		hce.setId_candidat(examplehce.getId_candidat());
		hce.setNomoffre(examplehce.getNomoffre());
		hce.setAction(3);
		LocalDate ld = java.time.LocalDate.now();
		hce.setDateaction(ld);
		entrepriseService.saveHistoriquecandidatemploi(hce);
		
		return new ModelAndView("redirect:/showCandidat/" + candidat.getId_candidat());	
	}
	
	@GetMapping("/candidatAccount/{id}")
	public String candidatAccount(Model model, @PathVariable("id") final Integer id) {
		Candidat candidat = entrepriseService.getCandidat(id);
		
		Offre offre = entrepriseService.getOffre(candidat.getStatus());
		
		Iterable<Historiquecandidatemploi> listhce = entrepriseService.getHistoriquecandidatemploiOffreCandidat(id);
		
		
		model.addAttribute("candidat", candidat);
		model.addAttribute("offre", offre);
		model.addAttribute("listhce", listhce);
		
		return "candidatAccount";
	}
}
