package fr.insset.gestionQCM.dao;





import org.apache.log4j.Logger;

import fr.insset.gestionQCM.dao.entity.Reponse;
import fr.insset.gestionQCM.metier.ReponseMetier;
import fr.insset.gestionQCM.metier.SessionMetier;
import fr.insset.gestionQCM.utils.ContextUtil;




public class Test {
	public static Logger log = Logger.getLogger(Test.class);
	public static void main(String[] args) {
		
		
		SessionMetier metier = (SessionMetier) ContextUtil.getContext().getBean("SessionMetier"); 
		ContextUtil.getContext().close();

		
	}

}
