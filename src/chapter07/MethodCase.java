package chapter07;
/*
 * (1) 리턴타입 X, 매개변수 X		
 * (2) 리턴타입 O, 매개변수 X
 * (3) 리턴타입 X, 매개변수 O
 * (4) 리턴타입 O, 매개변수 O
 */
public class MethodCase {
	// Field
	// Constructor
	// 기본 생성자
	public MethodCase() {
		System.out.println("MethodCase 객체 생성");
	}
	
	// Method
	// (1) 리턴타입 X, 매개변수 X
	public void method1() {
		System.out.println("method1 --> 리턴타입 X, 매개변수 X");
	}
	
	// (2) 리턴타입 O, 매개변수 X
	public int method2() {
		int num1 = 10;
		int num2 = 20;
		return (num1 + num2);
	}
	
	// (3) 리턴타입 X, 매개변수 O : 매개변수의 타입과 갯수에 따라 메소드 오버로딩(Overloading) 구현이 가능
	public void method3(int num1, int num2) {
		System.out.println("method3 --> " + (num1 + num2));
	}
	public void method3(String name) {
		System.out.println("method3 --> " + name);
	}
	
	// (4) 리턴타입 O, 매개변수 O
	public int method4(int num1, int num2) {
		return (num1 + num2);
	}
	public String method4(String name) {
		return name;
	}
	
	public static void main(String[] args) {
		MethodCase mc = new MethodCase();
		int sum  = 0;
		
		// (1) 리턴타입 X, 매개변수 X
		mc.method1();

		// (2) 리턴타입 O, 매개변수 X
		sum = mc.method2();
		System.out.println("method2 --> " + mc.method2());
		System.out.println("method2 --> " + sum);
		
		// (3) 리턴타입 X, 매개변수 O
		mc.method3(10, 20);
		mc.method3("홍길동");
		
		//  (4) 리턴타입 O, 매개변수 O
		System.out.println("method4 --> " + mc.method4(10, 20));
		System.out.println("method4 --> " + mc.method4("홍길동"));
	}
}
