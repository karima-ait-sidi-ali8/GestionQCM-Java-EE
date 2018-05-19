package fr.insset.gestionQCM.dao;





import org.apache.log4j.Logger;

import fr.insset.gestionQCM.metier.PageMetier;


import fr.insset.gestionQCM.utils.ContextUtil;




public class Test {
	public static Logger log = Logger.getLogger(Test.class);
	public static void main(String[] args) {
		
		
		PageMetier metier = (PageMetier) ContextUtil.getContext().getBean("PageMetier"); 
		ContextUtil.getContext().close();

	
	}

}
