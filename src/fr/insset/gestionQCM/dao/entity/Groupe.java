package fr.insset.gestionQCM.dao.entity;



import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "groupe", catalog = "qcm_db")
public class Groupe implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Integer idGroupe;
	private String nomGroupe;
	private String dateCreation;
	
	private Integer id_Auteur;
	
	private boolean chatAuth;
	
	private Auteur auteur;
	
	private List<Etudiant> listOfEtudiants;
	
	private List<Qcm> listQcms;
	
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
	
	
	@ManyToMany
	@JoinTable(name="membre_groupe",
	joinColumns={@JoinColumn(name="id_groupe")}, inverseJoinColumns={@JoinColumn(name="id_user")})
	public List<Etudiant> getListOfEtudiants() {
		return listOfEtudiants;
	}
	

	public void setListOfEtudiants(List<Etudiant> listOfEtudiants) {
		this.listOfEtudiants = listOfEtudiants;
	}

	
	@ManyToMany
	@JoinTable(name="Qcm_groupe", 
	joinColumns={@JoinColumn(name="id_groupe")}, inverseJoinColumns={@JoinColumn(name="id_qcm")})
	public List<Qcm> getListQcms() {
		return listQcms;
	}
	


	public void setListQcms(List<Qcm> listQcms) {
		this.listQcms = listQcms;
	}

	public boolean isChatAuth() {
		return chatAuth;
	}

	public void setChatAuth(boolean chatAuth) {
		this.chatAuth = chatAuth;
	}
	
	
	
	
	

}
