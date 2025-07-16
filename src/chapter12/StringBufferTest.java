package chapter12;

public class StringBufferTest {

	public static void main(String[] args) {
		String str = "홍길동";
		str += "은 자바를";
		str += " 열심히 공부한다.";
		
		System.out.println(str);
		
		StringBuffer sb = new StringBuffer(); // 16
		System.out.println(sb.capacity());
		System.out.println(sb.length());
		
		sb.append("홍길동");
		sb.append("은 자바를");
		sb.append(" 열심히 공부한다.");
		System.out.println(sb.toString());
		System.out.println(sb);
		System.out.println(sb.capacity());
		System.out.println(sb.length());	
		
	}
}
