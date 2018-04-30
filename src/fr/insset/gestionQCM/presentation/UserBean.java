package fr.insset.gestionQCM.presentation;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.insset.gestionQCM.dao.entity.Utilisateur;
import fr.insset.gestionQCM.metier.UserMetier;




@ManagedBean(name="UserLogin")
@RequestScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	public Logger log = Logger.getLogger(UserBean.class);
	private String email;
	private String password;
	private String nom;
	private String prenom;

	private UserMetier metier;
	public UserBean() {
		super();
	}

	
	@PostConstruct
	public void initBean(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"config/config.xml"});
		UserMetier metier = (UserMetier) context.getBean("metier"); 
		this.metier = metier;
		context.close();
		
	}
	

	public void etudiantAuthenticate(){
		if("".equalsIgnoreCase(email) || "".equalsIgnoreCase(password)){
			FacesContext.getCurrentInstance().addMessage("auth", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Login ou Mot de passe ne doivent pas être vides"));	
		}
		else {
			List<Utilisateur> listUser = metier.getStatus(email, password);
			if(listUser.isEmpty())
				FacesContext.getCurrentInstance().addMessage("auth", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Login ou Mot de passe sont incorrectes."));
			
			else{
				
				Boolean  isEtudiant =	metier.findbyAdresseAndRole(listUser.get(0).getEmail(), "etudiant");
				if(!isEtudiant){
					FacesContext.getCurrentInstance().addMessage("auth", new FacesMessage(FacesMessage.SEVERITY_INFO, "Done !", "Cette adresse email est enregistrée"
							+ " avec un compte AUTEUR. Inscrivez-vous en tant que auteur ou bien vérifiez votre adesse email si vous vous êtes trompé"));
				}
				else
					FacesContext.getCurrentInstance().addMessage("auth", new FacesMessage(FacesMessage.SEVERITY_INFO, "Done !", "Connecté."));
			}
			
		}	

	}
	
	public void auteurAuthenticate(){
		if("".equalsIgnoreCase(email) || "".equalsIgnoreCase(password)){
			FacesContext.getCurrentInstance().addMessage("auth", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Login ou Mot de passe ne doivent pas être vides"));	
		}
		else {
			List<Utilisateur> listUser = metier.getStatus(email, password);
			if(listUser.isEmpty())
				FacesContext.getCurrentInstance().addMessage("auth", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Login ou Mot de passe sont incorrectes."));
			
			else{
				
				Boolean  isAuteur =	metier.findbyAdresseAndRole(listUser.get(0).getEmail(), "auteur");
				if(!isAuteur){
					FacesContext.getCurrentInstance().addMessage("auth", new FacesMessage(FacesMessage.SEVERITY_INFO, "Done !", "Cette adresse email est enregistrée"
							+ " avec un compte AUTEUR. Inscrivez-vous en tant que étudiant ou bien vérifiez votre adesse email si vous vous êtes trompé"));
				}
				else
					FacesContext.getCurrentInstance().addMessage("auth", new FacesMessage(FacesMessage.SEVERITY_INFO, "Done !", "Connecté."));
			}
			
		}	
	}
	
	public void inscriptionEtudiant(){
		
		boolean isEtudiant = metier.findbyAdresseAndRole(email, "etudiant");
		
		if(isEtudiant) 
			FacesContext.getCurrentInstance().addMessage("inscri", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Il exite déjà un compte étudiant avec cette adresse email."));
		else {
			Utilisateur u = new Utilisateur(nom,prenom,password,email);
			metier.addUser(u, "etudiant");
			
		}
		

	}
	
	public void inscriptionAuteur(){

		boolean isAuetur = metier.findbyAdresseAndRole(email, "auteur");
		
		if(isAuetur) 
			FacesContext.getCurrentInstance().addMessage("inscri", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Il exite déjà un compte auteur avec cette adresse email."));
		else {
			Utilisateur u = new Utilisateur(nom,prenom,password,email);
			metier.addUser(u, "auteur");
			
		}
	}
	





	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Logger getLog() {
		return log;
	}
	public void setLog(Logger log) {
		this.log = log;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	

}
