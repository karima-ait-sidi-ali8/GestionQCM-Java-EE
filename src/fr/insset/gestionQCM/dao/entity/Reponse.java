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
@Table(name = "reponse", catalog = "qcm_db")
public class Reponse implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Integer idReponse;
	private String textReponse;
	private boolean isCorrect;
	
	private Integer idQues;
	
	
	private Question question;

	public Reponse() {
	}

	public Reponse(String textReponse, boolean isCorrect, int idQues, int idSession) {
		
		this.textReponse = textReponse;
		this.isCorrect = isCorrect;
		this.idQues = idQues;

	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_reponse", unique = true, nullable = false)
	public Integer getIdReponse() {
		return idReponse;
	}

	public void setIdReponse(Integer idReponse) {
		this.idReponse = idReponse;
	}

	@Column(name = "TextReponse", nullable = false)
	public String getTextReponse() {
		return this.textReponse;
	}





	public void setTextReponse(String textReponse) {
		this.textReponse = textReponse;
	}




	@Column(name = "id_question", nullable = false)
	public Integer getIdQues() {
		return this.idQues;
	}

	

	public void setIdQues(Integer idQues) {
		this.idQues = idQues;
	}

	
	@ManyToOne
	@JoinColumn(name="id_question" , referencedColumnName="id_question", insertable=false, updatable=false)
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Column(name = "is_correct", nullable = false)
	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	
}
