package fr.insset.gestionQCM.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "etudiant", catalog = "qcm_db")
public class Etudiant extends Utilisateur {

	private static final long serialVersionUID = 1L;

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiant(String nom, String prenom, String password, String email) {
		super(nom, prenom, password, email);
		// TODO Auto-generated constructor stub
	}
	
	

}
