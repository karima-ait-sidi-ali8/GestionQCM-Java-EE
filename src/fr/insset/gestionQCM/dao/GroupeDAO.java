package fr.insset.gestionQCM.dao;

import fr.insset.gestionQCM.dao.entity.Groupe;

public interface GroupeDAO {
	
	public Groupe addGroupe(Groupe g);
	
	public void deleteGroupe(Groupe g);
	
	public void getbyId(Long id);
	

}
