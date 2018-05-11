package fr.insset.gestionQCM.metier;

import java.util.List;

import fr.insset.gestionQCM.dao.UserDAO;
import fr.insset.gestionQCM.dao.entity.Auteur;
import fr.insset.gestionQCM.dao.entity.Etudiant;
import fr.insset.gestionQCM.dao.entity.Utilisateur;

public class UserMetierImpl implements UserMetier {

	
	private UserDAO daoUser ;
	
	public void setDaoUser(UserDAO dao) {
		this.daoUser = dao;
	}

	@Override
	public List<Utilisateur> getStatus(String email, String password) {
		 return daoUser.getStatus(email, password);
	}

	@Override
	public Utilisateur addUser(Utilisateur u, String role) {
		
		return daoUser.addUser(u, role);
	}

	@Override
	public boolean findbyAdresse(String adresse) {
		
		return daoUser.findbyAdresse(adresse);
	}

	@Override
	public Utilisateur finByOne(Integer id) {
		
		return daoUser.finByOne(id);
	}

	@Override
	public Utilisateur addEtudiant(Etudiant e) {
		
		return daoUser.addEtudiant(e);
	}

	@Override
	public Utilisateur addAuteur(Auteur a) {
		
		return daoUser.addAuteur(a);
	}

	@Override
	public Etudiant getEtudiant(Integer id) {
		
		return daoUser.getEtudiant(id);
	}

	@Override
	public Auteur getAuteur(Integer id) {
		
		return daoUser.getAuteur(id);
	}

	@Override
	public Boolean isEtudiant(Integer id) {
		
		return daoUser.isEtudiant(id);
	}

	@Override
	public Boolean isAuteur(Integer id) {
		
		return daoUser.isAuteur(id);
	}



}
