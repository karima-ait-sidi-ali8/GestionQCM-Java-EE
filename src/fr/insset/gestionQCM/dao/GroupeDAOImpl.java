package fr.insset.gestionQCM.dao;



import org.hibernate.Query;
import org.hibernate.Session;

import fr.insset.gestionQCM.dao.entity.Etudiant;
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

	@Override
	public void addEtudiant(Etudiant e, Integer idGroupe) {
		
		Groupe g = findById(idGroupe);
		g.getListOfEtudiants().add(e);
		
		session.beginTransaction();
		session.save(g);
		session.getTransaction().commit();
		
		
	}

	@Override
	public void deleteEtudiant(Integer idEtudiant, Integer idGroupe) {
		session.beginTransaction();
		Query q = session.createSQLQuery("DELETE FROM membre_groupe WHERE id_groupe=:x and id_user=:y");
		q.setParameter("x", idGroupe);
		q.setParameter("y", idEtudiant);
		
		q.executeUpdate();
		session.getTransaction().commit();
		

	
		
	}


	

}
