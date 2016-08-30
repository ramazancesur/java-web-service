package com.tutev.web.service.impl;

import java.util.List;

import com.tutev.web.entity.Kullanici;

public interface IKullaniciService {
	
	public Kullanici getById(Long id);
	
	public List<Kullanici> getAll();
	
	public void delete(Kullanici kullanici);
	
	public void update(Kullanici kullanici);
	
	public Kullanici getByUserNamePassword(Kullanici kullanici);

}
