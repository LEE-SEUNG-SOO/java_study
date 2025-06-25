package chapter03;

/*
 * 제어문자 실습
 */
public class EscapeTest {

	public static void main(String[] args) {
		String greet = "안녕하세요.\n\n반갑습니다.\t홍길동입니다.";
		// "표시 방법. \" ('도 동일)
		String name = "\"홍길동\"";
		
		System.out.println(greet);
		System.out.println(name);

	}

}
