package chapter04;
/*
 * 비교연산자 : >, >=, <, <=, ==, !=
 * 비교연산자의 실행결과는 boolean(true 또는 false)타입으로 리턴되어, 제어문(if, for, while)에 사용된다.
 */
public class OpComparisonTest {

	public static void main(String[] args) {
		int number1 = 5;
		int number2 = 2;
		
		// 비교연산 결과를 boolean변수에 대입
		boolean result = number1 == number2;

		// result출력
		System.out.println("result : " + result);
		
		// 5 > 2의 결과 true
		System.out.println("5 > 2 결과 : " + (number1 > number2));

		// 5 >= 2의 결과 true
		System.out.println("5 >= 2 결과 : " + (number1 >= number2));

		// 5 < 2의 결과 false
		System.out.println("5 < 2 결과 : " + (number1 < number2));

		// 5 <= 2의 결과 false
		System.out.println("5 <= 2 결과 : " + (number1 <= number2));

		// 5 == 2의 결과 false
		System.out.println("5 == 2 결과 : " + (number1 == number2));

		// 5 != 2의 결과 false
		System.out.println("5 != 2 결과 : " + (number1 != number2));

	}

}
