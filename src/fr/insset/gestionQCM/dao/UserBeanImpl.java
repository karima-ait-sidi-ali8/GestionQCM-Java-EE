package fr.insset.gestionQCM.dao;

import org.hibernate.Session;


import fr.insset.gestionQCM.dao.entity.Utilisateur;
import fr.insset.gestionQCM.utils.HibernateUtil;

public class UserBeanImpl implements UserDAO {
	
	Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public Utilisateur getStatus(String email, String password) {
		return null;
	}

}
