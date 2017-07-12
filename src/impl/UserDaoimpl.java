package impl;

import org.hibernate.Session;

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
		 
		
		return null;
	}

	@Override
	public String regist() {
		return null;
	}

}
