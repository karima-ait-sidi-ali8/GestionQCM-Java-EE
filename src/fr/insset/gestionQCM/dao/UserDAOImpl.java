package fr.insset.gestionQCM.dao;

import java.util.List;


import org.hibernate.Session;


import fr.insset.gestionQCM.dao.entity.Utilisateur;
import fr.insset.gestionQCM.utils.HibernateUtil;

public class UserDAOImpl implements UserDAO {
	
	Session session = HibernateUtil.getSessionFactory().openSession();

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> getStatus(String email, String password) {
		return session.createQuery("from Utilisateur where email ='"+email+"' and password='"+password+"'").list();
	}
		
		

}
