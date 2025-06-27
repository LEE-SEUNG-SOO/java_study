package chapter05;

import java.util.Scanner;

/*
 * *출력하기
 * 피라미드의 층수를 입력받아 출력.
 */
public class ForOverlabStarTest2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("피라미드 층수 입력(최소1층) : ");
		
		// 입력값 확인
		if(scan.hasNextInt()) {
			String star = "*";
			// 피라미드 층수 입력
			int floor = scan.nextInt();
		
			// 0을 입력했을 경우
			if(floor == 0) {
				System.out.println("0층은 존재하지 않습니다.");
			} else {
				// 1층 기본 표시 설정
				int number = 1;

				System.out.println("[시작]");
				// 1층부터 입력한 층까지 반복출력 시작
				for(int i = 1; i <= floor; i++) {
					// 각 층별 빈칸 표시
					for(int k = 1; k <= (floor - i) ; k++) {
						System.out.print(" ");
					}
					
					// 1층이후 *출력 갯수 + 2
					// 1층 : 1개
					// 2층 : 3개
					// 3층 : 5개 ...
					if(i != 1) {
						number += 2;
					}
					
					// 각 층별 별표시
					for(int j = 1; j <= number; j++){
						System.out.print(star);
					}
					// 층 나누기
					System.out.println();
				}
			}
		} else {
			// 입력값이 정수가 아닐시 출력
			System.out.println("잘못된 입력입니다.");
		}
		System.out.println("[종료]");
	}
}
