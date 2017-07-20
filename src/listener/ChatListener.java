package listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.ChatContent;
import entity.TUser;
import net.sf.json.JSONArray;
import util.HibernateSessionFactory;

/**
 * Application Lifecycle Listener implementation class ChatListener
 *
 */
@WebListener
public class ChatListener implements HttpSessionListener, HttpSessionAttributeListener, ServletContextListener,
		ServletContextAttributeListener {

	/**
	 * Default constructor.
	 */
	public ChatListener() {
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
	}

	/**
	 * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
	 */
	public void attributeAdded(ServletContextAttributeEvent event) {
	}

	/**
	 * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
	 */
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		List<String> contents = (List<String>) context.getAttribute("contents");
		Session hsession = HibernateSessionFactory.getSession();
		Transaction tx = hsession.beginTransaction();
		ChatContent chatContent = new ChatContent();
		JSONArray array = JSONArray.fromObject(contents);
		System.out.println(array.toString());
		chatContent.setChatContents(array.toString());
		hsession.save(chatContent);
		tx.commit();
		contents = null;
		context.setAttribute("contents", contents);

	}

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		TUser users = (TUser) session.getAttribute("user");
		if (users != null) {
			System.out.println(users.getUsername());
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent arg0) {

	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
	}

	/**
	 * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
	 */
	public void attributeReplaced(ServletContextAttributeEvent event) {
		ServletContext context = event.getServletContext();
		List<String> contents = (List<String>) context.getAttribute("contents");
		if (contents != null) {
			// 设定保存10条消息
			if (contents.size() == 11) {
				// 总要把最后一条去除
				String end = contents.get(contents.size() - 1);
				contents.remove(contents.size() - 1);
				System.out.println("-------监听器中的数值----------" + contents.size());
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
				contents.add(end);
				context.setAttribute("contents", contents);
				System.out.println("--------写入数据库后的数值---------" + contents.size());
			}
		}
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
	}

}
