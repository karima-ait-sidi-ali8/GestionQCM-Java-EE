package fr.insset.gestionQCM.dao.entity;

import org.apache.log4j.Logger;
import org.hibernate.Session;


import fr.insset.gestionQCM.utils.HibernateUtil;



public class TestClass {

	public static Logger log = Logger.getLogger(TestClass.class);
	static Session session = HibernateUtil.getSessionFactory().openSession();
	
	public static void main(String[] args) {
		
		session.createQuery("from "+Utilisateur.class.getSimpleName()).list();
		log.info("success");
		

	}

}
