package chapter07;
/*
 *  접근 제어자
 */
public class AnimalAccessModifier {
	// Filed
	public String publicName; // 모든 곳에서 접근 가능
	public int publicAge; // 모든 곳에서 접근 가능

	String defaultName; // 같은 패키지에서 접근 가능
	int defaultAge; // 같은 패키지에서 접근 가능
	
	private String privateName; // 해당 클래스안에서만 접근 가능
	private int privateAge; // 해당 클래스안에서만 접근 가능
	
	static String sname; // 스태틱 변수, 클래스 변수
	static int sage; // 스태틱 변수, 클래스 변수
	
	final String fname = "홍길동"; // final => 외부에서 값을 변경할 수 없음.
	final int fage = 10; // final => 외부에서 값을 변경할 수 없음.
	
	// 상수 정의
	public static final int START = 0; // 표준 설정 방법
	public final static int CONTINUE = 1;
	final public static int END = -1;
	
	// Constructor
	public AnimalAccessModifier() {
		
	}
	
	public AnimalAccessModifier(String privateName, int privateAge) {
		this.privateName = privateName;
		this.privateAge = privateAge;
	}
	
	// Method
	// static Method
	void getInfo() {
		System.out.println("--getInfo실행--");
		System.out.println("privateName : " + privateName);
		System.out.println("privateAge : " + privateAge);
	}
	public void getInfo2() {
		System.out.println("--getInfo2실행--");
		System.out.println("privateName : " + privateName);
		System.out.println("privateAge : " + privateAge);
	}
	public static void getInfo3() {
		System.out.println("--getInfo3실행(static)--");
		System.out.println("staticName : " + sname);
		System.out.println("staticAge : " + sage);
	}
	
	// private로 설정한 변수를 출력가능하게 하는 메소드(getter)
	public String getPrivateName() {
		return privateName;
	}
	// private로 설정한 변수를 출력가능하게 하는 메소드(getter)
	public int getPrivateAge() {
		return privateAge;
	}
	
	// private로 설정한 변수에 값을 설정하는 메소드(setter)
	public void setPrivateName(String privateName) {
		this.privateName = privateName;
	}
	// private로 설정한 변수에 값을 설정하는 메소드(setter)
	public void setPrivateAge(int privateAge) {
		this.privateAge = privateAge;
	}
}
