package fr.insset.gestionQCM.dao;





import org.apache.log4j.Logger;


import fr.insset.gestionQCM.metier.QuestionMetier;

import fr.insset.gestionQCM.utils.ContextUtil;




public class Test {
	public static Logger log = Logger.getLogger(Test.class);
	public static void main(String[] args) {
		
		
		QuestionMetier metier = (QuestionMetier) ContextUtil.getContext().getBean("QuestionMetier"); 
		ContextUtil.getContext().close();

	
	}

}
