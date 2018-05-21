package fr.insset.gestionQCM.presentation;


import java.io.IOException;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import fr.insset.gestionQCM.dao.entity.Auteur;

import fr.insset.gestionQCM.dao.entity.Groupe;
import fr.insset.gestionQCM.dao.entity.Qcm;
import fr.insset.gestionQCM.dao.entity.SessionEntity;
import fr.insset.gestionQCM.metier.GroupeMetier;
import fr.insset.gestionQCM.metier.QcmMetier;
import fr.insset.gestionQCM.metier.SessionMetier;
import fr.insset.gestionQCM.metier.UserMetier;
import fr.insset.gestionQCM.utils.ContextUtil;
import fr.insset.gestionQCM.utils.SessionUtil;





@ManagedBean
@SessionScoped
public class HomeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	public Logger log = Logger.getLogger(UserBean.class);


	private Integer idUser;

	
	private List<Groupe> listeGroupes ; 
	
	private List<SelectItem> ListQcmItem;
	
	private List<SelectItem> ListGroupesItem;

	private Date dateDeb;
	
	private Date dateFin;
	
	private String showReslt;
	
	private String nbTent;
	
	private String choixQcm;
	
	private Date time;

	
	public HomeBean() {
		super();
	}

	
	@PostConstruct
	public void initBean(){
		showReslt= "true";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"config/config.xml"});
		UserMetier metier = (UserMetier) context.getBean("metier"); 

		context.close();
		
		HttpSession hs = SessionUtil.getSession();
		this.idUser = (Integer) hs.getAttribute("idUser");


		Auteur a = metier.getAuteur(idUser);
		listeGroupes = a.getListGroupes();
		
		ListQcmItem = new ArrayList<>();
		
		Auteur auteur = metier.getAuteur(idUser);
		List<Qcm> listQcms = auteur.getQcms();
		for(Qcm q:listQcms){
			ListQcmItem.add(new SelectItem(q.getId(),q.getTitre()));
		}
		

	}

	public void addSession() throws IOException{

		if(!dateFin.before(dateDeb) && dateFin.getTime()-dateDeb.getTime()>= time.getTime()){
			

		SessionMetier metier = (SessionMetier) ContextUtil.getContext().getBean("SessionMetier"); 
		ContextUtil.getContext().close();
		SessionEntity s = new SessionEntity();
		s.setDateDeb(dateDeb);
		s.setDateFin(dateFin);
		s.setDuree(time);
		s.setNbEssai(Integer.parseInt(nbTent));
		s.setIdQcm(Integer.valueOf(choixQcm));
		s.setShowResult(Boolean.valueOf(showReslt));
		metier.add_Session(s);
		initBean();
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
		}
		else{
			FacesContext.getCurrentInstance().addMessage("msgbean", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur !", "Date est invalide."));

		}
	}

	public void addQcmToGroupe(){
	
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, String> param = ec.getRequestParameterMap(); 
		QcmMetier metier = (QcmMetier) ContextUtil.getContext().getBean("qcmMetier"); 
		ContextUtil.getContext().close();
		
		boolean verif = metier.isAffect(Integer.valueOf(choixQcm), Integer.valueOf(param.get("idGroupe")));
		
		if(!verif){
			GroupeMetier metierGroupe = (GroupeMetier) ContextUtil.getContext().getBean("groupeMetier"); 
			ContextUtil.getContext().close();
			Groupe g = metierGroupe.findById(Integer.valueOf(param.get("idGroupe")));
			metier.AffectQcmToGroupe(Integer.valueOf(choixQcm), g);
			initBean();
			
		}
		

	}
	public List<Groupe> getListeGroupes() {
		return listeGroupes;
	}


	public void setListeGroupes(List<Groupe> listeGroupes) {
		this.listeGroupes = listeGroupes;
	}




	public Date getDateDeb() {
		return dateDeb;
	}


	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	public String getShowReslt() {
		return showReslt;
	}


	public void setShowReslt(String showReslt) {
		this.showReslt = showReslt;
	}


	public String getNbTent() {
		return nbTent;
	}


	public void setNbTent(String nbTent) {
		this.nbTent = nbTent;
	}


	public List<SelectItem> getListQcmItem() {
		return ListQcmItem;
	}


	public void setListQcmItem(List<SelectItem> listQcmItem) {
		ListQcmItem = listQcmItem;
	}


	public List<SelectItem> getListGroupesItem() {
		return ListGroupesItem;
	}


	public void setListGroupesItem(List<SelectItem> listGroupesItem) {
		ListGroupesItem = listGroupesItem;
	}


	public String getChoixQcm() {
		return choixQcm;
	}


	public void setChoixQcm(String choixQcm) {
		this.choixQcm = choixQcm;
	}


	public Date getTime() {
		return time;
	}


	public void setTime(Date time) {
		this.time = time;
	}







}







