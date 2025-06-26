package chapter05;

import java.util.Scanner;

/*
 * 조건문 switch
 * 변수 값을 체크하여 실행문
 * switch(변수){
 *  case 값1: //변수의 값과 값1이 동일하면 실행문 실행
 *   실행문1;
 *   break;  // 실행문1이 끝나고 switch의 블록을 빠져나간다.
 *  case 값2: //변수의 값과 값2이 동일하면 실행문 실행
 *   실행문2;
 *   break; // 실행문2이 끝나고 switch의 블록을 빠져나간다.
 *  default: // 값1과 값2외의 값인 경우 실행
 *   실행문;
 * }
 */
public class SwitchTest {

	public static void main(String[] args) {
		// 프로그램 실행시 정수값을 입력받아 결과를 출력
		// 입력값이 1이면 사과(🍎)출력
		// 입력값이 2이면 오렌지(🍊)출력
		// 입력값이 3이면 망고(🥭)출력
		// 입력값이 4이면 키위(🥝)출력
		// 그 외의 숫자일경우 "준비중입니다." 출력
		Scanner scan = new Scanner(System.in);
		int number = -1;
				
		System.out.print("숫자를 입력해주세요.(1~4) : ");
		number = scan.nextInt(); 
		
		switch(number) {
			case 1:
				System.out.println("🍎");
				break;
			case 2:
				System.out.println("🍊");
				break;
			case 3:
				System.out.println("🥭");
				break;
			case 4:
				System.out.println("🥝");
				break;
			default:
				System.out.println("준비중입니다.");
				break;
		}
		System.out.println("--종 료--");
	}
}
