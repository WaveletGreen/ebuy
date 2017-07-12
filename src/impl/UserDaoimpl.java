package impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateSessionFactory;

import dao.UserDao;
import entity.TUser;

public class UserDaoimpl implements UserDao {
	private Session session;

	public UserDaoimpl() {
		session = HibernateSessionFactory.getSession();
	}

	@Override
	public TUser login(TUser user) {
		if (user != null) {
			Query query = session
					.createQuery("from TUser where username=:username and password=:password");
			query.setString("username", user.getUsername());
			query.setString("username", user.getPassword());
			// 为了回显，不能直接将传进来user改掉，除非成功才能改
			TUser user2 = (TUser) query.uniqueResult();
			if (user2 != null) {
				user = user2;
				return user;
			}
		}
		return null;
	}

	@Override
	public String regist(TUser user) {
		Transaction tx=session.beginTransaction();
		session.save(user);
		tx.commit();
		return "success";
	}

}
