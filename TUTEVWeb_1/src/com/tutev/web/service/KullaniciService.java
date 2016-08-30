package com.tutev.web.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tutev.web.dao.impl.IKullaniciDao;
import com.tutev.web.entity.Kullanici;
import com.tutev.web.service.impl.IKullaniciService;

@Transactional(readOnly = true)
public class KullaniciService implements IKullaniciService {

	IKullaniciDao kullaniciDao;

	@Transactional
	@Override
	public void delete(Kullanici kullanici) {
		getKullaniciDao().delete(kullanici);
	}


	@Transactional
	@Override
	public List<Kullanici> getAll() {
		return getKullaniciDao().getAll();
	}
	
	@Transactional
	@Override
	public Kullanici getByUserNamePassword(Kullanici kullanici) {
		Kullanici kullaniciDb=getKullaniciDao().getByUserNamePassword(kullanici);
		return kullaniciDb;
	}

	@Transactional
	@Override
	public Kullanici getById(Long id) {
		return getKullaniciDao().getById(id);
	}

	@Transactional
	@Override
	public void update(Kullanici kullanici) {
		getKullaniciDao().update(kullanici);		
	}
	
	public IKullaniciDao getKullaniciDao() {
		return kullaniciDao;
	}
	
	public void setKullaniciDao(IKullaniciDao kullaniciDao) {
		this.kullaniciDao = kullaniciDao;
	}
}
