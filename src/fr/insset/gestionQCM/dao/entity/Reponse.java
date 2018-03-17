package fr.insset.gestionQCM.dao.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "reponse", catalog = "qcm_db")
public class Reponse implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String textReponse;
	private boolean isCorrect;
	private int idQues;
	private int idSession;

	public Reponse() {
	}

	public Reponse(int id, String textReponse, boolean isCorrect, int idQues, int idSession) {
		this.id = id;
		this.textReponse = textReponse;
		this.isCorrect = isCorrect;
		this.idQues = idQues;
		this.idSession = idSession;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "TextReponse", nullable = false)
	public String getTextReponse() {
		return this.textReponse;
	}

	public void setTextReponse(String textReponse) {
		this.textReponse = textReponse;
	}

	@Column(name = "isCorrect", nullable = false)
	public boolean isIsCorrect() {
		return this.isCorrect;
	}

	public void setIsCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	@Column(name = "id_ques", nullable = false)
	public int getIdQues() {
		return this.idQues;
	}

	public void setIdQues(int idQues) {
		this.idQues = idQues;
	}

	@Column(name = "id_session", nullable = false)
	public int getIdSession() {
		return this.idSession;
	}

	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}

}
