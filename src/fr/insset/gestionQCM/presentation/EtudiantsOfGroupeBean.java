package fr.insset.gestionQCM.presentation;


import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.RequestScoped;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


import fr.insset.gestionQCM.dao.entity.Etudiant;
import fr.insset.gestionQCM.dao.entity.Groupe;
import fr.insset.gestionQCM.dao.entity.Utilisateur;
import fr.insset.gestionQCM.metier.GroupeMetier;
import fr.insset.gestionQCM.metier.UserMetier;
import fr.insset.gestionQCM.utils.ContextUtil;
import fr.insset.gestionQCM.utils.SessionUtil;




@ManagedBean(name="etudiants")
@RequestScoped
public class EtudiantsOfGroupeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	public Logger log = Logger.getLogger(UserBean.class);

	
	private List<Etudiant> ListeEtudiants;

	private String nomGroupe;
	
	private String email;
	
	private boolean chat = true;
	
	public EtudiantsOfGroupeBean() {
		super();
	}

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

		public static boolean validate(String emailStr) {
		        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
		        return matcher.find();
		}
	 
	@PostConstruct
	public void initBean(){
		chat = true;
		
		GroupeMetier metier = (GroupeMetier) ContextUtil.getContext().getBean("groupeMetier"); 
		ContextUtil.getContext().close();
		HttpSession hs = SessionUtil.getSession();
		
		nomGroupe = (String) hs.getAttribute("NomGroupe");
		
		Groupe gp = metier.findById((Integer) hs.getAttribute("idGroupe"));
	
		ListeEtudiants = gp.getListOfEtudiants();
		
		

	}
	
	public boolean searchEtudiant(String emailEtudiant){
		for(int i=0; i< ListeEtudiants.size(); i++){
			if( ListeEtudiants.get(i).getEmail().equals(emailEtudiant)) return true;
		}
		
		return false;
	}


	public void AddEtudiantToGroupe(){
		
		if(email.trim().isEmpty() || !validate(email)){
			FacesContext.getCurrentInstance().addMessage("AjoutDetail", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur !", "Adresse mail est invalide !."));
		} else if(isEtudiant(email)){
			
			if(isMembre(email)){
				
				FacesContext.getCurrentInstance().addMessage("AjoutDetail", new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur!", "l'étudiant existe déjà !."));
			}
			else{
				addMembre();
			}
			
			
		}		
			
		else{
			FacesContext.getCurrentInstance().addMessage("AjoutDetail", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Il n'y a pas un étudiant avec cette adresse email."));
		}
	
		

		
		
		
	}// end of function
	
	public void DeleteEtuFromGroupe() throws IOException{
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, String> param = ec.getRequestParameterMap(); 
		GroupeMetier metierGr = (GroupeMetier) ContextUtil.getContext().getBean("groupeMetier"); 
		ContextUtil.getContext().close();
		HttpSession hs = SessionUtil.getSession();
		metierGr.deleteEtudiant(Integer.valueOf(param.get("idEtudiant")), (Integer) hs.getAttribute("idGroupe"));
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isEtudiant(String email){
		UserMetier metier = (UserMetier) ContextUtil.getContext().getBean("metier"); 
		ContextUtil.getContext().close();
		
		
		boolean verif = metier.findbyAdresse(email);
		if(verif){
			Utilisateur u  = (Utilisateur) metier.getByAdresse(email);
			return metier.isEtudiant((Integer)u.getIdUser());
		}
	
		
		return false;
		
	}




	public boolean isMembre(String email){
		HttpSession hs = SessionUtil.getSession();
		UserMetier metier = (UserMetier) ContextUtil.getContext().getBean("metier"); 
		ContextUtil.getContext().close();
		Etudiant etu = (Etudiant) metier.getByAdresse(email);
		GroupeMetier metierGp = (GroupeMetier) ContextUtil.getContext().getBean("groupeMetier"); 
		ContextUtil.getContext().close();
		
		return metierGp.isMembre((Integer)etu.getIdUser(), (Integer) hs.getAttribute("idGroupe"));
		
		
	}

	public void addMembre(){
		HttpSession hs = SessionUtil.getSession();
		UserMetier metier = (UserMetier) ContextUtil.getContext().getBean("metier"); 
		ContextUtil.getContext().close();
		
		GroupeMetier metierGp = (GroupeMetier) ContextUtil.getContext().getBean("groupeMetier"); 
		ContextUtil.getContext().close();
		
		
		metierGp.addEtudiant((Etudiant)metier.getByAdresse(email), (Integer) hs.getAttribute("idGroupe"));
		FacesContext.getCurrentInstance().addMessage("AjoutDetail", new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès !", "L'étudiant à été ajouté avec succès."));

		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("groupetudiantlist.xhtml");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().responseComplete();
	}

	public boolean isChat() {
		return chat;
	}

	public void setChat(boolean chat) {
		this.chat = chat;
	}

	public void UpdateChatAuth(){
		System.out.println(chat);
	}
	
	

}







