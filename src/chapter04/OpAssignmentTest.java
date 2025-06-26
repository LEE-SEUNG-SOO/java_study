package chapter04;
/*
 * 대입연산자 : =, +=, -=, *=, /=, %=
 */
public class OpAssignmentTest {

	public static void main(String[] args) {
		// 정수형 number 변수에 100을 대입
		int number = 100;
		System.out.println("number : " + number);
		
		//number변수에 10값을 중첩하여 더해서 대입
		number += 10; // number = number + 10;
		number += 10; // number = number + 10;
		System.out.println("number : " + number);
		
		//number변수에 10값을 중첩하여 빼서 대입
		number -= 10; // number = number - 10;
		System.out.println("number : " + number);		

		//number변수에 10값을 중첩하여 곱해서 대입
		number *= 10; // number = number * 10;
		System.out.println("number : " + number);		

		//number변수에 10값을 중첩하여 나눠서 대입
		number /= 10; // number = number / 10;
		System.out.println("number : " + number);		
		
		//number변수에 3값을 중첩하여 모듈러연산(나머지)하여 대입
		number %= 3; // number = number % 3;
		System.out.println("number : " + number);		
	}

}
