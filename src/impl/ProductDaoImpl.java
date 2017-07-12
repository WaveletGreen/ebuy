package impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateSessionFactory;

import dao.ProductDao;

public class ProductDaoImpl<T> implements ProductDao<T> {
	Session session;

	public ProductDaoImpl() {
		session = HibernateSessionFactory.getSession();
	}

	@Override
	public List<T> findAllItem(T t) {
		String hql = "from " + t.toString();
		Query query = session.createQuery(hql);
		List<T> list = query.list();
		return list;
	}

	@Override
	public T getById(T t, int id) {
		String hql = "from " + t.toString() + " where id=:id";
		Query query = session.createQuery(hql);
		query.setInteger("id", id);
		T entity = (T) query.uniqueResult();
		return entity;
	}

	@Override
	public List<T> getByPage(T t, int startPage, int maxResult) {
		String hql = "from " + t.toString();
		Query query = session.createQuery(hql);
		query.setFirstResult((startPage - 1) * maxResult);
		query.setMaxResults(maxResult);
		List<T> items = query.list();
		return items;
	}

}
