package chapter08;

// 추상 메소드를 하나라도 가지고 있다면 클래스자체도 추상 클래스가 되어야함
// abstract 클래스는 객체 생성이 불가능하다.
abstract public class Client {
	public static String name;
	public static int age;
	
//	public Client() {
//		this("홍길동", 10);
//	}		
//	
//	public Client(String name) {
//		this(name, 10);
//	}	
//	
//	public Client(String name, int age) {
//		this.name = name;
//		this.age = age;
//		System.out.println("Client 생성자 호출");
//	}	
	
	// Method
//	public void printInfo() {	// 부모가 가진 printInfo 메소드를 강제적으로 상속함
//		System.out.println("Client Info : " + name + "," + age);
//	}
	
	// overriding
	// 오버라이드되는 메소드는 body 없이 이름만 선언
	// body가 없는 메소드를 추상(abstract)메소드라고 부름
	abstract public void printInfo(); // 부모가 가진 printInfo 메소드를 강제적으로 상속함
	abstract public void register();
	abstract public void payment();
	
}
