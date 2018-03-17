package fr.insset.gestionQCM.dao;

import fr.insset.gestionQCM.dao.entity.Utilisateur;

public interface UserDAO {
	
	public Utilisateur getStatus(String email, String password);
	

}
