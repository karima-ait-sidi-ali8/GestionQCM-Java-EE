package fr.insset.gestionQCM.dao.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "membre", catalog = "qcm_db")
public class Membre implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private double autorisation;
	private int idGrp;
	private int idEtudiant;

	public Membre() {
	}

	public Membre(double autorisation, int idGrp, int idEtudiant) {
		this.autorisation = autorisation;
		this.idGrp = idGrp;
		this.idEtudiant = idEtudiant;
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

	@Column(name = "autorisation", nullable = false, precision = 22, scale = 0)
	public double getAutorisation() {
		return this.autorisation;
	}

	public void setAutorisation(double autorisation) {
		this.autorisation = autorisation;
	}

	@Column(name = "id_grp", nullable = false)
	public int getIdGrp() {
		return this.idGrp;
	}

	public void setIdGrp(int idGrp) {
		this.idGrp = idGrp;
	}

	@Column(name = "id_etudiant", nullable = false)
	public int getIdEtudiant() {
		return this.idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

}
