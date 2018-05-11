package fr.insset.gestionQCM.metier;

import fr.insset.gestionQCM.dao.GroupeDAO;
import fr.insset.gestionQCM.dao.entity.Groupe;

public class GroupeMetierImpl implements  GroupeMetier {
	
	private GroupeDAO groupeDao ;
	
	
	
	public void setGroupeDao(GroupeDAO groupeDao) {
		this.groupeDao = groupeDao;
	}

	@Override
	public Groupe addGroupe(Groupe g) {
		
		return groupeDao.addGroupe(g);
	}

	@Override
	public void deleteGroupe(Integer id) {
		groupeDao.deleteGroupe(id);
		
	}

	@Override
	public Groupe findById(Integer id) {
		return groupeDao.findById(id);
	}


}
