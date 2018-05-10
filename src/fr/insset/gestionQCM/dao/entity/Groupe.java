package fr.insset.gestionQCM.dao.entity;



import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "groupe", catalog = "qcm_db")
public class Groupe implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Integer idGroupe;
	private String nomGroupe;
	private String dateCreation;
	
	private Integer id_Auteur;
	
	
	private Auteur auteur;
	
	private List<Etudiant> listOfEtudiants;
	
	public Groupe() {
	}

	public Groupe(String nomGroupe, String dateCreation) {
		this.nomGroupe = nomGroupe;
		this.dateCreation = dateCreation;
		
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_groupe", unique = true, nullable = false)
	public Integer getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(Integer idGroupe) {
		this.idGroupe = idGroupe;
	}

	@Column(name = "NomGroupe", nullable = false)
	public String getNomGroupe() {
		return this.nomGroupe;
	}



	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	
	@Column(name = "DateCreation", nullable = false, length=10)
	public String getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}




	
	



	
	@ManyToOne
	@JoinColumn(name="id_Auteur",insertable=false, updatable=false)
	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public Integer getId_Auteur() {
		return id_Auteur;
	}

	public void setId_Auteur(Integer id_Auteur) {
		this.id_Auteur = id_Auteur;
	}
	
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="membre_groupe",
	joinColumns={@JoinColumn(name="id_groupe")}, inverseJoinColumns={@JoinColumn(name="id_user")})
	public List<Etudiant> getListOfEtudiants() {
		return listOfEtudiants;
	}

	public void setListOfEtudiants(List<Etudiant> listOfEtudiants) {
		this.listOfEtudiants = listOfEtudiants;
	}
	
	
	
	
	

}
