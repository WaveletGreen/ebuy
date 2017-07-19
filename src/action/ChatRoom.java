package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class ChatRoom extends ActionSupport implements ApplicationAware,
		SessionAware {
	private static final long serialVersionUID = 2100929331366765350L;
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
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gg", "gl");
		map.put("1", "55");
		map.put("2", "88");
		try {
			jsonObject = JSONObject.fromObject(map);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.msg = jsonObject.toString();
		System.out.println(this.msg);
		// // HttpServletResponse response = ServletActionContext.getResponse();
		// // response.setCharacterEncoding("UTF-8");
		// // response.getWriter().print(jsonObject);
		// System.out.println(jsonObject.toString());
		return SUCCESS;
	}
}
