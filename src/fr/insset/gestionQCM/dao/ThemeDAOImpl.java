package fr.insset.gestionQCM.dao;

import org.hibernate.Session;

import fr.insset.gestionQCM.dao.entity.Theme;
import fr.insset.gestionQCM.utils.HibernateUtil;

public class ThemeDAOImpl implements ThemeDAO {

	Session session = HibernateUtil.getSessionFactory().openSession();
	
	@Override
	public Theme addTheme(Theme t) {	
		session.beginTransaction();
		Theme theme = (Theme) session.merge(t);
		session.getTransaction().commit();	
		return theme;
	}

	@Override
	public void deleteTheme(Integer id) {

		try{
			session.beginTransaction();
			session.delete(getById(id));
			session.getTransaction().commit();
			
		}catch(RuntimeException re){
			session.getTransaction().rollback();
			throw re;
		}
		
	}

	@Override
	public Theme getById(Integer id) {
		
		return (Theme) session.get(Theme.class, id);
	}
	

}
