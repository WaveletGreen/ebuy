package action;

import impl.UserDaoimpl;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;

import entity.TUser;

public class UserCommon extends ActionSupport {

	private static final long serialVersionUID = 2939523652393343997L;

	private UserDao dao = new UserDaoimpl();

	private TUser user;

	public TUser getUser() {
		return user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

	/**
	 * 登录方法
	 * 
	 * @return
	 */

	public String login() {
		TUser user = dao.login(this.user);
		if (user != null)
			return SUCCESS;
		else {
			addFieldError("msg", "用户名或密码错误");
			return INPUT;
		}
	}

	/**
	 * 注册方法
	 * 
	 * @return
	 */
	public String register() {
		this.user.setStatus(1);
		dao.regist(this.user);
		return SUCCESS;
	}
}
