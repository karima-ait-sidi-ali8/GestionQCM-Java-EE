package fr.insset.gestionQCM.dao;

import fr.insset.gestionQCM.dao.entity.Theme;

public interface ThemeDAO {
	
	
	public Theme addTheme(Theme t);
	
	public void deleteTheme(Integer id);
	
	public Theme getById(Integer id);

}
