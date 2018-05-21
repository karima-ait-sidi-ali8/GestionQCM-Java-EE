package fr.insset.gestionQCM.dao;


import fr.insset.gestionQCM.dao.entity.SessionEntity;

public interface SessionDAO {
	
	public SessionEntity add_Session(SessionEntity s);
	
	public void deleteSession(Integer id);

	public SessionEntity getById(Integer id);

}
