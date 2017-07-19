import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

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
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", "tomcat");
		map.put("password", "123456");
		JSONObject object = JSONObject.fromObject(map);
		System.out.println(object.toString());

	}

	public static <T> void toS(T t) {

		System.out.println(t.toString());
	}

}
