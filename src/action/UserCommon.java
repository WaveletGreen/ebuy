package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import impl.UserDaoimpl;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;

import entity.TUser;

/**
 * 简单实现用户登录注册功能
 * 
 * @author Administrator
 * 
 */
public class UserCommon extends ActionSupport implements ApplicationAware,
		SessionAware {
	private Map<String, Object> session;
	private Map<String, Object> application;
	private static final long serialVersionUID = 2939523652393343997L;

	private UserDao dao = new UserDaoimpl();

	private TUser user;

	public TUser getUser() {
		return user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getApplication() {
		return application;
	}

	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	/**
	 * 登录方法
	 * 
	 * @return
	 */

	public String login() {
		TUser user = dao.login(this.user);
		if (user != null) {
			session.put("user", user);
			List<TUser> list = new ArrayList<TUser>();
			if (application.containsKey("userList")) {
				list = (List<TUser>) application.get("userList");
			}
			if (!list.contains("user")) {
				list.add(user);
			}
			application.put("userList", list);
			return "toIndex";
		} else {
			addFieldError("msg", "用户名或密码错误");
			return INPUT;
		}
	}

	public String logout() {
		if (session != null) {
			if (application != null) {
				((List<TUser>) application.get("userList")).remove(session
						.get("user"));
			}
			((HttpSession) session).invalidate();
		}
		return SUCCESS;
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
