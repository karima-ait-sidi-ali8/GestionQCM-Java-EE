package fr.insset.gestionQCM.dao;

import org.hibernate.Session;

import fr.insset.gestionQCM.dao.entity.Page;
import fr.insset.gestionQCM.utils.HibernateUtil;

public class PageDAOImpl implements PageDAO {
	
	Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public Page addPage(Page p) {
		session.beginTransaction();
		Page page = (Page) session.merge(p);
		session.getTransaction().commit();
		return page;
	}

	@Override
	public void deletePage(Integer id) {
		try {
		Page p = getById(id);
		session.beginTransaction();
		session.delete(p);
		session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		
		
	}

	@Override
	public Page getById(Integer id) {
		return (Page) session.get(Page.class, id);
		
	}

	
}
