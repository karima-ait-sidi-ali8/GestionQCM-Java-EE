package fr.insset.gestionQCM.dao.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "page", catalog = "qcm_db")
public class Page implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Integer id;
	
	private Integer idTheme;
	
	private Theme theme;
	
	private List<Question> listQuestions;

	public Page() {
	}



	public Page(Integer idTheme, Theme theme, List<Question> listQuestions) {
		super();
		this.idTheme = idTheme;
		this.theme = theme;
		this.listQuestions = listQuestions;
	}



	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_page", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	
	@ManyToOne
	@JoinColumn(name="id_theme", referencedColumnName="id_theme", insertable=false, updatable= false)
	public Theme getTheme() {
		return theme;
	}



	public void setTheme(Theme theme) {
		this.theme = theme;
	}


	@Column(name = "id_theme",  nullable = false)
	public Integer getIdTheme() {
		return idTheme;
	}



	public void setIdTheme(Integer idTheme) {
		this.idTheme = idTheme;
	}



	@OneToMany(targetEntity=Question.class, mappedBy="page")
	public List<Question> getListQuestions() {
		return listQuestions;
	}



	public void setListQuestions(List<Question> listQuestions) {
		this.listQuestions = listQuestions;
	}







}
