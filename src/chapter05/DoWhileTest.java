package chapter05;

import java.util.Scanner;

/*
 * 반복문 do ~ while
 * 형식) do {
 * 		실행문;
 * 		}while(조건식);
 * 
 * 첫 실행문을 실행후 조건식에 맞을 때까지 반복실행(반드시 1회 실행)
 */
public class DoWhileTest {
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
		
		do {
			sum += i;
			i++;
		}
		while(i<=end);
		
		System.out.println("sum = " + sum);
		
	}
}
