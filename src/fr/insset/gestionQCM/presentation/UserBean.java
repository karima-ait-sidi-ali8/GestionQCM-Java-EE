package fr.insset.gestionQCM.presentation;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;



@ManagedBean(name="UserLogin")
@RequestScoped
public class UserBean {
	public Logger log = Logger.getLogger(UserBean.class);
	private String email;
	private String password;
	public UserBean() {
		super();
	}
	public UserBean(Logger log, String email, String password) {
		super();
		this.log = log;
		this.email = email;
		this.password = password;
	}
	
	@PostConstruct
	public void initBean(){
		this.email = "frifita1@gmail.com";
		
	}
	public Logger getLog() {
		return log;
	}
	public void setLog(Logger log) {
		this.log = log;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
