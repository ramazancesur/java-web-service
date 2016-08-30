package com.tutev.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.tutev.web.dao.impl.IKullaniciDao;
import com.tutev.web.entity.Kullanici;

public class KullaniciDao implements IKullaniciDao {
	
	SessionFactory sessionFactory;
	
	@Override
	public void save(Kullanici kullanici) {
		getCurrentSession().save(kullanici);
	}
	
	@Override
	public void delete(Kullanici kullanici) {
		getCurrentSession().delete(kullanici);
	}

	@Override
	public List<Kullanici> getAll() {
		return (List<Kullanici>)getCurrentSession().createCriteria(Kullanici.class);
	}

	@Override
	public Kullanici getById(Long id) {
		Criteria criteria= getCurrentSession().createCriteria(Kullanici.class);
		criteria.add(Restrictions.eq("id", id));
		Kullanici kullanici=(Kullanici)criteria.uniqueResult();
		return kullanici;
	}
	
	@Override
	public Kullanici getByUserNamePassword(Kullanici kullanici) {
		Criteria criteria= getCurrentSession().createCriteria(Kullanici.class);
		criteria.add(Restrictions.eq("kullaniciAdi", kullanici.getKullaniciAdi()));
		criteria.add(Restrictions.eq("sifre", kullanici.getSifre()));
		Kullanici kullaniciDb=(Kullanici)criteria.uniqueResult();
		return kullaniciDb;
	}

	@Override
	public void update(Kullanici kullanici) {
		getCurrentSession().update(kullanici);;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getCurrentSession(){
		return getSessionFactory().getCurrentSession();
	}
}
