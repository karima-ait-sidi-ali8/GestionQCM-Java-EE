package fr.insset.gestionQCM.dao.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "utilisateur", catalog = "qcm_db")
public class Utilisateur implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Integer idUser;
	private String nom;
	private String prenom;
	private String password;
	private String email;
	
	
	private List<Role> userRoles = new ArrayList<Role>();
	
	
	public Utilisateur() {
	}

	public Utilisateur(String nom, String prenom, String password, String email) {
		this.nom = nom;
		this.prenom = prenom;

		
		this.password = password;
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_user", unique = true, nullable = false)
	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	@Column(name = "nom", nullable = false)
	public String getNom() {
		return this.nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prenom", nullable = false)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	@Column(name = "password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToMany
	@JoinTable(name="avoir_role",
	joinColumns={@JoinColumn(name="idUser")},inverseJoinColumns={@JoinColumn(name="idRole")})
	public List<Role> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<Role> userRoles) {
		this.userRoles = userRoles;
	}
	
	

}
