package fr.insset.gestionQCM.metier;

import fr.insset.gestionQCM.dao.entity.Page;

public interface PageMetier {
	
	
	public Page addPage(Page p);
	
	public void deletePage(Integer id);

	public Page getById(Integer id);

}
