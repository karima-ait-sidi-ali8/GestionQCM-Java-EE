package fr.insset.gestionQCM.dao;

import fr.insset.gestionQCM.dao.entity.Question;

public interface QuestionDAO {
	
	public Question addQuestion(Question q);
	
	public void deleteQuestion(Integer id);
	
	public Question getById(Integer id);
	
	public void UpdateQuestion(Question q);
	
	
	

}
