package fr.insset.gestionQCM.dao.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "etudiant_choix", catalog = "qcm_db")
public class EtudiantChoix implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private boolean reponse;
	private int idEtudiant;
	private int idRep;

	public EtudiantChoix() {
	}

	public EtudiantChoix(boolean reponse, int idEtudiant, int idRep) {
		this.reponse = reponse;
		this.idEtudiant = idEtudiant;
		this.idRep = idRep;
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

	@Column(name = "reponse", nullable = false)
	public boolean isReponse() {
		return this.reponse;
	}

	public void setReponse(boolean reponse) {
		this.reponse = reponse;
	}

	@Column(name = "id_etudiant", nullable = false)
	public int getIdEtudiant() {
		return this.idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	@Column(name = "id_rep", nullable = false)
	public int getIdRep() {
		return this.idRep;
	}

	public void setIdRep(int idRep) {
		this.idRep = idRep;
	}

}
