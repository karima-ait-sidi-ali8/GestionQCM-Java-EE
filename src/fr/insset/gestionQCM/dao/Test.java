package fr.insset.gestionQCM.dao;





import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.insset.gestionQCM.dao.entity.Auteur;
import fr.insset.gestionQCM.dao.entity.Etudiant;
import fr.insset.gestionQCM.dao.entity.Groupe;
import fr.insset.gestionQCM.dao.entity.Qcm;
import fr.insset.gestionQCM.dao.entity.Utilisateur;
import fr.insset.gestionQCM.metier.GroupeMetier;
import fr.insset.gestionQCM.metier.QcmMetier;
import fr.insset.gestionQCM.metier.UserMetier;
import fr.insset.gestionQCM.utils.ContextUtil;




public class Test {
	public static Logger log = Logger.getLogger(Test.class);
	public static void main(String[] args) {
		
		
		UserMetier metier = (UserMetier) ContextUtil.getContext().getBean("metier"); 
		ContextUtil.getContext().close();
		
		Auteur auteur = (Auteur) metier.finByOne(new Integer(1));
	
		Qcm q  = auteur.getQcms().get(0);

		System.out.println(q.getTitre());

	}

}
