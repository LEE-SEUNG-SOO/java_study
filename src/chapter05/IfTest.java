package chapter05;

import java.util.Scanner;

/*
 * 조건문 if
 * 단일 if문 : 조건의 결과가 true인 경우에만 실행
 * 
 * if~else : 조건의 결과가 true/false 경우에 각각 실행
 * 형식 ) if(조건식){ 조건식이 참일경우 실행문 } 
 * 		 else { 조건식이 거짓일경우 실행문  } 
 * 
 * if~else if ~...~ else : 여러개의 조건을 체크하여 각각 실행
 * 형식 ) if(조건식1){ 조건식1이 참일경우 실행문 } 
 * 		 else if(조건식2) { 조건식1에 해당하지 않고 조건식2이 참일경우 실행문 } 
 * 		 else { 조건식1, 조건식2이 거짓일 경우 실행문 } 
 * 
 * 각 if문의 실행문이 한줄인 경우 {}을 생략 할 수 있다.
 */
public class IfTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int score = 0;

		System.out.print("점수를 입력해주세요. : ");
		score = scan.nextInt();
				
		System.out.println("-- 시험 시작 --");
			
		// 95점이상(A+),90점이상(A),85점이상(B+),80점이상(B),...,60점이하(F)
		if(score >= 95) {
			System.out.println("학점 : A+ ");
		} else if(score >= 90) {
			System.out.println("학점 : A ");
		} else if(score >= 85) {
			System.out.println("학점 : B+ ");
		} else if(score >= 80) {
			System.out.println("학점 : B ");
		} else if(score >= 75) {
			System.out.println("학점 : C+ ");
		} else if(score >= 70) {
			System.out.println("학점 : C ");
		} else if(score >= 65) {
			System.out.println("학점 : D+ ");
		} else if(score > 60) {
			System.out.println("학점 : D ");			
		} else {
			System.out.println("학점 : F ");
		}
				
		System.out.println("-- 시험 종료 --");
		
	}

}
