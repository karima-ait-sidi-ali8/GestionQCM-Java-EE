package fr.insset.gestionQCM.dao.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "question", catalog = "qcm_db")
public class Question implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	private int id;
	private String textQuestion;
	private boolean estMarquee;
	private int idTheme;

	public Question() {
	}

	public Question(int id, String textQuestion, boolean estMarquee, int idTheme) {
		this.id = id;
		this.textQuestion = textQuestion;
		this.estMarquee = estMarquee;
		this.idTheme = idTheme;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "TextQuestion", nullable = false)
	public String getTextQuestion() {
		return this.textQuestion;
	}

	public void setTextQuestion(String textQuestion) {
		this.textQuestion = textQuestion;
	}

	@Column(name = "EstMarquee", nullable = false)
	public boolean isEstMarquee() {
		return this.estMarquee;
	}

	public void setEstMarquee(boolean estMarquee) {
		this.estMarquee = estMarquee;
	}

	@Column(name = "id_theme", nullable = false)
	public int getIdTheme() {
		return this.idTheme;
	}

	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}

}
