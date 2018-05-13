package fr.insset.gestionQCM.utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextUtil {

	
	public static ClassPathXmlApplicationContext getContext(){
		
		return  new ClassPathXmlApplicationContext(new String[]{"config/config.xml"});
		
		
	}
	
}
