package fr.insset.gestionQCM.metier;

import fr.insset.gestionQCM.dao.PageDAO;
import fr.insset.gestionQCM.dao.entity.Page;

public class PageMetierImpl implements PageMetier{
	
	private PageDAO pageDAO;
	
	

	public void setPageDAO(PageDAO pageDAO) {
		this.pageDAO = pageDAO;
	}

	@Override
	public Page addPage(Page p) {
	
		return pageDAO.addPage(p);
	}

	@Override
	public void deletePage(Integer id) {
		
		pageDAO.deletePage(id);
		
	}

	@Override
	public Page getById(Integer id) {
		
		return pageDAO.getById(id);
	}

}
