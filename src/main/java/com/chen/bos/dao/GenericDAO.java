package com.chen.bos.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface GenericDAO<T, PK extends Serializable> {

	// 保存
	public void save(T entity);

	// 修改
	public void update(T entity);

	// 删除
	public void delete(T entity);

	// 根据主键查询
	public T findById(PK id);

	// 查询所有
	public List<T> findAll();

	// 条件查询
	public List<T> findByNamedQuery(String queryName, Object... params);

	public List<T> findByDetachedCriteria(DetachedCriteria detachedCriteria);
}
