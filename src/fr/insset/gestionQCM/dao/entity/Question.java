package fr.insset.gestionQCM.dao.entity;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
@Table(name = "question", catalog = "qcm_db")
public class Question implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer idQuestion;
	private String textQuestion;
	private boolean estMarquee;
	
	private Integer idPage;
	
	private Page page;

	private List<Reponse> listReponses;
	
	public Question() {
	}



	public Question(String textQuestion, boolean estMarquee, Integer idPage) {
		super();
		this.textQuestion = textQuestion;
		this.estMarquee = estMarquee;
		this.idPage = idPage;
	}



	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_question", unique = true, nullable = false)
	public Integer getIdQuestion() {
		return idQuestion;
	}



	public void setIdQuestion(Integer idQuestion) {
		this.idQuestion = idQuestion;
	}

	@Column(name = "TextQuestion", nullable = false)
	@Type(type="text")
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

	@ManyToOne
	@JoinColumn(name="id_page", referencedColumnName="id_page",insertable=false, updatable=false)
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}


	@Column(name = "id_page", nullable = false)
	public Integer getIdPage() {
		return idPage;
	}



	public void setIdPage(Integer idPage) {
		this.idPage = idPage;
	}



	@OneToMany(targetEntity=Reponse.class, mappedBy="question",cascade=CascadeType.REMOVE)
	public List<Reponse> getListReponses() {
		return listReponses;
	}



	public void setListReponses(List<Reponse> listReponses) {
		this.listReponses = listReponses;
	}

	

}
