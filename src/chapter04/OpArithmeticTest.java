package chapter04;
/*
 * 산술연산자 : +, -, *, /, %
 */
public class OpArithmeticTest {

	public static void main(String[] args) {
		int number1 = 5;
		int number2 = 2;
		
		// 5 + 2 = 7
		System.out.println("5 + 2 : " + (number1 + number2));

		// 5 - 2 = 3
		System.out.println("5 - 2 : " + (number1 - number2));
		
		// 5 * 2 = 10
		System.out.println("5 * 2 : " + (number1 * number2));
		
		// 5 / 2 = 2
		System.out.println("5 / 2 : " + (number1 / number2));
		
		// 5 % 2 = 1
		System.out.println("5 % 2 : " + (number1 % number2));

	}

}
