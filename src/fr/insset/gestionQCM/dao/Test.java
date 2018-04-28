package fr.insset.gestionQCM.dao;







import org.apache.log4j.Logger;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import fr.insset.gestionQCM.metier.UserMetier;




public class Test {
	public static Logger log = Logger.getLogger(Test.class);
	public static void main(String[] args) {
		

		


		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"config/config.xml"});
		UserMetier metier = (UserMetier) context.getBean("metier"); 
		context.close();
		
		System.out.println(metier.findbyAdresseAndRole("frifita1@gmail.com","auteur"));
		
		
		

		
	}

}
