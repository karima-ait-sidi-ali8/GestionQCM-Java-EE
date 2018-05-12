package fr.insset.gestionQCM.dao;


import org.hibernate.Session;

import fr.insset.gestionQCM.dao.entity.Groupe;
import fr.insset.gestionQCM.dao.entity.Qcm;
import fr.insset.gestionQCM.utils.HibernateUtil;

public class QcmDAOImpl implements QcmDAO {

	Session session = HibernateUtil.getSessionFactory().openSession();
	


	@Override
	public Qcm addQcm(Qcm q) {
		session.beginTransaction();
		Qcm qSaved = (Qcm) session.merge(q);
		session.getTransaction().commit();
		return qSaved;
	}

	@Override
	public Qcm findByOne(Integer id) {
		return (Qcm) session.get(Qcm.class, id);
	}

	@Override
	public void deleteQcm(Integer id) {
		try {
		Qcm qToDelete = findByOne(id);
		session.beginTransaction();
		session.delete(qToDelete);
		session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
	}

	@Override
	public void AffectQcmToGroupe(Integer id, Groupe g) {
		Qcm QcmToAffect = findByOne(id);
		QcmToAffect.getListGroupes().add(g);
		session.beginTransaction();
		session.save(QcmToAffect);
		session.getTransaction().commit();
		
	}

	@Override
	public Qcm UpdateQcm(Qcm q) {
		session.beginTransaction();
		Qcm QcmUpdated = (Qcm) session.merge(q);
		session.getTransaction().commit();
		return QcmUpdated;
	}




	
}
