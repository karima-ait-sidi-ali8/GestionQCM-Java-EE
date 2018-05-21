package fr.insset.gestionQCM.dao;

import org.hibernate.Session;


import fr.insset.gestionQCM.dao.entity.SessionEntity;
import fr.insset.gestionQCM.utils.HibernateUtil;

public class SessionDAOImpl implements SessionDAO {
	Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public SessionEntity add_Session(SessionEntity s) {
		session.beginTransaction();
		SessionEntity se = (SessionEntity) session.merge(s);
		session.getTransaction().commit();
		return se;
	}

	@Override
	public void deleteSession(Integer id) {
		try {
			SessionEntity se = getById(id);
		session.beginTransaction();
		session.delete(se);
		session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		
		
	}

	@Override
	public SessionEntity getById(Integer id) {
		
		return (SessionEntity) session.get(SessionEntity.class, id);
	}







}
