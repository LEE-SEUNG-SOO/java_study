package chapter11;

import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;
		int result = 0;
		
		System.out.print("num1 : ");
		num1 = scan.nextInt();
		
		System.out.print("num2 : ");
		num2 = scan.nextInt();
		
		// 예외가 발생할 구간
		try {
			result = num1/num2;	
			System.out.println("result : " + result);
			int[] numbers = {1,2,3};
			System.out.println(numbers[5]);

		// 수학적 예외 발생시
		} catch(ArithmeticException ae) {
			System.out.println("num2는 0을 입력할 수 없습니다.");
			ae.printStackTrace(); // 예외 확인가능
		} 
		// 배열 인덱스 예외 발생시
		catch(ArrayIndexOutOfBoundsException aob){
			System.out.println("배열의 인덱스 범위 초과");
			System.out.println(aob); // 예외 확인가능
		}
	}
}
