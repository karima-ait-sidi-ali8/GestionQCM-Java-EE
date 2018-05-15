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
	


}







