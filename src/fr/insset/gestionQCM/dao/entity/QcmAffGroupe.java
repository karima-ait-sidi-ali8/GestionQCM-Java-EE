package fr.insset.gestionQCM.dao.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "qcm_aff_groupe", catalog = "qcm_db")
public class QcmAffGroupe implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Date dateAffectation;
	private int idQcm;
	private int idGrp;

	public QcmAffGroupe() {
	}

	public QcmAffGroupe(int id, Date dateAffectation, int idQcm, int idGrp) {
		this.id = id;
		this.dateAffectation = dateAffectation;
		this.idQcm = idQcm;
		this.idGrp = idGrp;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DateAffectation", nullable = false, length = 10)
	public Date getDateAffectation() {
		return this.dateAffectation;
	}

	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}

	@Column(name = "id_qcm", nullable = false)
	public int getIdQcm() {
		return this.idQcm;
	}

	public void setIdQcm(int idQcm) {
		this.idQcm = idQcm;
	}

	@Column(name = "id_grp", nullable = false)
	public int getIdGrp() {
		return this.idGrp;
	}

	public void setIdGrp(int idGrp) {
		this.idGrp = idGrp;
	}

}
