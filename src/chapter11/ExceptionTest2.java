package chapter11;

import java.util.Scanner;

public class ExceptionTest2 {

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

		}
		// 예외 전체
		catch(Exception e) {
			System.out.println("예외 발생");
			e.printStackTrace(); // 예외 발생한 메세지 출력(빨간글씨)
		} finally {
			scan.close();
			System.out.println("--프로그램 종료--");
		}
	}
}
