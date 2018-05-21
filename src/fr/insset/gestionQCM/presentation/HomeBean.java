package fr.insset.gestionQCM.presentation;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import fr.insset.gestionQCM.dao.entity.Auteur;

import fr.insset.gestionQCM.dao.entity.Groupe;
import fr.insset.gestionQCM.dao.entity.Qcm;
import fr.insset.gestionQCM.metier.GroupeMetier;
import fr.insset.gestionQCM.metier.QcmMetier;
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

	private String dateDeb;
	
	private String dateFin;
	
	private String showReslt;
	
	private String nbTent;
	
	private String choixQcm;

	
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
		
		ListQcmItem = new ArrayList<>();
		
		Auteur auteur = metier.getAuteur(idUser);
		List<Qcm> listQcms = auteur.getQcms();
		for(Qcm q:listQcms){
			ListQcmItem.add(new SelectItem(q.getId(),q.getTitre()));
		}
		

	}

	public void addSession(){
		System.out.println(dateDeb);
		System.out.println(dateFin);
		System.out.println(showReslt);
		System.out.println(nbTent);
	}

	public void addQcmToGroupe(){
		System.out.println(choixQcm);
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


	public String getDateDeb() {
		return dateDeb;
	}


	public void setDateDeb(String dateDeb) {
		this.dateDeb = dateDeb;
	}


	public String getDateFin() {
		return dateFin;
	}


	public void setDateFin(String dateFin) {
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







}







