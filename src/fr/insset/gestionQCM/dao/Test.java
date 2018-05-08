package fr.insset.gestionQCM.dao;







import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.insset.gestionQCM.dao.entity.Auteur;
import fr.insset.gestionQCM.dao.entity.Etudiant;
import fr.insset.gestionQCM.dao.entity.Role;
import fr.insset.gestionQCM.metier.UserMetier;
import fr.insset.gestionQCM.utils.HibernateUtil;




public class Test {
	public static Logger log = Logger.getLogger(Test.class);
	public static void main(String[] args) {
		

		


		/*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"config/config.xml"});
		UserMetier metier = (UserMetier) context.getBean("metier"); 
		context.close();*/
		
		//System.out.println(metier.findbyAdresseAndRole("alex@gmail.com","etudiant"));
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Query q = session.createQuery("from Role r where r.nomRole= :x");
		q.setParameter("x", "etudiant");
		
		Role eRole = (Role) q.list().get(0);
		
		Auteur a = new Auteur("Mossaab","frifir","123","frifota1@gmail.com");
		a.getUserRoles().add(eRole);
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();

		

		
	}

}
