package fr.insset.gestionQCM.dao.entity;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "theme", catalog = "qcm_db")
public class Theme implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String titreTheme;
	private int idQcm;
	
	
	
	private Qcm qcm;
	
	private List<Page> listPages;
	
	public Theme() {
	}

	public Theme(int id, String titreTheme, int idQcm) {
		this.id = id;
		this.titreTheme = titreTheme;
		this.idQcm = idQcm;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_theme", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "titre_theme", nullable = false)
	public String getTitreTheme() {
		return this.titreTheme;
	}

	public void setTitreTheme(String titreTheme) {
		this.titreTheme = titreTheme;
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

	@OneToMany(targetEntity=Page.class, mappedBy="theme")
	public List<Page> getListPages() {
		return listPages;
	}

	public void setListPages(List<Page> listPages) {
		this.listPages = listPages;
	}



	
	
}
