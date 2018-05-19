package fr.insset.gestionQCM.dao;

import fr.insset.gestionQCM.dao.entity.Page;

public interface PageDAO {
	
	
	public Page addPage(Page p);
	
	public void deletePage(Integer id);

	public Page getById(Integer id);
}
