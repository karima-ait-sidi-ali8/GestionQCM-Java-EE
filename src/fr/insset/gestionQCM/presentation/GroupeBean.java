package fr.insset.gestionQCM.presentation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.insset.gestionQCM.dao.entity.Auteur;
import fr.insset.gestionQCM.dao.entity.Groupe;
import fr.insset.gestionQCM.metier.UserMetier;
import fr.insset.gestionQCM.utils.SessionUtil;





@ManagedBean
@ViewScoped
public class GroupeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	public Logger log = Logger.getLogger(UserBean.class);
	private String NomGroupe;
	private Date dateCreation;
	
	private Integer idUser;
	
	private UserMetier metier;
	
	private List<Groupe> listeGroupes ; 
	
	private String username;


	public GroupeBean() {
		super();
	}

	
	@PostConstruct
	public void initBean(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"config/config.xml"});
		UserMetier metier = (UserMetier) context.getBean("metier"); 
		this.setMetier(metier);
		context.close();
		
		HttpSession hs = SessionUtil.getSession();
		this.idUser = (Integer) hs.getAttribute("idUser");
		this.username = (String) hs.getAttribute("username");
		Auteur a = metier.getAuteur(idUser);
		
		listeGroupes = a.getListGroupes();
	}


	public String getNomGroupe() {
		return NomGroupe;
	}


	public void setNomGroupe(String nomGroupe) {
		NomGroupe = nomGroupe;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	public List<Groupe> getListeGroupes() {
		return listeGroupes;
	}


	public void setListeGroupes(List<Groupe> listeGroupes) {
		this.listeGroupes = listeGroupes;
	}


	public UserMetier getMetier() {
		return metier;
	}


	public void setMetier(UserMetier metier) {
		this.metier = metier;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	

	
	
	

}
