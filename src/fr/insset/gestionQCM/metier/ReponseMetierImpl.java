package fr.insset.gestionQCM.metier;

import fr.insset.gestionQCM.dao.ReponseDAO;
import fr.insset.gestionQCM.dao.entity.Reponse;

public class ReponseMetierImpl implements ReponseMetier {
	
	private ReponseDAO reponseDAO;
	
	

	public void setReponseDAO(ReponseDAO reponseDAO) {
		this.reponseDAO = reponseDAO;
	}

	@Override
	public Reponse addReponse(Reponse r) {
		
		return reponseDAO.addReponse(r);
	}

	@Override
	public void deleteReponse(Integer id) {
		
		reponseDAO.deleteReponse(id);
		
	}

	@Override
	public Reponse getById(Integer id) {
		
		return reponseDAO.getById(id);
	}

	@Override
	public void UpdateReponse(Reponse r) {
		
		reponseDAO.UpdateReponse(r);
		
	}

}
