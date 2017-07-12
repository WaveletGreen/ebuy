import entity.TUser;


public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		toS("TUser");
	}
	public static <T> void toS(T t){
		
		System.out.println(t.toString());
	}
}
