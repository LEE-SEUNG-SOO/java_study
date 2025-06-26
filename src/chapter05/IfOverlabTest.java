package chapter05;

import java.util.Scanner;

/*
 * 중첩 if
 */
public class IfOverlabTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int math = 0;
		int eng = 0;
		
		// 수학점수 입력
		System.out.print("수학점수를 입력해주세요. : ");
		math = scan.nextInt();
		// 영어점수 입력
		System.out.print("영어점수를 입력해주세요. : ");
		eng = scan.nextInt();

		//체크 시작 (수학점수, 영어점수 둘다 60점 이상일 경우 통과)
		// 수학점수 60점 이상
		// 1. 중첩 if
		if(math >= 60) {
			if(eng >= 60) {
				//영어점수 60점 이상
				System.out.println("통과");
			}
		} else {
			// 수학점수 60점 미만
			System.out.println("탈락");
		}
		
		// 2. 논리연산자 &&
		if(math >= 60 && eng >= 60) {
			System.out.println("합격");			
		} else {
			System.out.println("불합격");
		}
		
	}

}
