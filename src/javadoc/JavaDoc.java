package javadoc;
/**
 * JavaDoc 문서를 생성하는 클래스 입니다.
 */
public class JavaDoc {
	// Field
	private String name;
	private int age;
	
	// Construct
	/**
	 * 기본 생성자 입니다.
	 */
	public JavaDoc() {
		
	}	
	
	/**
	 * 문자열 타입의 name 파라미터를 받아 객체를 생성합니다.
	 * @param name 이름
	 */
	public JavaDoc(String name) {
		this.name = name;
	}

	/**
	 * 문자열 타입의 name과 정수형 타입의 age 파라미터를 받아 객체를 생성합니다.
	 * @param name 이름
	 * @param age 나이
	 */
	public JavaDoc(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * 문자열 타입의 이름을 반환합니다.
	 * @return name 이름
	 */
	public String getName() {
		return name;
	}

	/**
	 * 문자열 타입의 이름을 입력받아 멤버 변수의 name을 설정합니다.
	 * @param name 이름
	 */
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	// Method
	
}
