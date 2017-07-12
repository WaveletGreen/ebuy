package dao;

import entity.TUser;

public interface UserDao {
	/**
	 * 用户登录
	 * 
	 * @param user
	 *            登录页面传进来的用户
	 * @return
	 */
	public TUser login(TUser user);

	/**
	 * 用户注册
	 * 
	 * @return
	 */
	public String regist(TUser user);
}
