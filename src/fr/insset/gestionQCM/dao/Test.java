package fr.insset.gestionQCM.dao;



import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.insset.gestionQCM.dao.entity.Utilisateur;
import fr.insset.gestionQCM.metier.UserMetier;



public class Test {
	public static Logger log = Logger.getLogger(Test.class);
	public static void main(String[] args) {
		
		/*UserDAO usr = new UserDAOImpl();
		List<Utilisateur> listUser =  usr.getStatus("frifita1@gmail.com", "admin");
		
		
		if(listUser.isEmpty())
			System.out.println("aucun User !");
		else
			
		for(Utilisateur u : listUser ){
			log.info("le nom du client est"+ u.getNom());
		}*/
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"config/config.xml"});
		UserMetier metier = (UserMetier) context.getBean("metier"); 
		List<Utilisateur> listUser = metier.getStatus("frifita1@gmail.com", "admin");
		
		for(Utilisateur u : listUser ){
			log.info("le nom du client est"+ u.getNom());
		}
	}

}
