package zoo;
/**
 * 동물의 공통적인 속성 정의
 * 이름, 나이 
 */
public class Animal implements AnimalInterface {
	String name;
	int age;
	
	public Animal() {
		
	}
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public void sleep() {
		System.out.println(name + " 이(가) 잠을 잔다");
	}

	@Override
	public void eat() {
		System.out.println(name + " 이(가) 먹는다");		
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}