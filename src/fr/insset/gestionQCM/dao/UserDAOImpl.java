package fr.insset.gestionQCM.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.insset.gestionQCM.dao.entity.Role;
import fr.insset.gestionQCM.dao.entity.Utilisateur;
import fr.insset.gestionQCM.utils.HibernateUtil;

public class UserDAOImpl implements UserDAO {
	
	Session session = HibernateUtil.getSessionFactory().openSession();

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> getStatus(String email, String password) {
	
		Query q = session.createQuery("from Utilisateur u where u.email=:x and u.password=:y");
		q.setParameter("x", email);
		q.setParameter("y", password);
		return q.list();
		
		
	}

	@Override
	public Utilisateur addUser(Utilisateur u, String role) {
		Query q = session.createQuery("from Role r where r.nomRole= :x");
		q.setParameter("x", role);
		
		Role eRole = (Role) q.list().get(0);
		session.beginTransaction();
		u.getUserRoles().add(eRole);
		session.save(u);
		session.getTransaction().commit();
		
		return u;
	}

	@Override
	public boolean findbyAdresseAndRole(String adresse, String role) {
		boolean verif = true;
		Query q = session.createQuery("from Utilisateur u where u.email=:x");
		q.setParameter("x", adresse);
		if(q.list().isEmpty())
			verif = false;
		else{
			
			Utilisateur user = (Utilisateur) q.list().get(0);
			Query q2 = session.createSQLQuery("select * from avoir_role INNER JOIN role ON avoir_role.idRole = role.id_role where avoir_role.idUser=:x and role.NomRole=:y");
			q2.setParameter("x", user.getIdUser());
			q2.setParameter("y", role);
			
			if(q2.list().isEmpty()) verif = false;
			
		}
		
		
		return verif;
	}


	
	
		
		

}
