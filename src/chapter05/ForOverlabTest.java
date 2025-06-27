package chapter05;

import java.util.Scanner;

/*
 * 반복문 중첩
 */
public class ForOverlabTest {

	public static void main(String[] args) {
		// 2단부터 5단까지 한번에 출력		
		// 행출력(1~9)
		// x단부터 x단까지 출력
		Scanner scan = new Scanner(System.in);
		int startDan = 0;
		int endDan = 0;
		System.out.println("구구단을 출력합니다.");
		System.out.println("종료: 시작단,끝 단 모두 0입력");
		
		boolean flag = true;
		
		while(flag) {
			// 시작 단 입력
			System.out.print("시작 단 : ");
			startDan = scan.nextInt();

			// 끝 단 입력
			System.out.print("끝  단 : ");
			endDan = scan.nextInt();
			
			// 프로그램 종료
			if(startDan == 0 && endDan == 0) {
//				System.out.println("-- 프로그램 종료 --");
//				System.exit(0);
				//while 블록을 빠져나간후 종료
				flag = false;
			} else {
				// 단 머릿말 출력
				for(int i = startDan; i<= endDan; i++) {
					System.out.print("   " + i +"단\t\t");	
				}
				 System.out.println();
				 
				// 구구단 출력
				for(int i = 1; i <= 9; i++) {
					// 단 출력(2~5)
					for(int j = startDan; j <= endDan; j++) {
						System.out.print(j +" * " + i + " = " + (j * i) + "\t");
					}
					// System.out.print("\n");
					 System.out.println();
				}
				System.out.println("종료: 시작단, 끝 단 모두 0입력");
			}
		}// while
	
		System.out.println("-- 프로그램 종료 --");
		System.exit(0);
	}// main
}
