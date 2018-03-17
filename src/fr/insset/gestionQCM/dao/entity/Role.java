package fr.insset.gestionQCM.dao.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "role", catalog = "qcm_db")
public class Role implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String nomRole;

	public Role() {
	}

	public Role(int id, String nomRole) {
		this.id = id;
		this.nomRole = nomRole;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "NomRole", nullable = false)
	public String getNomRole() {
		return this.nomRole;
	}

	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}

}
