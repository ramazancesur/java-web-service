package com.tutev.web.dao.impl;

import java.util.List;

import com.tutev.web.entity.Kullanici;

public interface IKullaniciDao {

	public Kullanici getById(Long id);
	
	public List<Kullanici> getAll();
	
	public void delete(Kullanici kullanici);
	
	public void update(Kullanici kullanici);
	
	public void save(Kullanici kullanici);
	
	public Kullanici getByUserNamePassword(Kullanici kullanici);

}
