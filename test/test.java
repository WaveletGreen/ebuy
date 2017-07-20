import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import util.HibernateSessionFactory;
import entity.ChatContent;
import entity.TUser;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		toS("TUser");
		getjSON();
	}

	private static void getjSON() {
		/*
		 * Map<String, Object> map = new HashMap<String, Object>();
		 * map.put("username", "tomcat"); map.put("password", "123456");
		 * JSONObject object = JSONObject.fromObject(map);
		 * System.out.println(object.toString());
		 */
		getContent();
	}

	private static void getContent() {
		Session session = HibernateSessionFactory.getSession();
		ChatContent content = (ChatContent) session.get(ChatContent.class, 1);
		System.out.println(content.getChatContents());
		System.out.println(JSONArray.fromObject(content.getChatContents()));
		List<String> list = JSONArray.toList(JSONArray.fromObject(content.getChatContents()));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static <T> void toS(T t) {

		System.out.println(t.toString());
	}

}
