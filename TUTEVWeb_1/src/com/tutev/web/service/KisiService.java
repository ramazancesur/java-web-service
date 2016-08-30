package com.tutev.web.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tutev.web.dao.impl.IKisiDao;
import com.tutev.web.entity.Kisi;
import com.tutev.web.service.impl.IKisiService;

@Transactional(readOnly = true)
public class KisiService implements IKisiService{
	
	IKisiDao kisiDao;
	
	@Transactional
	@Override
	public Kisi getById(Long id) {
		return getKisiDao().getById(id);
	}
	
	@Transactional
	@Override
	public void delete(Kisi kisi) {
		getKisiDao().delete(kisi);
	}
	
	@Transactional
	@Override
	public List<Kisi> getAll() {
		return getKisiDao().getAll();
	}
	
	@Transactional
	@Override
	public void update(Kisi kisi) {
		getKisiDao().update(kisi);
	}
	
	public IKisiDao getKisiDao() {
		return kisiDao;
	}
	
	public void setKisiDao(IKisiDao kisiDao) {
		this.kisiDao = kisiDao;
	}
	
}
