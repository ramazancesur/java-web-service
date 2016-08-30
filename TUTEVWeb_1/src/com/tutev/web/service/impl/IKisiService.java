package com.tutev.web.service.impl;

import java.util.List;

import com.tutev.web.entity.Kisi;

public interface IKisiService {
	
	public Kisi getById(Long id);
	
	public List<Kisi> getAll();
	
	public void delete(Kisi kisi);
	
	public void update(Kisi kisi);
}
