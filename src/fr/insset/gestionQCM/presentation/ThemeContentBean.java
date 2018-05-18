package fr.insset.gestionQCM.presentation;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import fr.insset.gestionQCM.dao.entity.Page;
import fr.insset.gestionQCM.dao.entity.Theme;
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

	private List<Page> listPage;
	
	@PostConstruct
	public void initBean(){
		
		HttpSession hs = SessionUtil.getSession();
		ThemeMetier metier = (ThemeMetier) ContextUtil.getContext().getBean("ThemeMetier"); 
		ContextUtil.getContext().close();

		Theme theme = metier.getById((Integer)hs.getAttribute("idTheme"));
		
		listPage = theme.getListPages();
		
	}
	

	public List<Page> getListPage() {
		return listPage;
	}

	public void setListPage(List<Page> listPage) {
		this.listPage = listPage;
	}
	
	
	
	
	
	

}
