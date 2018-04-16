package fr.insset.gestionQCM.metier;

import java.util.List;

import fr.insset.gestionQCM.dao.entity.Utilisateur;

public interface UserMetier {
	
	public List<Utilisateur> getStatus(String email, String password);

}
