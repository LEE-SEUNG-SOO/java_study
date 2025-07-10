package commons;
/*
 * 클래스 생성
 * 객체의 재사용성을 높이기 위해 작성
 */
public class Animal {
	// Field : 전역 변수
	String name;
	int age;
	
	public String publicName;
	public int publicAge;
	
	private String privateName;
	private int privateAge;
	private String privateAddr;
	private String privateColor;
	private int privateWeight;
	private int privateHeight;
	private boolean privateGender;

	// Constructor [접근제어자(public)] 생성자명(클래스명과 동일) ()
	public Animal(){ // 기본 생성자
		// 생성자 호출시 실행되는 내용 -> new Animal();
		System.out.println("객체를 생성한다.");
	}
	
	// Method [접근제어자(public)] [반환타입] [메소드명]()
	public void sleep() {
		String date = "20250703";
		System.out.println(name + " " + date+ " -> 잠을 잔다.");
	}

	public String getPrivateName() {
		return privateName;
	}

	public void setPrivateName(String privateName) {
		this.privateName = privateName;
	}

	public int getPrivateAge() {
		return privateAge;
	}

	public void setPrivateAge(int privateAge) {
		this.privateAge = privateAge;
	}

	public String getPrivateAddr() {
		return privateAddr;
	}

	public void setPrivateAddr(String privateAddr) {
		this.privateAddr = privateAddr;
	}

	public String getPrivateColor() {
		return privateColor;
	}

	public void setPrivateColor(String privateColor) {
		this.privateColor = privateColor;
	}

	public int getPrivateWeight() {
		return privateWeight;
	}

	public void setPrivateWeight(int privateWeight) {
		this.privateWeight = privateWeight;
	}

	public int getPrivateHeight() {
		return privateHeight;
	}

	public void setPrivateHeight(int privateHeight) {
		this.privateHeight = privateHeight;
	}

	public boolean isPrivateGender() {
		return privateGender;
	}

	public void setPrivateGender(boolean privateGender) {
		this.privateGender = privateGender;
	}
	
}
