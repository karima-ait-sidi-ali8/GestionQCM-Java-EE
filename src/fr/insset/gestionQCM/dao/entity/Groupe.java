package fr.insset.gestionQCM.dao.entity;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "groupe", catalog = "qcm_db")
public class Groupe implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Integer idGroupe;
	private String nomGroupe;
	private Date dateCreation;
	private int idUser;

	private Set<Utilisateur> listOfUsers = new HashSet<Utilisateur>();
	
	public Groupe() {
	}

	public Groupe(String nomGroupe, Date dateCreation, int idUser) {
		this.nomGroupe = nomGroupe;
		this.dateCreation = dateCreation;
		this.idUser = idUser;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "DateCreation", nullable = false, length = 10)
	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Column(name = "idUser", nullable = false)
	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	
	@ManyToMany
	@JoinTable(name="groupe_utilisateur",
	joinColumns={@JoinColumn(name="idGroupe")}, inverseJoinColumns={@JoinColumn(name="idUser")})
	public Set<Utilisateur> getListOfUsers() {
		return listOfUsers;
	}

	public void setListOfUsers(Set<Utilisateur> listOfUsers) {
		this.listOfUsers = listOfUsers;
	}
	
	
	
	
	

}
