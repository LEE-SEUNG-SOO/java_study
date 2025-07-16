package chapter12;

public class StringTest {

	public static void main(String[] args) {
		String name1 = "홍길동";
		String name2 = new String("홍길동");
		String num = String.valueOf(123);
		String upper = "welcomeToJava!!";
		String phone = "010-1234-5678";
		String subject = "java,css,html,mysql";
		String[] phones = phone.split("-");
		String[] subjects = subject.split(",");
		String jphone = String.join("-" , phones);
		
		for(String s : phones) {
			System.out.print(s + " ");
		}		
		System.out.println();		
		
		for(String s : subjects) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		System.out.println(jphone);
		System.out.println(subject.contains("html"));
		
		System.out.println("----------------------------------");
		System.out.println(upper);
		System.out.println(upper.toUpperCase());
		System.out.println(upper.toLowerCase());
		
		System.out.println(upper.length());
		System.out.println(upper.substring(7));
		System.out.println(upper.substring(7, 10));
		System.out.println("----------------------------------");
		
		System.out.println(name1.hashCode());
		System.out.println(name2.hashCode());
		System.out.println("----------------------------------");
		
		System.out.println(System.identityHashCode(name1));
		System.out.println(System.identityHashCode(name2));
		System.out.println("----------------------------------");
		System.out.println(num+10); // 123(문자) + 10 => 12310
		
		if(name1 == name2) {
			System.out.println("같음");
		} else {
			System.out.println("다름");
		}
		
		if(name1.equals(name2)) {
			System.out.println("같음");
		} else {
			System.out.println("다름");
		}
		
		
	}

}
