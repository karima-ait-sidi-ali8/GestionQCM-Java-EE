package fr.insset.gestionQCM.metier;

import java.util.List;

import fr.insset.gestionQCM.dao.UserDAO;
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
	public boolean findbyAdresseAndRole(String adresse, String role) {
		
		return daoUser.findbyAdresseAndRole(adresse, role);
	}

	@Override
	public Utilisateur finByOne(Integer id) {
		
		return daoUser.finByOne(id);
	}



}
