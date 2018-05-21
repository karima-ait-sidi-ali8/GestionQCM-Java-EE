package fr.insset.gestionQCM.metier;

import fr.insset.gestionQCM.dao.SessionDAO;
import fr.insset.gestionQCM.dao.entity.SessionEntity;

public class SessionMetierImpl implements SessionMetier {
	
	private SessionDAO sessionDao;
	
	

	public void setSessionDao(SessionDAO sessionDao) {
		this.sessionDao = sessionDao;
	}

	@Override
	public SessionEntity add_Session(SessionEntity s) {
		
		return sessionDao.add_Session(s);
	}

	@Override
	public void deleteSession(Integer id) {
		
		sessionDao.deleteSession(id);
		
	}

	@Override
	public SessionEntity getById(Integer id) {

		return sessionDao.getById(id);
	}

}
