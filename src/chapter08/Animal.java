package chapter08;

public class Animal extends Client {
	String name;
	int age;
	Person owner;
	
	public Animal() {
		this("예삐",5, new Person());
	}
	
	public Animal(String name, int age, Person owner) {
//		super(name,age); // Client(name, age) 생성자 호출
		this.owner = owner;
		this.name = name;
		this.age = age;
		System.out.println("Animal 생성자 호출");
	}
	
	public void sound() {
		System.out.println(name + " 짖는다"); // 부모의 name 사용
	}
	
	// 고객 정보 출력시 owner정보를 포함해서 출력
	@Override
	public void printInfo() {	// 부모가 가진 메소드를 똑같은 모습으로 가져온다 => 오버라이딩(Overriding)
		System.out.print("Animal Info : ");
		System.out.print(name + ",");
		System.out.print(age + ",");
		System.out.print(owner.name + ",");
		System.out.print(owner.age + ",");
		System.out.print(owner.addr + ",");
		System.out.println(owner.phone);
	}

	@Override
	public void register() {
		System.out.println(owner.name + " 고객이 접수를 한다.");
	}

	@Override
	public void payment() {
		
	}
	
}
