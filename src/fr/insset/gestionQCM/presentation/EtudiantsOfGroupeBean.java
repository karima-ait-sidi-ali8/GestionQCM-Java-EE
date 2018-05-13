package fr.insset.gestionQCM.presentation;


import java.io.Serializable;
import java.util.List;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.RequestScoped;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.insset.gestionQCM.dao.entity.Etudiant;
import fr.insset.gestionQCM.dao.entity.Groupe;
import fr.insset.gestionQCM.metier.GroupeMetier;
import fr.insset.gestionQCM.utils.ContextUtil;
import fr.insset.gestionQCM.utils.SessionUtil;




@ManagedBean(name="etudiants")
@RequestScoped
public class EtudiantsOfGroupeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	public Logger log = Logger.getLogger(UserBean.class);

	
	private List<Etudiant> ListeEtudiants;

	private String nomGroupe;
	
	public EtudiantsOfGroupeBean() {
		super();
	}

	
	@PostConstruct
	public void initBean(){

		
		GroupeMetier metier = (GroupeMetier) ContextUtil.getContext().getBean("groupeMetier"); 
		ContextUtil.getContext().close();
		HttpSession hs = SessionUtil.getSession();
		
		nomGroupe = (String) hs.getAttribute("NomGroupe");
		
		Groupe gp = metier.findById((Integer) hs.getAttribute("idGroupe"));
	
		ListeEtudiants = gp.getListOfEtudiants();
		
		

	}



	public List<Etudiant> getListeEtudiants() {
		return ListeEtudiants;
	}


	public void setListeEtudiants(List<Etudiant> listeEtudiants) {
		ListeEtudiants = listeEtudiants;
	}


	public String getNomGroupe() {
		return nomGroupe;
	}


	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}










}







