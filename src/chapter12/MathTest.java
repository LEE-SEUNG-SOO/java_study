package chapter12;

public class MathTest {

	public static void main(String[] args) {
		
		// 모든 메소드가 static으로 정의되어 있다. : Math.메소드명
		System.out.println(Math.abs(-100)); // 절대값
		System.out.println(Math.floor(123.456)); // 반올림X
		System.out.println(Math.max(100, 200));
		System.out.println(Math.min(100, 200));
		System.out.println(Math.random());
		System.out.println((int)Math.floor(Math.random() * 100)); // 정수 2자리 랜덤 호출
		System.out.println(Math.round(123.456)); // 반올림 O 123
		System.out.println(Math.round(123.567)); // 반올림 O 124
		
		
		System.out.println( (double)Math.round((123.567) * 10 ) / 10 ); // 반올림 O, 소수 첫재짜리 123.6
		System.out.println( (double)Math.round((123.547) * 10 ) / 10 ); // 반올림 O, 소수 첫재짜리 123.5
	} 

}
