package fr.insset.gestionQCM.presentation;

import java.io.Serializable;
import java.util.Date;


import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.insset.gestionQCM.metier.GroupeMetier;





@ManagedBean(name="UserLogin")
@RequestScoped
public class GroupeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	public Logger log = Logger.getLogger(UserBean.class);
	private String NomGroupe;
	private Date dateCreation;
	
	private int idUser;

	private GroupeMetier metier;
	public GroupeBean() {
		super();
	}

	
	@PostConstruct
	public void initBean(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"config/config.xml"});
		GroupeMetier metier = (GroupeMetier) context.getBean("groupeMetier"); 
		this.metier = metier;
		context.close();
		
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
	

	
	

}
