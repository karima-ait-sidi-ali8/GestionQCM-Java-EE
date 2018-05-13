package fr.insset.gestionQCM.metier;

import fr.insset.gestionQCM.dao.entity.Etudiant;
import fr.insset.gestionQCM.dao.entity.Groupe;

public interface GroupeMetier {
	
	
	public Groupe addGroupe(Groupe g);
	
	public void deleteGroupe(Integer id);
	
	public Groupe findById(Integer id);
	
	public void addEtudiant(Etudiant e, Integer idGroupe);
	
	public void deleteEtudiant(Integer idEtudiant, Integer idGroupe);
	
	

}
