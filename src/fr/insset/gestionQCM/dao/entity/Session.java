package fr.insset.gestionQCM.dao.entity;


import static javax.persistence.GenerationType.IDENTITY;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "session", catalog = "qcm_db")
public class Session implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private int idSession;
	private int nbEssai;
	private String  dateDeb;
	private String dateFin;
	private double duree;
	private boolean showResult;

	private int idQcm;
	
	private Qcm qcm;

	public Session() {
	}

	public Session (int nbEssai, String dateDeb, String dateFin, double duree, boolean showResult,
			 int idQcm) {
	
		this.nbEssai = nbEssai;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
		this.duree = duree;
		this.showResult = showResult;

		this.idQcm = idQcm;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_session", unique = true, nullable = false)
	public int getIdSession() {
		return idSession;
	}

	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}

	@Column(name = "NbEssai", nullable = false)
	public int getNbEssai() {
		return this.nbEssai;
	}



	public void setNbEssai(int nbEssai) {
		this.nbEssai = nbEssai;
	}


	@Column(name = "DateDeb", nullable = false)
	public String getDateDeb() {
		return this.dateDeb;
	}

	public void setDateDeb(String dateDeb) {
		this.dateDeb = dateDeb;
	}


	@Column(name = "DateFin", nullable = false)
	public String getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(String dateFin) {
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



	@Column(name = "id_qcm", nullable = false)
	public int getIdQcm() {
		return this.idQcm;
	}

	public void setIdQcm(int idQcm) {
		this.idQcm = idQcm;
	}

	@ManyToOne
	@JoinColumn(name="id_qcm", referencedColumnName="id_qcm", insertable=false, updatable=false)
	public Qcm getQcm() {
		return qcm;
	}

	public void setQcm(Qcm qcm) {
		this.qcm = qcm;
	}

}
