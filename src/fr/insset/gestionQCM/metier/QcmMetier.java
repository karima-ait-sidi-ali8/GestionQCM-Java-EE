package fr.insset.gestionQCM.metier;



import fr.insset.gestionQCM.dao.entity.Groupe;
import fr.insset.gestionQCM.dao.entity.Qcm;

public interface QcmMetier {

	public Qcm addQcm(Qcm q);
	
	public Qcm findByOne(Integer id);
	
	public void deleteQcm(Integer id);
	
	public void AffectQcmToGroupe(Integer id , Groupe g);
	
	public Qcm UpdateQcm(Qcm q);
	
	public boolean isAffect(Integer idq, Integer idg);
	
}
