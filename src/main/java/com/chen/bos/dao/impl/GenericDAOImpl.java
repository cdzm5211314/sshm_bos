package com.chen.bos.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.chen.bos.dao.GenericDAO;

public class GenericDAOImpl<T,PK extends Serializable> extends HibernateDaoSupport implements GenericDAO<T,PK> {
	
	private Class<T> entityClass;
	public GenericDAOImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}

	@Override
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}

	@Override
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
	}

	@Override
	public T findById(PK id) {
		return this.getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public List<T> findAll() {
		return this.getHibernateTemplate().loadAll(entityClass);
	}

	@Override
	public List<T> findByNamedQuery(String queryName, Object... params) {
		return this.getHibernateTemplate().findByNamedQuery(queryName, params);
	}

	@Override
	public List<T> findByDetachedCriteria(DetachedCriteria detachedCriteria) {
		return this.getHibernateTemplate().findByCriteria(detachedCriteria);
	}

}
