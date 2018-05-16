package fr.insset.gestionQCM.dao;





import org.apache.log4j.Logger;


import fr.insset.gestionQCM.metier.ThemeMetier;
import fr.insset.gestionQCM.utils.ContextUtil;




public class Test {
	public static Logger log = Logger.getLogger(Test.class);
	public static void main(String[] args) {
		
		
		ThemeMetier metier = (ThemeMetier) ContextUtil.getContext().getBean("ThemeMetier"); 
		ContextUtil.getContext().close();

	


	}

}
