package fr.insset.gestionQCM.dao.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "qcm", catalog = "qcm_db")
public class Qcm implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String titre;
	private String type;
	private int idAuteur;

	public Qcm() {
	}

	public Qcm(String titre, String type, int idAuteur) {
		this.titre = titre;
		this.type = type;
		this.idAuteur = idAuteur;
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

	@Column(name = "titre", nullable = false)
	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Column(name = "type", nullable = false)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "id_auteur", nullable = false)
	public int getIdAuteur() {
		return this.idAuteur;
	}

	public void setIdAuteur(int idAuteur) {
		this.idAuteur = idAuteur;
	}

}
