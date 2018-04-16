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

}
