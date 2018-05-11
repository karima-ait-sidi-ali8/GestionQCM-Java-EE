package fr.insset.gestionQCM.dao;







import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.insset.gestionQCM.dao.entity.Etudiant;
import fr.insset.gestionQCM.dao.entity.Groupe;
import fr.insset.gestionQCM.dao.entity.Role;
import fr.insset.gestionQCM.metier.GroupeMetier;
import fr.insset.gestionQCM.metier.UserMetier;
import fr.insset.gestionQCM.utils.HibernateUtil;




public class Test {
	public static Logger log = Logger.getLogger(Test.class);
	public static void main(String[] args) {
		

		


		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"config/config.xml"});
		UserMetier metier = (UserMetier) context.getBean("metier"); 
		context.close();


		/*System.out.println("debut");
		List<Groupe> Groupes = new ArrayList<Groupe>();
		 Groupes =  metier.ListGroupOfEtudiant(new Integer(1));
		 Groupe g = (Groupe) Groupes.get(0);
			System.out.println(g.getNomGroupe());
		
		
		System.out.println("fin");*/
		System.out.println("debut");
		metier.addEtudiant(new Etudiant("EL FERKH","Meryeme","123456","m.el@gmail.com"));
		Session session = HibernateUtil.getSessionFactory().openSession();
		Etudiant e = (Etudiant) session.get(Etudiant.class, new Integer(1));
		Groupe g1 = e.getListGroupes().get(0);
		System.out.println(g1.getNomGroupe());
		System.out.println("fin");
		
		//metier.deleteGroupe(new Integer(2));
		
		//metier.addAuteur(new Auteur("ALEX","BERNOIS","123","ALEX@gmail.com"));
		
	/*	Session session = HibernateUtil.getSessionFactory().openSession();
		
	
		Auteur a = (Auteur)session.get(Auteur.class, new Integer(1));
		
		Groupe g = a.getListGroupes().get(0);
		System.out.println(g.getNomGroupe());*/


		

		
	}

}
