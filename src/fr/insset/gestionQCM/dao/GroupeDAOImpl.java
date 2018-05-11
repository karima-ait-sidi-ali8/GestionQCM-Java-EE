package fr.insset.gestionQCM.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.insset.gestionQCM.dao.entity.Groupe;
import fr.insset.gestionQCM.utils.HibernateUtil;

public class GroupeDAOImpl implements GroupeDAO {
	
	Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public Groupe addGroupe(Groupe g) {
		session.beginTransaction();
		Groupe gp = (Groupe) session.merge(g);
		session.getTransaction().commit();
		return gp;
	}

	@Override
	public void deleteGroupe(Integer id) {

		try {
			session.beginTransaction();

			Groupe gp = findById(id);
			session.delete(gp);

			session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
	}

	@Override
	public Groupe findById(Integer id) {

		return (Groupe) session.get(Groupe.class, id);
		
	}
	
	

}
