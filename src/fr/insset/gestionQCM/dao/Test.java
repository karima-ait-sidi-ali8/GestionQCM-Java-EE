package fr.insset.gestionQCM.dao;





import org.apache.log4j.Logger;

import fr.insset.gestionQCM.dao.entity.Reponse;
import fr.insset.gestionQCM.metier.ReponseMetier;
import fr.insset.gestionQCM.utils.ContextUtil;




public class Test {
	public static Logger log = Logger.getLogger(Test.class);
	public static void main(String[] args) {
		
		
		ReponseMetier metier = (ReponseMetier) ContextUtil.getContext().getBean("ReponseMetier"); 
		ContextUtil.getContext().close();

		
	}

}
