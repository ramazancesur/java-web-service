package com.tutev.web.managedbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.tutev.web.entity.Kullanici;
import com.tutev.web.service.impl.IKullaniciService;

@ManagedBean(name="loginMB")
@RequestScoped
public class LoginManagedBean implements Serializable{

	private static final long serialVersionUID = 7261398347826935912L;
	
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	@ManagedProperty(value="#{KullaniciService}")
	IKullaniciService kullaniciService;
	
	Kullanici kullanici;
	
	@PostConstruct
	private void init() {
	kullanici=new Kullanici();

	}
	
	public String login() {
		Kullanici kullaniciDb=getKullaniciService().getByUserNamePassword(this.getKullanici());
		if(kullaniciDb!=null && kullaniciDb.getId()!=null){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}

	public Kullanici getKullanici() {
		return kullanici;
	}
	
	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}
	
	public IKullaniciService getKullaniciService() {
		return kullaniciService;
	}
	
	public void setKullaniciService(IKullaniciService kullaniciService) {
		this.kullaniciService = kullaniciService;
	}
}
