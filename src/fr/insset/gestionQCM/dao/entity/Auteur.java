package fr.insset.gestionQCM.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "auteur", catalog = "qcm_db")
public class Auteur extends Utilisateur {

	private static final long serialVersionUID = 1L;

	public Auteur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Auteur(String nom, String prenom, String password, String email) {
		super(nom, prenom, password, email);
		// TODO Auto-generated constructor stub
	}

	
}
