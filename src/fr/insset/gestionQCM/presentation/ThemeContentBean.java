package fr.insset.gestionQCM.presentation;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.insset.gestionQCM.dao.entity.Page;
import fr.insset.gestionQCM.dao.entity.Question;
import fr.insset.gestionQCM.dao.entity.Theme;
import fr.insset.gestionQCM.metier.PageMetier;
import fr.insset.gestionQCM.metier.QuestionMetier;
import fr.insset.gestionQCM.metier.ThemeMetier;
import fr.insset.gestionQCM.utils.ContextUtil;
import fr.insset.gestionQCM.utils.SessionUtil;

@ManagedBean(name="bean")
@SessionScoped
public class ThemeContentBean implements Serializable {
	
	

	private static final long serialVersionUID = 1L;

	public ThemeContentBean() {
		super();
		
	}

	private String questText;
	
	private List<Page> listPage;
	
	@PostConstruct
	public void initBean(){
		
		HttpSession hs = SessionUtil.getSession();
		ThemeMetier metier = (ThemeMetier) ContextUtil.getContext().getBean("ThemeMetier"); 
		ContextUtil.getContext().close();

		Theme theme = metier.getById((Integer)hs.getAttribute("idTheme"));
		
		listPage = theme.getListPages();
		
	}
	
	
	public void addQuestion(){
		if(!questText.trim().isEmpty()){		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, String> param = ec.getRequestParameterMap(); 
	
		QuestionMetier metier = (QuestionMetier) ContextUtil.getContext().getBean("QuestionMetier"); 
		ContextUtil.getContext().close();
		Question qst = new Question();
		qst.setEstMarquee(false);
		qst.setIdPage(Integer.valueOf(param.get("idPage")));
		qst.setTextQuestion(questText);
		metier.addQuestion(qst);
		initBean();
		questText = "";
		
		
		}
	}
	
	public void deleteQuestion(){
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, String> param = ec.getRequestParameterMap();
		QuestionMetier metier = (QuestionMetier) ContextUtil.getContext().getBean("QuestionMetier"); 
		ContextUtil.getContext().close();
		metier.deleteQuestion(Integer.valueOf(param.get("idQst")));
		initBean();
	}

	
	public void addPage() throws IOException{
		HttpSession hs = SessionUtil.getSession();
		PageMetier metier = (PageMetier) ContextUtil.getContext().getBean("PageMetier"); 
		ContextUtil.getContext().close();
		Page p = new Page();
		p.setIdTheme((Integer)hs.getAttribute("idTheme"));
		metier.addPage(p);
		initBean();
		questText = "";
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
		
		
	}
	public List<Page> getListPage() {
		return listPage;
	}

	public void setListPage(List<Page> listPage) {
		this.listPage = listPage;
	}


	public String getQuestText() {
		return questText;
	}


	public void setQuestText(String questText) {
		this.questText = questText;
	}
	
	
	
	
	
	

}
