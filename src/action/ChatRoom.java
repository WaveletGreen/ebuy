package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class ChatRoom extends ActionSupport implements ApplicationAware, SessionAware {
	private Map<String, Object> session;
	private Map<String, Object> application;
	private String timed;
	private String msg;
	private JSONObject jsonObject;

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTimed() {
		return timed;
	}

	public void setTimed(String timed) {
		this.timed = timed;
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

	public String publish() throws IOException {
		System.out.println("--------" + timed);
		Map<String, String> msg = new HashMap<String, String>();
		msg.put("gg", "gl");
		msg.put("1", "55");
		msg.put("2", "88");
		// jsonObject = JSONObject.fromObject(msg);
		// // HttpServletResponse response = ServletActionContext.getResponse();
		// // response.setCharacterEncoding("UTF-8");
		// // response.getWriter().print(jsonObject);
		// System.out.println(jsonObject.toString());
		return SUCCESS;
	}
}
