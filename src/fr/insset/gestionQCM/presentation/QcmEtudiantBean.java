package fr.insset.gestionQCM.presentation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;



import fr.insset.gestionQCM.dao.entity.Groupe;
import fr.insset.gestionQCM.dao.entity.Qcm;

import fr.insset.gestionQCM.dao.entity.SessionEntity;
import fr.insset.gestionQCM.metier.GroupeMetier;
import fr.insset.gestionQCM.utils.ContextUtil;
import fr.insset.gestionQCM.utils.SessionUtil;


//QCMs list for each groupe
@ManagedBean (name="qcmEtudiantBean")
@SessionScoped
public class QcmEtudiantBean implements Serializable{


	private static final long serialVersionUID = 1L;



	private GroupeMetier metier;	
	private List<Qcm> listeQcms ; 
	private List<SessionEntity> listeSessions;
	private int  nbQcms;
	private int  nbSessions;
	private String nomGroupe;
	private String etat;
	private Date aujourdui;
	private String ColorEtat;
	 
	
		
	
	public QcmEtudiantBean() {
		super();
	}
	

	
	public void QcmAjax(){
		GroupeMetier metier = (GroupeMetier) ContextUtil.getContext().getBean("groupeMetier");
		ContextUtil.getContext().close();
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, String> param = ec.getRequestParameterMap(); 
		HttpSession hs = SessionUtil.getSession();
		
		hs.setAttribute("idGroupe", Integer.valueOf(param.get("idgrp")));
		hs.setAttribute("NomGroupe", param.get("Nomgrp"));
		
		Groupe g = metier.findById(Integer.valueOf(param.get("idgrp")));
		nomGroupe = param.get("Nomgrp");
		setEtat("Fermé");
		setColorEtat("danger");
		
		
		aujourdui = new Date();
		listeQcms = g.getListQcms();
		nbQcms = listeQcms.size();
		
		for (Qcm qcm : listeQcms) {
				listeSessions = qcm.getSessions();
				nbSessions = listeSessions.size();	
				for (SessionEntity session : listeSessions)
				{
					if(aujourdui.before(session.getDateFin()))
					{
						setEtat("Ouvert");
						setColorEtat("success");
					}
				}
		}
		
		
	}
	
	public GroupeMetier getMetier() {
		return metier;
	}
	public void setMetier(GroupeMetier metier) {
		this.metier = metier;
	}
	
	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	public List<Qcm> getListeQcms() {
		return listeQcms;
	}

	public void setListeQcms(List<Qcm> listeQcms) {
		this.listeQcms = listeQcms;
	}

	public int getNbQcms() {
		return nbQcms;
	}

	public void setNbQcms(int nbQcms) {
		this.nbQcms = nbQcms;
	}

	public List<SessionEntity> getListeSessions() {
		return listeSessions;
	}

	public void setListeSessions(List<SessionEntity> listeSessions) {
		this.listeSessions = listeSessions;
	}

	public int getNbSessions() {
		return nbSessions;
	}

	public void setNbSessions(int nbSessions) {
		this.nbSessions = nbSessions;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getColorEtat() {
		return ColorEtat;
	}

	public void setColorEtat(String colorEtat) {
		ColorEtat = colorEtat;
	}

	

}
