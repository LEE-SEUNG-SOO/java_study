package chapter05;

import java.util.Scanner;

/*
 * 반복문 while
 * 형식) while(조건식){
 * 		실행문;
 * 		}
 * 
 * 반복 횟수는 알 수 없으나 종료 시점을 아는 경우 사용
 */
public class WhileTest {
	public static void main(String[] args) {
		// 1~10까지 정수의 합계를 출력
		// 시작과 종료값은 실행시 외부에서 입력을 통해 진행
		int start = 0;
		int end = 0;
		int i = 0;
		int sum = 0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("시작값 입력 : ");
		i = start = scan.nextInt();

		System.out.print("종료값 입력 : ");		
		end = scan.nextInt();
		
		while(i<=end) {
			sum += i;
			i++;
		}
		System.out.println("sum = " + sum);
		
	}
}
