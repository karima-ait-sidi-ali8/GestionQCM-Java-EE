package fr.insset.gestionQCM.dao;





import org.apache.log4j.Logger;


import fr.insset.gestionQCM.metier.UserMetier;
import fr.insset.gestionQCM.utils.ContextUtil;




public class Test {
	public static Logger log = Logger.getLogger(Test.class);
	public static void main(String[] args) {
		
		
		UserMetier metier = (UserMetier) ContextUtil.getContext().getBean("metier"); 
		ContextUtil.getContext().close();
		
	

	}

}
