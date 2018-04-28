package fr.insset.gestionQCM.dao.entity;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "role", catalog = "qcm_db")
public class Role implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int idRole;
	private String nomRole;

	

	private List<Utilisateur> allUsersRoles;
	
	public Role() {
	}


	public Role(String nomRole) {
		super();
		this.nomRole = nomRole;
		
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_role", unique = true, nullable = false)
	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	
	

	@Column(name = "NomRole", nullable = false)
	public String getNomRole() {
		return this.nomRole;
	}



	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}

	@ManyToMany
	@JoinTable(name="avoir_role", 
	joinColumns={@JoinColumn(name="idRole")}, inverseJoinColumns={@JoinColumn(name="idUser")})
	public List<Utilisateur> getAllUsersRoles() {
		return allUsersRoles;
	}


	public void setAllUsersRoles(List<Utilisateur> allUsersRoles) {
		this.allUsersRoles = allUsersRoles;
	}
	

}
