package chapter07;
/*
 * 생성자 오버로딩, this()메소드
 */
public class Animal3 {
	// Field
	int age;
	String name;
	String addr;
	
	// Constructor
	public Animal3() {
		this("홍길동",5,"강남");
	}
	public Animal3(String name) {
		// this() 사용 : 파라미터가 3개(모든 필드값 초기화)를 호출하여 생성자 생성
		this(name,5,"강남");
//		this.name = name;
//		this.age  = 5;
//		this.addr = "강남";		
	}
	public Animal3(int age) {
		this("홍길동",age,"강남");	
//		this.age = age;
	}
	public Animal3(String name, int age) {
		this(name,age,"강남");	
//		this.name = name;
//		this.age = age;
	}
	public Animal3(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	// Method
	public void info() {
		System.out.println("name : " + name);
		System.out.println("age  : " + age);
		System.out.println("addr : " + addr);
	}
	
	
}
