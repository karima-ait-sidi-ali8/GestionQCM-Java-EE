package fr.insset.gestionQCM.dao.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "session", catalog = "qcm_db")
public class Session implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private int id;
	private int nbEssai;
	private Date dateDeb;
	private Date dateFin;
	private double duree;
	private boolean showResult;
	private boolean chatAutorisation;
	private int idQcm;
	
	private Qcm qcm;

	public Session() {
	}

	public Session(int id, int nbEssai, Date dateDeb, Date dateFin, double duree, boolean showResult,
			boolean chatAutorisation, int idQcm) {
		this.id = id;
		this.nbEssai = nbEssai;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
		this.duree = duree;
		this.showResult = showResult;
		this.chatAutorisation = chatAutorisation;
		this.idQcm = idQcm;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "NbEssai", nullable = false)
	public int getNbEssai() {
		return this.nbEssai;
	}

	public void setNbEssai(int nbEssai) {
		this.nbEssai = nbEssai;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DateDeb", nullable = false, length = 10)
	public Date getDateDeb() {
		return this.dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DateFin", nullable = false, length = 10)
	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@Column(name = "Duree", nullable = false, precision = 22, scale = 0)
	public double getDuree() {
		return this.duree;
	}

	public void setDuree(double duree) {
		this.duree = duree;
	}

	@Column(name = "ShowResult", nullable = false)
	public boolean isShowResult() {
		return this.showResult;
	}

	public void setShowResult(boolean showResult) {
		this.showResult = showResult;
	}

	@Column(name = "ChatAutorisation", nullable = false)
	public boolean isChatAutorisation() {
		return this.chatAutorisation;
	}

	public void setChatAutorisation(boolean chatAutorisation) {
		this.chatAutorisation = chatAutorisation;
	}

	@Column(name = "id_qcm", nullable = false)
	public int getIdQcm() {
		return this.idQcm;
	}

	public void setIdQcm(int idQcm) {
		this.idQcm = idQcm;
	}

	@ManyToOne
	@JoinColumn(name="idQcm", referencedColumnName="id", insertable=false, updatable=false)
	public Qcm getQcm() {
		return qcm;
	}

	public void setQcm(Qcm qcm) {
		this.qcm = qcm;
	}

}
