package fr.insset.gestionQCM.metier;



import fr.insset.gestionQCM.dao.QcmDAO;
import fr.insset.gestionQCM.dao.entity.Groupe;
import fr.insset.gestionQCM.dao.entity.Qcm;

public class QcmMetierImpl implements QcmMetier {

	private QcmDAO qcmDao;

	public void setQcmDao(QcmDAO qcmDao) {
		this.qcmDao = qcmDao;
	}

	@Override
	public Qcm addQcm(Qcm q) {
		
		return qcmDao.addQcm(q);
	}

	@Override
	public Qcm findByOne(Integer id) {
		
		return qcmDao.findByOne(id);
	}

	@Override
	public void deleteQcm(Integer id) {
		qcmDao.deleteQcm(id);
		
	}

	@Override
	public void AffectQcmToGroupe(Integer id, Groupe g) {
		qcmDao.AffectQcmToGroupe(id, g);
		
	}

	@Override
	public Qcm UpdateQcm(Qcm q) {
		
		return qcmDao.UpdateQcm(q);
	}
	
	
	

}
