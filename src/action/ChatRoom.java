package action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import entity.TUser;

public class ChatRoom extends ActionSupport implements ApplicationAware,
		SessionAware {
	Map<String, TUser> session;
	Map<String, List<TUser>> application;

	@Override
	public void setSession(Map<String, Object> arg0) {

	}

	@Override
	public void setApplication(Map<String, Object> arg0) {

	}

}
