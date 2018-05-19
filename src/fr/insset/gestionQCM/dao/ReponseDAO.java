package fr.insset.gestionQCM.dao;


import fr.insset.gestionQCM.dao.entity.Reponse;

public interface ReponseDAO {
	
	public Reponse addReponse(Reponse r);
	
	public void deleteReponse(Integer id);
	
	public Reponse getById(Integer id);
	
	public void UpdateReponse(Reponse r);

}
