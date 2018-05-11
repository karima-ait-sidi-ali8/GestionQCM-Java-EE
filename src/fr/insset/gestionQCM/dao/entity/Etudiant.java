package fr.insset.gestionQCM.dao.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "etudiant", catalog = "qcm_db")
public class Etudiant extends Utilisateur {

	private static final long serialVersionUID = 1L;
	
	
	
	private List<Groupe>listGroupes;

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiant(String nom, String prenom, String password, String email) {
		super(nom, prenom, password, email);
		// TODO Auto-generated constructor stub
	}

	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="membre_groupe",
	joinColumns={@JoinColumn(name="id_user")}, inverseJoinColumns={@JoinColumn(name="id_groupe")})
	public List<Groupe> getListGroupes() {
		return listGroupes;
	}

	public void setListGroupes(List<Groupe> listGroupes) {
		this.listGroupes = listGroupes;
	}

	

	

}
