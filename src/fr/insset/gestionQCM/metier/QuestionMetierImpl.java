package fr.insset.gestionQCM.metier;

import fr.insset.gestionQCM.dao.QuestionDAO;
import fr.insset.gestionQCM.dao.entity.Question;

public class QuestionMetierImpl implements QuestionMetier {
	
	private QuestionDAO questionDAO;
	
	

	public void setQuestionDAO(QuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}

	@Override
	public Question addQuestion(Question q) {
		return questionDAO.addQuestion(q);
	}

	@Override
	public void deleteQuestion(Integer id) {
		questionDAO.deleteQuestion(id);
		
	}

	@Override
	public Question getById(Integer id) {
		return questionDAO.getById(id);
	}

	@Override
	public void UpdateQuestion(Question q) {
		questionDAO.UpdateQuestion(q);
		
	}

}
