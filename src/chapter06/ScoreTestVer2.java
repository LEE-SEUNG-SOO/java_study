package chapter06;

import java.util.Scanner;

/*
 * 더 조은 고등학교 1학년 1반 학생들의 성적관리 프로그램
 * 학생 : 홍길동, 이순신, 김유신, 강감찬, 홍길순(5명)
 * 과목 : 국어, 영어, 수학 (3과목)
 * 입력받은 과목의 총점, 평균 구하기
 * 학생명, 과목별 점수, 총점, 평균은 각각 1차원 배열로 생성하여 관리
 * 입출력을 위해서 각 배열의 주소를 통일시킨다.
 * 
 * 프로그래밍 방식
 * 구조적(Structured) 방식 : 순차적으로 실행
 * 객체지향적(Object Oriented) 방식 : 
 */
public class ScoreTestVer2 {

	public static void main(String[] args) {
		System.out.println("--------------------------------------------");
		System.out.println("\t더 조은 고등학교 성적관리 프로그램");
		System.out.println("--------------------------------------------");
		
		// Step.1 : 변수 선언(배열)
		Scanner scan = new Scanner(System.in);
		System.out.print("크기 입력 : ");
		final int MAX_SIZE = scan.nextInt();
		
		String[] nameList = new String[MAX_SIZE];
		int[] korList = new int[MAX_SIZE];
		int[] mathList = new int[MAX_SIZE];
		int[] engList = new int[MAX_SIZE];
		int[] totList = new int[MAX_SIZE];
		int[] avgList = new int[MAX_SIZE];
		
		// Step.2 : 데이터 입력
		for(int i = 0; i < nameList.length; i++) {
			// 이름 입력
			System.out.print("학생명   : ");
			nameList[i] = scan.next();
			
			// 각 점수 입력
			System.out.print("국어 점수 : ");
			korList[i] = scan.nextInt();
			System.out.print("수학 점수 : ");
			mathList[i] = scan.nextInt();
			System.out.print("영어 점수 : ");
			engList[i] = scan.nextInt();
			
			// 총점
			totList[i] = korList[i] + mathList[i] + engList[i];
			// 평균
			avgList[i] = totList[i]/3;
			
			System.out.print("계속 입력 하시겠습니까?(y/n) : ");
			if(scan.next().equals("n")) {
				i = nameList.length; // break;
			}
		}
		
		System.out.println("--------------------------------------------");
		System.out.println("학생명\t국어\t영어\t수학\t총점\t평균" );
		System.out.println("--------------------------------------------");
		// Step.3 : 데이터 출력
		for(int i = 0; i < nameList.length; i++) {
			// 이름이 null이 아닌 경우에만 출력
			if(nameList[i] != null) {
				System.out.print(nameList[i] + "\t");
				System.out.print(korList[i] + "\t");
				System.out.print(mathList[i] + "\t");
				System.out.print(engList[i] + "\t");
				System.out.print(totList[i] + "\t");
				System.out.print(avgList[i] + "\n");
			}
		}
		System.out.println("--------------------------------------------");
		
		// Step.4 : 데이터 조회
		boolean searchFlag = true;
		while(searchFlag) {
			// 조회할 학생명 입력
			System.out.print("조회할 학생명 : ");
			String searchName= scan.next();
			int num = 0;
			int searchIdx = -1;
	
			// nameList에서 입력한 학생명 검색 --> 학생의 nameList 주소를 변수에 저장한다.
			for(String name : nameList) {
				// 입력한 학생명이 nameList에 존재할경우
				if(name != null) {
					if(searchName.equals(name)) {
						// 주소변수 저장
						searchIdx = num;
						break;
					}
					num++;	
				} else {
					break;
				}
			}
			
			// Step.5 : 조회 결과 출력\
			System.out.println("--------------------------------------------");
			System.out.println("\t\t조회 결과");
			System.out.println("--------------------------------------------");
			System.out.println("학생명\t국어\t영어\t수학\t총점\t평균" );
			System.out.println("--------------------------------------------");
			System.out.print(nameList[searchIdx] + "\t");
			System.out.print(korList[searchIdx] + "\t");
			System.out.print(mathList[searchIdx] + "\t");
			System.out.print(engList[searchIdx] + "\t");
			System.out.print(totList[searchIdx] + "\t");
			System.out.print(avgList[searchIdx] + "\n");
			System.out.println("--------------------------------------------");
			System.out.print("계속 조회 하시겠습니까?(y/n) : ");
			// 반복 종료
			if(scan.next().equals("n")) {
				searchFlag = false;
			}
		}// while - searchFlag : Step.4, Step.5 반복

		System.out.println("-- 프로그램 종료 --");
		
	}

}
