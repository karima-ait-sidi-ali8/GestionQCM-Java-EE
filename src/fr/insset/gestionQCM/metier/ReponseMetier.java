package fr.insset.gestionQCM.metier;

import fr.insset.gestionQCM.dao.entity.Reponse;

public interface ReponseMetier {

	public Reponse addReponse(Reponse r);
	
	public void deleteReponse(Integer id);
	
	public Reponse getById(Integer id);
	
	public void UpdateReponse(Reponse r);
}
