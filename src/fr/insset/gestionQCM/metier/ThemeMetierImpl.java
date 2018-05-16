package fr.insset.gestionQCM.metier;

import fr.insset.gestionQCM.dao.ThemeDAO;
import fr.insset.gestionQCM.dao.entity.Theme;

public class ThemeMetierImpl implements ThemeMetier {
	
	private ThemeDAO themeDao;
	
	
	

	public void setThemeDao(ThemeDAO themeDao) {
		this.themeDao = themeDao;
	}

	@Override
	public Theme addTheme(Theme t) {
		return themeDao.addTheme(t);
	}

	@Override
	public void deleteTheme(Integer id) {
		themeDao.deleteTheme(id);
		
	}

	@Override
	public Theme getById(Integer id) {
		return themeDao.getById(id);
	}

}
