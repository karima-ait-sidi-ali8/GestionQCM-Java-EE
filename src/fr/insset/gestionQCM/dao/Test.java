package fr.insset.gestionQCM.dao;





import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.insset.gestionQCM.dao.entity.Groupe;
import fr.insset.gestionQCM.metier.GroupeMetier;
import fr.insset.gestionQCM.metier.QcmMetier;




public class Test {
	public static Logger log = Logger.getLogger(Test.class);
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"config/config.xml"});
		QcmMetier metier = (QcmMetier) context.getBean("qcmMetier"); 

		
		GroupeMetier metier1 = (GroupeMetier) context.getBean("groupeMetier"); 
		context.close();
		
		Groupe g = metier1.findById(9);



		metier.AffectQcmToGroupe(new Integer(3), g);


	}

}
