package fr.insset.gestionQCM.presentation;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.insset.gestionQCM.dao.entity.Etudiant;
import fr.insset.gestionQCM.dao.entity.Groupe;
import fr.insset.gestionQCM.metier.UserMetier;
import fr.insset.gestionQCM.utils.SessionUtil;

@ManagedBean (name = "etudiantBean")
@SessionScoped
public class EtudiantBean {

	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	public Logger log = Logger.getLogger(UserBean.class);

	private Integer idUser;
	
	private UserMetier metier;	 
	
	private List<Groupe> listeGroupesEtudiant ;
	
	private List<Groupe> lastListeGroupesEtudiant ;
	
	private String username;
	
	private int  nbGroupesEtudiant;
			
	public EtudiantBean() {
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

		Etudiant e = metier.getEtudiant(idUser);
		
		listeGroupesEtudiant = e.getListGroupes();
		if(!listeGroupesEtudiant.isEmpty())
		{
		
			lastListeGroupesEtudiant = listeGroupesEtudiant;
			nbGroupesEtudiant = listeGroupesEtudiant.size();
		
		}

	}


	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
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


	public List<Groupe> getListeGroupesEtudiant() {
		return listeGroupesEtudiant;
	}


	public void setListeGroupesEtudiant(List<Groupe> listeGroupesEtudiant) {
		this.listeGroupesEtudiant = listeGroupesEtudiant;
	}


	public int getNbGroupesEtudiant() {
		return nbGroupesEtudiant;
	}


	public void setNbGroupesEtudiant(int nbGroupesEtudiant) {
		this.nbGroupesEtudiant = nbGroupesEtudiant;
	}


	public List<Groupe> getLastListeGroupesEtudiant() {
		return lastListeGroupesEtudiant;
	}


	public void setLastListeGroupesEtudiant(List<Groupe> lastListeGroupesEtudiant) {
		this.lastListeGroupesEtudiant = lastListeGroupesEtudiant;
	}
	
}
