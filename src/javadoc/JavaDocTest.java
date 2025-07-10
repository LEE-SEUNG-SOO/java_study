package javadoc;
/*
 * JavaDoc테스트
 */
public class JavaDocTest {

	public static void main(String[] args) {
		JavaDoc jdoc = new JavaDoc();
		
		jdoc.setName("홍길동");
		jdoc.setAge(10);

		System.out.println("이름 : " + jdoc.getName());
		System.out.println("나이 : " + jdoc.getAge());
		
	}

}
