package chapter05;

import java.util.Scanner;

/*
 * 반복문 For
 * 형식) for(초기값선언; 조건식; 증감식){
 * 			실행문; // 조건식이 true인 경우
 * 		}
 * 조건식이 false가 되면 for문 블록 종료
 * 초기값으로 선언된 변수는 for문 블록 안에서만 사용
 */
public class ForTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int start = 0;
		int end = 0;
		
//		System.out.println("-----for 문 시작-----");
//		//1~10까지 정수를 출력
//		for(int i = 1; i <= 10; i++) {
//			System.out.println("i = " + i);
//		}
//		System.out.println("-----for 문 종료-----");

		//시작과 종료값은 실행시 외부에서 입력을 통해 진행한다.
		// 시작값 입력
		System.out.print("시작값 입력 : ");
		if(scan.hasNextInt()) {
			start = scan.nextInt();
			// 종료값 입력
			System.out.print("종료값 입력 : ");
			if(scan.hasNextInt()) {
				end = scan.nextInt();
				
				// 시작값부터 종료값까지 출력
				System.out.println("-----for 문 시작-----");
				for(int i = start; i <= end; i++) {
					System.out.println("i = " + i);
				}
				System.out.println("-----for 문 종료-----");
				
			} else {
				// 종료값 입력이 정수가 아닐경우
				System.out.println("잘못된 입력값입니다.");	
			}
		} else {
			// 시작값 입력이 정수가 아닐경우
			System.out.println("잘못된 입력값입니다.");
		}
		
		//System.out.println(i); << i변수는 for문 블록안에서만 사용가능
	}

}
