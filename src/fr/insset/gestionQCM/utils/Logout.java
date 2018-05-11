package fr.insset.gestionQCM.utils;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class Logout {
	
	
	public static void logOut(){
		
		HttpSession hs = SessionUtil.getSession();
		hs.invalidate();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().responseComplete();
	}

}
