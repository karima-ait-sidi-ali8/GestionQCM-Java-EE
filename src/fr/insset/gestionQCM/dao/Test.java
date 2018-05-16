package fr.insset.gestionQCM.dao;





import java.util.List;

import org.apache.log4j.Logger;

import fr.insset.gestionQCM.dao.entity.Qcm;
import fr.insset.gestionQCM.dao.entity.Theme;
import fr.insset.gestionQCM.metier.QcmMetier;

import fr.insset.gestionQCM.utils.ContextUtil;




public class Test {
	public static Logger log = Logger.getLogger(Test.class);
	public static void main(String[] args) {
		
		
		QcmMetier metier = (QcmMetier) ContextUtil.getContext().getBean("qcmMetier"); 
		ContextUtil.getContext().close();


	}

}
