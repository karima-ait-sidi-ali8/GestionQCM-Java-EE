package fr.insset.gestionQCM.metier;

import fr.insset.gestionQCM.dao.entity.Theme;

public interface ThemeMetier {
	
	public Theme addTheme(Theme t);
	
	public void deleteTheme(Integer id);
	
	public Theme getById(Integer id);

}
