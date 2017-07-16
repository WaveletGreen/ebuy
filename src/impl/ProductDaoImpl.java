package impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateSessionFactory;

import dao.ProductDao;
import entity.TProduct;

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

	@Override
	public List<TProduct> getByTags(TProduct product, int startPage, int maxResult) {
		StringBuffer hql = new StringBuffer().append("from TProduct tp where 1=1 ");
		if (product.getHot() != null) {
		}
		hql.append("and tp.hot=:hot");
		if (product.getSpecialPrice() != null) {
			hql.append("and tp.specialPrice=:specialPrice");
		}
		if (product.getTBigtype() != null) {
			hql.append("and tp.TBigtype.id=:bigTypeId");
		}
		if (product.getTSmalltype() != null) {
			hql.append("and tp.TSmalltype.id=:smallTypeId");

		}
		Query query = session.createQuery(hql.toString());
		if (product.getHot() != null) {
			query.setInteger("hot", product.getHot());
		}
		if (product.getSpecialPrice() != null) {
			query.setShort("specialPrice", product.getSpecialPrice());
		}
		if (product.getTBigtype() != null) {
			query.setInteger("bigTypeId", product.getTBigtype().getId());
		}
		if (product.getTSmalltype() != null) {
			query.setInteger("smallTypeId", product.getTSmalltype().getId());
		}
		query.setFirstResult((startPage - 1) * maxResult);
		query.setMaxResults(maxResult);
		List<TProduct> items = query.list();
		return items;
	}

}
