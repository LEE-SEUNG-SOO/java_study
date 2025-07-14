package chapter08;

public class Person extends Client {
	String name;
	String addr;
	String phone;
	int age;
	
	public Person() {
		this("이순신", "강남구", "010-1234-5678", 20);
	}

	public Person(String name, String addr, String phone, int age) {
		// name, age 필드는 부모 클래스에서 사용
		// 생성자에서만 사용되는 메소드, 부모 관계에서만 사용하는 메소드
		// super() : 부모 클래스의 생성자를 호출 하는 메소드
//		super(); // Client() 생성자 호출
//		super(name,age); // Client(name, age) 생성자 호출
		this.name = name;
		this.addr = addr;
		this.phone = phone;
		this.age = age;
		System.out.println("Person 생성자 호출");
	}
	
	@Override
	public void printInfo() {	// 부모가 가진 메소드를 똑같은 모습으로 가져온다 => 오버라이딩(Overriding)
		System.out.print("Person Info : ");
		System.out.print(name + ",");
		System.out.print(age + ",");
		System.out.print(addr + ",");
		System.out.println(phone);
	}

	@Override
	public void register() {
		System.out.println(name + " 고객이 접수를 한다.");
	}

	@Override
	public void payment() {
		
	}
}
