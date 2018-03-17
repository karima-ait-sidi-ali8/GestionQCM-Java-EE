package fr.insset.gestionQCM.dao.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "resultat", catalog = "qcm_db")
public class Resultat implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private double note;
	private int idEtudiant;

	public Resultat() {
	}

	public Resultat(int id, double note, int idEtudiant) {
		this.id = id;
		this.note = note;
		this.idEtudiant = idEtudiant;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "note", nullable = false, precision = 22, scale = 0)
	public double getNote() {
		return this.note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	@Column(name = "id_etudiant", nullable = false)
	public int getIdEtudiant() {
		return this.idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

}
