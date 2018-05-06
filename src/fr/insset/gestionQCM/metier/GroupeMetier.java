package fr.insset.gestionQCM.metier;

import fr.insset.gestionQCM.dao.entity.Groupe;

public interface GroupeMetier {
	
	
	public Groupe addGroupe(Groupe g);
	
	public void deleteGroupe(Integer id);
	
	public Groupe findById(Integer id);
	

}
