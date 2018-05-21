package fr.insset.gestionQCM.metier;

import fr.insset.gestionQCM.dao.entity.SessionEntity;

public interface SessionMetier {
	public SessionEntity add_Session(SessionEntity s);
	
	public void deleteSession(Integer id);

	public SessionEntity getById(Integer id);

}
