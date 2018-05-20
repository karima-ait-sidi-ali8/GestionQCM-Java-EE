package fr.insset.gestionQCM.presentation;


import java.io.Serializable;

import java.util.List;


import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

import javax.faces.bean.ManagedBean;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.insset.gestionQCM.dao.entity.Auteur;

import fr.insset.gestionQCM.dao.entity.Groupe;

import fr.insset.gestionQCM.metier.UserMetier;

import fr.insset.gestionQCM.utils.SessionUtil;





@ManagedBean
@SessionScoped
public class HomeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	public Logger log = Logger.getLogger(UserBean.class);


	private Integer idUser;

	
	private List<Groupe> listeGroupes ; 
	


	
	public HomeBean() {
		super();
	}

	
	@PostConstruct
	public void initBean(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"config/config.xml"});
		UserMetier metier = (UserMetier) context.getBean("metier"); 

		context.close();
		
		HttpSession hs = SessionUtil.getSession();
		this.idUser = (Integer) hs.getAttribute("idUser");


		Auteur a = metier.getAuteur(idUser);
		listeGroupes = a.getListGroupes();

	}


	public List<Groupe> getListeGroupes() {
		return listeGroupes;
	}


	public void setListeGroupes(List<Groupe> listeGroupes) {
		this.listeGroupes = listeGroupes;
	}







}







