package fr.insset.gestionQCM.presentation;



import java.io.Serializable;
import java.util.List;



import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;


import javax.faces.bean.SessionScoped;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import fr.insset.gestionQCM.dao.entity.Auteur;

import fr.insset.gestionQCM.dao.entity.Qcm;

import fr.insset.gestionQCM.metier.UserMetier;
import fr.insset.gestionQCM.utils.ContextUtil;
import fr.insset.gestionQCM.utils.SessionUtil;




@ManagedBean
@SessionScoped
public class QcmAuteurBean implements Serializable {

	private static final long serialVersionUID = 1L;
	public Logger log = Logger.getLogger(UserBean.class);

	
	private List<Qcm> ListeQcms;
	
	private String titre = "Conformité stricte avec pénalité";
	
	private String type;
	
	private String description = "- Téléphone interdit - Documents interdits.";


	
	public QcmAuteurBean() {
		super();
	}


	 
	@PostConstruct
	public void initBean(){


		HttpSession hs = SessionUtil.getSession();
		
		UserMetier metier = (UserMetier) ContextUtil.getContext().getBean("metier"); 
		ContextUtil.getContext().close();
		
		Auteur auteur = (Auteur) metier.finByOne((Integer) hs.getAttribute("idUser"));
	
		ListeQcms = auteur.getQcms();
		
		

	}



	public List<Qcm> getListeQcms() {
		return ListeQcms;
	}



	public void setListeQcms(List<Qcm> listeQcms) {
		ListeQcms = listeQcms;
	}



	public String getTitre() {
		return titre;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}
	
	


}







