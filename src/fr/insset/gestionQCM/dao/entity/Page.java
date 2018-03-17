package fr.insset.gestionQCM.dao.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "page", catalog = "qcm_db")
public class Page implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private int idQues;

	public Page() {
	}

	public Page(int idQues) {
		this.idQues = idQues;
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

	@Column(name = "id_ques", nullable = false)
	public int getIdQues() {
		return this.idQues;
	}

	public void setIdQues(int idQues) {
		this.idQues = idQues;
	}

}
