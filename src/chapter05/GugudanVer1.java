package chapter05;

import java.util.Scanner;

/*
 * 구구단 출력하기
 * (단일 구구단 출력)
 */
public class GugudanVer1 {

	public static void main(String[] args) {
		// 출력하는 구구단을 입력받아 실행
		Scanner scan = new Scanner(System.in);
		int num = 0;
		System.out.println("출력할 구구단을 입력해주세요.");
		
		while(true) {
			System.out.print("입력(종료:0) : ");
			num = scan.nextInt();			
			// 입력값이 0이 아니면 구구단 출력
			if(num != 0) {
				System.out.println("--- " + num + "단 ---");
				for(int i = 1; i <= 9; i++) {
					System.out.println(num + " x " + i + " = " + (num * i));
				}// for								
			} else {
				//입력값이 0이면 프로그램 종료
				System.exit(0);
			}// if	
		}// while
	}// main
}// class
