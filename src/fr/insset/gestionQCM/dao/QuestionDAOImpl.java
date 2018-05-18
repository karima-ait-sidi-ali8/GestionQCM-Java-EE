package fr.insset.gestionQCM.dao;

import org.hibernate.Session;

import fr.insset.gestionQCM.dao.entity.Question;
import fr.insset.gestionQCM.utils.HibernateUtil;

public class QuestionDAOImpl implements QuestionDAO {

	Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public Question addQuestion(Question q) {
		session.beginTransaction();
		Question question = (Question) session.merge(q);
		session.getTransaction().commit();
		return question;
	}

	@Override
	public void deleteQuestion(Integer id) {
		try{
			Question q = getById(id);
			session.beginTransaction();
			session.delete(q);
			session.getTransaction().commit();
			
		}catch(RuntimeException re){
			session.getTransaction().rollback();
			throw re;
		}
		
	}

	@Override
	public Question getById(Integer id) {
		return (Question) session.get(Question.class, id);
	}

	@Override
	public void UpdateQuestion(Question q) {
		session.beginTransaction();
		session.update(q);
		session.getTransaction().commit();
		
	}


}
