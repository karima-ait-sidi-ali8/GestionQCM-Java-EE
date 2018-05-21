package fr.insset.gestionQCM.dao.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
@Table(name = "qcm", catalog = "qcm_db")
public class Qcm implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Integer id;
	private String titre;
	
	private String description;
	private String type;
	private int idAuteur;
	
	private List<SessionEntity> sessions = new ArrayList<SessionEntity>();
	
	private List<Groupe> listGroupes;
	
	private List<Theme> listThemes;
	
	private Auteur auteur;

	public Qcm() {
	}

	public Qcm(String titre, String type, int idAuteur) {
		this.titre = titre;
		this.type = type;
		this.idAuteur = idAuteur;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_qcm", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "titre", nullable = false)
	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Column(name = "type", nullable = false)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "id_auteur", nullable = false)
	public int getIdAuteur() {
		return this.idAuteur;
	}

	public void setIdAuteur(int idAuteur) {
		this.idAuteur = idAuteur;
	}

	@OneToMany(targetEntity=SessionEntity.class, mappedBy="qcm", fetch=FetchType.LAZY)
	public List<SessionEntity> getSessions() {
		return sessions;
	}

	public void setSessions(List<SessionEntity> sessions) {
		this.sessions = sessions;
	}

	@ManyToOne
	@JoinColumn(name="id_auteur", insertable=false, updatable=false)
	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	
	@ManyToMany
	@JoinTable(name="Qcm_groupe", 
	joinColumns={@JoinColumn(name="id_qcm")}, inverseJoinColumns={@JoinColumn(name="id_groupe")})
	public List<Groupe> getListGroupes() {
		return listGroupes;
	}

	public void setListGroupes(List<Groupe> listGroupes) {
		this.listGroupes = listGroupes;
	}

	@OneToMany(targetEntity=Theme.class, mappedBy="qcm", cascade=CascadeType.REMOVE)
	public List<Theme> getListThemes() {
		return listThemes;
	}

	public void setListThemes(List<Theme> listThemes) {
		this.listThemes = listThemes;
	}

	@Column(name = "description")
	@Type(type="text")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
