package fr.insset.gestionQCM.presentation;



import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;


import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import fr.insset.gestionQCM.dao.entity.Auteur;

import fr.insset.gestionQCM.dao.entity.Qcm;
import fr.insset.gestionQCM.metier.QcmMetier;
import fr.insset.gestionQCM.metier.UserMetier;
import fr.insset.gestionQCM.utils.ContextUtil;
import fr.insset.gestionQCM.utils.SessionUtil;




@ManagedBean
@SessionScoped
public class QcmAuteurBean implements Serializable {

	private static final long serialVersionUID = 1L;
	public Logger log = Logger.getLogger(UserBean.class);

	
	private List<Qcm> ListeQcms;
	
	private String titre ;
	
	private String type = "Conformité stricte avec pénalité";
	
	private String description = "- Téléphone interdit - Documents interdits.";


	
	public QcmAuteurBean() {
		super();
	}


	 
	@PostConstruct
	public void initBean(){


		HttpSession hs = SessionUtil.getSession();
		
		UserMetier metier = (UserMetier) ContextUtil.getContext().getBean("metier"); 
		ContextUtil.getContext().close();
		
		Auteur auteur = (Auteur) metier.finByOne((Integer) hs.getAttribute("idUser"));
	
		ListeQcms = auteur.getQcms();
		
		

	}

	public void addQcm() throws IOException{
		HttpSession hs = SessionUtil.getSession();
		QcmMetier metier = (QcmMetier) ContextUtil.getContext().getBean("qcmMetier"); 
		ContextUtil.getContext().close();
		Qcm qcm = new Qcm();
		if(!"".equalsIgnoreCase(description)) qcm.setDescription(description);
		qcm.setTitre(titre);
		qcm.setIdAuteur((Integer) hs.getAttribute("idUser"));
		qcm.setType(type);
		metier.addQcm(qcm);
		initBean();
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}
	
	public void deleteQcm() throws IOException{
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, String> param = ec.getRequestParameterMap(); 
		
		QcmMetier metier = (QcmMetier) ContextUtil.getContext().getBean("qcmMetier"); 
		ContextUtil.getContext().close();
		metier.deleteQcm(Integer.valueOf(param.get("idQcm")));
		initBean();
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
		
	}

	public List<Qcm> getListeQcms() {
		return ListeQcms;
	}



	public void setListeQcms(List<Qcm> listeQcms) {
		ListeQcms = listeQcms;
	}



	public String getTitre() {
		return titre;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}
	
	


}







