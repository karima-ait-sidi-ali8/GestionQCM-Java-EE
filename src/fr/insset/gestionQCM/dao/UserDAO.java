package fr.insset.gestionQCM.dao;

import java.util.List;

import fr.insset.gestionQCM.dao.entity.Auteur;
import fr.insset.gestionQCM.dao.entity.Etudiant;
import fr.insset.gestionQCM.dao.entity.Utilisateur;

public interface UserDAO {
	
	public List<Utilisateur> getStatus(String email, String password);
	
	public Utilisateur addUser(Utilisateur u, String role);
	
	public Utilisateur addEtudiant(Etudiant e);
	
	public Utilisateur addAuteur(Auteur a);
	
	public boolean findbyAdresse(String adresse);
	
	public Utilisateur finByOne(Integer id);
	
	public Etudiant getEtudiant(Integer id);
	
	public Auteur getAuteur(Integer id);
	
	public Boolean isEtudiant(Integer id);
	
	public Boolean isAuteur(Integer id);
	
	public Utilisateur getByAdresse(String adresse);

}
