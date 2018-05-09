package fr.insset.gestionQCM.dao.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "auteur", catalog = "qcm_db")
public class Auteur extends Utilisateur {

	private static final long serialVersionUID = 1L;
	
	private List<Groupe> listGroupes;
	
	private List<Qcm> qcms = new ArrayList<Qcm>();
	
	public Auteur() {
		super();
		
	}

	public Auteur(String nom, String prenom, String password, String email) {
		super(nom, prenom, password, email);
		
	}

	
	
	@OneToMany(targetEntity=Groupe.class, mappedBy="auteur",  fetch=FetchType.LAZY)
	public List<Groupe> getListGroupes() {
		return listGroupes;
	}

	public void setListGroupes(List<Groupe> listGroupes) {
		this.listGroupes = listGroupes;
	}

	@OneToMany(targetEntity=Qcm.class, mappedBy="auteur", fetch=FetchType.LAZY)
	public List<Qcm> getQcms() {
		return qcms;
	}

	public void setQcms(List<Qcm> qcms) {
		this.qcms = qcms;
	}
	


	
	
	
	
	
}
