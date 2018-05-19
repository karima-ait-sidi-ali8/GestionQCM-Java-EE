package fr.insset.gestionQCM.dao;

import org.hibernate.Session;


import fr.insset.gestionQCM.dao.entity.Reponse;
import fr.insset.gestionQCM.utils.HibernateUtil;

public class ReponseDAOImpl implements ReponseDAO {

	Session session = HibernateUtil.getSessionFactory().openSession();
	@Override
	public Reponse addReponse(Reponse r) {
		session.beginTransaction();
		Reponse rep = (Reponse) session.merge(r);
		session.getTransaction().commit();
		return rep;
	}

	@Override
	public void deleteReponse(Integer id) {
		try{
			Reponse r = getById(id);
			session.beginTransaction();
			session.delete(r);
			session.getTransaction().commit();
			
		}catch(RuntimeException re){
			session.getTransaction().rollback();
			throw re;
		}
		
	}

	@Override
	public Reponse getById(Integer id) {
		
		return (Reponse) session.get(Reponse.class, id);
	}

	@Override
	public void UpdateReponse(Reponse r) {
		session.beginTransaction();
		session.update(r);
		session.getTransaction().commit();
		
	}

}
