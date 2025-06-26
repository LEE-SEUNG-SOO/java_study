package chapter05;

import java.util.Scanner;

/*
 * 중첩 if
 */
public class IfOverlabTest2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean math_pass = false;
		boolean eng_pass = false;
		
		// 수학점수 입력
		System.out.print("수학점수를 입력해주세요. : ");
		math_pass = (scan.nextInt() >= 60) ? true : false;
		// 영어점수 입력
		System.out.print("영어점수를 입력해주세요. : ");
		eng_pass = (scan.nextInt() >= 60) ? true : false;

		//체크 시작 (수학점수, 영어점수 둘다 60점 이상일 경우 통과)
		// 수학점수 60점 이상
		// 1. 중첩 if
		if(math_pass) if(eng_pass) System.out.println("통과"); //영어점수 60점 이상
		else System.out.println("탈락");
		
		// 2. 논리연산자 &&
		if(math_pass && eng_pass) System.out.println("합격");
		else System.out.println("불합격");
		
	}

}
