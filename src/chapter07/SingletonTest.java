package chapter07;
/*
 * Singleton 테스트
 */
public class SingletonTest {

	public static void main(String[] args) {
//		Singleton single = new Singleton(); // 생성자가 private이므로 접근불가
		
		Singleton single = Singleton.getInstance(); // Singleton의 getInstance 메소드를 통해 생성자의 주소를 받음
		Singleton single2 = Singleton.getInstance(); // Singleton의 getInstance 메소드를 통해 생성자의 주소를 받음

		System.out.println("single : " + single.getName());
		System.out.println("single2 : " + single2.getName());
		single.setName("홍");
		System.out.println("single : " + single.getName());
		System.out.println("single2 : " + single2.getName());
		
	}

}
