package com.tutev.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.tutev.web.dao.impl.IKisiDao;
import com.tutev.web.entity.Kisi;
import com.tutev.web.entity.Kullanici;

public class KisiDao implements IKisiDao {
	
	SessionFactory sessionFactory;
	
	@Override
	public void delete(Kisi kisi) {
		getCurrentSession().delete(kisi);
	}

	@Override
	public List<Kisi> getAll() {
		return (List<Kisi>)getCurrentSession().createCriteria(Kisi.class);
	}

	@Override
	public Kisi getById(Long id) {
		
		Criteria criteria= getCurrentSession().createCriteria(Kisi.class);
		criteria.add(Restrictions.eq("id", id));
		Kisi kisi=(Kisi)criteria.uniqueResult();
		return kisi;
	}

	@Override
	public void save(Kisi kisi) {
		getCurrentSession().save(kisi);
	}

	@Override
	public void update(Kisi kisi) {
		getCurrentSession().update(kisi);
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getCurrentSession(){
		return getSessionFactory().getCurrentSession();
	}

}
