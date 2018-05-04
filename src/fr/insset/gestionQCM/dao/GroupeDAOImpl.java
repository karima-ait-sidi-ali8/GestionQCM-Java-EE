package fr.insset.gestionQCM.dao;

import org.hibernate.Session;

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
		session.beginTransaction();
		Groupe gp = findById(id);
		session.delete(gp);
		session.getTransaction().commit();

		
	}

	@Override
	public Groupe findById(Integer id) {
		session.beginTransaction();
		return (Groupe) session.get(Groupe.class, id);
	}
	
	

}
