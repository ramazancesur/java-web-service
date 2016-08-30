package com.tutev.web.dao.impl;

import java.util.List;

import com.tutev.web.entity.Kisi;

public interface IKisiDao {
	
	public Kisi getById(Long id);
	
	public List<Kisi> getAll();
	
	public void delete(Kisi kisi);
	
	public void update(Kisi kisi);
	
	public void save(Kisi kisi);
}
