package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import entity.ChatContent;
import entity.TUser;
import net.sf.json.JSONArray;
import util.HibernateSessionFactory;

public class ChatRoom extends ActionSupport implements ApplicationAware, SessionAware {
	private static final long serialVersionUID = 2100929331366765350L;
	private Map<String, Object> session;
	private Map<String, Object> application;
	private String content;
	private String timed;
	private String msg;
	private JSONArray jsonObject;
	private List<TUser> userList;
	private List<String> contents;
	private String appIndex;
	private String talker;// 说话的人

	public String getTalker() {
		return talker;
	}

	public void setTalker(String talker) {
		this.talker = talker;
	}

	public String getAppIndex() {
		return appIndex;
	}

	public void setAppIndex(String appIndex) {
		this.appIndex = appIndex;
	}

	public List<String> getContents() {
		return contents;
	}

	public void setContents(List<String> contents) {
		this.contents = contents;
	}

	public String getTimed() {
		return timed;
	}

	public void setTimed(String timed) {
		this.timed = timed;
	}

	public List<TUser> getUserList() {
		return userList;
	}

	public void setUserList(List<TUser> userList) {
		this.userList = userList;
	}

	public JSONArray getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONArray jsonObject) {
		this.jsonObject = jsonObject;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	@SuppressWarnings("unchecked")
	public String getChatRoom() {
		HttpSession session = ((HttpServletRequest) ServletActionContext.getRequest()).getSession();
		userList = (List<TUser>) application.get("userList");
		if (userList != null && session.getAttribute("user") != null) {
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	/**
	 * 浏览器拉取聊天信息 1.当前浏览器处于活动状态，推拉内容由当前浏览器消息标识符index从application中获取
	 * 
	 * 2.先前浏览器处于非活动状态（离线状态），获取历史内容
	 * 
	 * 
	 * 先完成拉取
	 * 
	 * @return
	 * @throws IOException
	 */
	public String pullContent() throws IOException {
		ServletContext context = ServletActionContext.getServletContext();
		contents = (List<String>) context.getAttribute("contents");
		if (contents == null) {
			msg = null;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			try {
				// 在浏览器那边要解析json对象
				if (appIndex != null && contents.size() > 0) {
					// 传入了索引，则查询索引之后的，表示浏览器处于活动状态
					int index = Integer.parseInt(appIndex);
					// System.out.println("---------" + index);
					// System.out.println("---------" + contents.size());
					List<String> msg = new ArrayList<String>();
					if (index > contents.size()) {
						index = contents.size() - 1;
					}
					msg = contents.subList(index, contents.size());
					jsonObject = JSONArray.fromObject(msg);
				} else {
					// 浏览器之前不处于活动状态，获取全部的历史记录
					jsonObject = JSONArray.fromObject(contents);
					appIndex = "0";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.msg = jsonObject.toString();
		}
		return SUCCESS;
	}

	/**
	 * 浏览器推送聊天内容到服务器，由服务器转发到监听服务器的浏览器上
	 * 
	 * @return
	 * @throws IOException
	 */
	public String pushContent() throws IOException {
		System.out.println("--------" + content);
		if (content != null) {
			// 获取ServletContext对象，以便获取内容
			ServletContext context = ServletActionContext.getServletContext();
			contents = (List<String>) context.getAttribute("contents");
			if (contents != null) {
				contents.add(content);
			} else {
				contents = new ArrayList<String>();
			}
			context.setAttribute("contents", contents);
		}
		return SUCCESS;
	}

	/**
	 * 计时任务，没五分钟完成一次写入数据库，谁来通知启动这个计时任务呢？但是不是不能因为个别用户第一次访问聊天室的时候调用写入方法
	 * 
	 * ，因此需要将用户的index设为appIndex，即第一次访问聊天室之后要设置用户聊天历史所用为服务器当前历史聊天的最大值-1，
	 * 这部分内容需要在jsp页面上写标记，并且在初始化的时候标记为appIndex最大值
	 */
	private static void ticker() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				ServletContext context = ServletActionContext.getServletContext();
				List<String> contents = (List<String>) context.getAttribute("contents");
				if (contents != null) {
					// 将消息持久化，则contents应该是序列化对象
					Session hsession = HibernateSessionFactory.getSession();
					Transaction tx = hsession.beginTransaction();
					ChatContent chatContent = new ChatContent();
					JSONArray array = JSONArray.fromObject(contents);
					System.out.println(array.toString());
					chatContent.setChatContents(array.toString());
					hsession.save(chatContent);
					tx.commit();
					// 清空所有消息
					contents = null;
					// 新生成容器
					contents = new ArrayList<String>();
					// 添加去除的第一条消息，所以每次打开都会显示最后一条记录，显然是bug
					context.setAttribute("contents", contents);
					System.out.println("--------写入数据库后的数值---------" + contents.size());
				}
			}
		}, 1000 * 20);
	}
}
