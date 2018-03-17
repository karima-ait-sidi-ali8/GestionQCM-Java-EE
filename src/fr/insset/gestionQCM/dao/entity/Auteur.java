package fr.insset.gestionQCM.dao.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "auteur", catalog = "qcm_db")
public class Auteur implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String domaine;
	private int idUser;

	public Auteur() {
	}

	public Auteur(String domaine, int idUser) {
		this.domaine = domaine;
		this.idUser = idUser;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "domaine", nullable = false)
	public String getDomaine() {
		return this.domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	@Column(name = "id_user", nullable = false)
	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

}
