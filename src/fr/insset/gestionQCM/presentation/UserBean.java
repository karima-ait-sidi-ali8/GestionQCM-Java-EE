package fr.insset.gestionQCM.presentation;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.insset.gestionQCM.dao.entity.Auteur;
import fr.insset.gestionQCM.dao.entity.Etudiant;
import fr.insset.gestionQCM.dao.entity.Utilisateur;
import fr.insset.gestionQCM.metier.UserMetier;
import fr.insset.gestionQCM.utils.SessionUtil;




@ManagedBean(name="UserLogin")
@SessionScoped
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
				
				Boolean  isEtudiant =	metier.isEtudiant((listUser.get(0).getIdUser()));
				if(!isEtudiant){
					FacesContext.getCurrentInstance().addMessage("auth", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Login ou Mot de passe sont incorrectes."));

				}
				else {
				String username=listUser.get(0).getPrenom()+" "+listUser.get(0).getNom();
				Integer idUser = new Integer(listUser.get(0).getIdUser());
				
				HttpSession hs = SessionUtil.getSession();
				hs.setAttribute("username", username);
				hs.setAttribute("idUser", idUser);
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("Etudiant/QCM.xhtml");
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				FacesContext.getCurrentInstance().responseComplete();
			}
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
				Boolean  isAuteur =	metier.isAuteur(listUser.get(0).getIdUser());
				
				if(!isAuteur){
					FacesContext.getCurrentInstance().addMessage("auth", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Login ou Mot de passe sont incorrectes."));
				}
				else{
					String username=listUser.get(0).getPrenom()+" "+listUser.get(0).getNom();
					Integer idUser = new Integer(listUser.get(0).getIdUser());
					System.out.println(idUser+" "+username);
					HttpSession hs = SessionUtil.getSession();
					hs.setAttribute("username", username);
					hs.setAttribute("idUser", idUser);
					try {
						FacesContext.getCurrentInstance().getExternalContext().redirect("auteurHome.xhtml");
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					FacesContext.getCurrentInstance().responseComplete();
				}
			}
			
		}
	
	}
	
	public void inscriptionEtudiant(){
		
		boolean isEtudiant = metier.findbyAdresse(email);
		
		if(isEtudiant) 
			FacesContext.getCurrentInstance().addMessage("inscri", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Il exite déjà un compte avec cette adresse email."));
		else {
			Etudiant e = new Etudiant(nom,prenom,password,email);
			metier.addEtudiant(e);
			initAll();
			FacesContext.getCurrentInstance().addMessage("success", new FacesMessage(FacesMessage.SEVERITY_INFO, "Success !", "votre inscription a été enregistrée avec succès."));
			
			
		}
		

	}
	
	public void inscriptionAuteur(){

		boolean isAuetur = metier.findbyAdresse(email);
		
		if(isAuetur) 
			FacesContext.getCurrentInstance().addMessage("inscri", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Il exite déjà un compte avec cette adresse email."));
		else {
			Auteur a = new Auteur(nom,prenom,password,email);
			metier.addAuteur(a);
			initAll();
			FacesContext.getCurrentInstance().addMessage("success", new FacesMessage(FacesMessage.SEVERITY_INFO, "Success !", "votre inscription a été enregistrée avec succès."));
		}
	}
	
	public void initAll(){
		
		this.nom = "";
		this.prenom = "";
		this.email = "";
		this.password = "";
		
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


	public UserMetier getMetier() {
		return metier;
	}


	public void setMetier(UserMetier metier) {
		this.metier = metier;
	}
	

	

}
