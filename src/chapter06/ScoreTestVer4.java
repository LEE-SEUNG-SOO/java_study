package chapter06;

import java.util.Scanner;

/*
 * ScoreTestVer3에서 다차원 배열로 변경
 * 
 */
public class ScoreTestVer4 {

	public static void main(String[] args) {
		System.out.println("------------------초기 설정--------------------");

		// Step.1 : 변수 선언(배열)
		Scanner scan = new Scanner(System.in);
		System.out.print("학생 수 입력 : ");
		final int MAX_SIZE = scan.nextInt();
		final String SUBJECTLIST[] = {"국어", "수학","영어"};
		
		String[] nameList = new String[MAX_SIZE];
//		int[] korList = new int[MAX_SIZE];
//		int[] mathList = new int[MAX_SIZE];
//		int[] engList = new int[MAX_SIZE];
//		int[] totList = new int[MAX_SIZE];
//		int[] avgList = new int[MAX_SIZE];
		int[][] scoreList = new int [MAX_SIZE][];
		// 과목 수
		int subjectListNumber = SUBJECTLIST.length;

		// 등록된 학생수 정보
		int studentCount = 0;
		boolean menuFlag = true;
		
		while(menuFlag) {
			int menuNo = 0;
			
			System.out.println("--------------------------------------------");
			System.out.println("더 조은 고등학교 성적관리 프로그램");
			System.out.println("1. 학생 등록");
			System.out.println("2. 학생 리스트 출력");
			System.out.println("3. 학생 성적 검색");
			System.out.println("9. 프로그램 종료");
			System.out.println("--------------------------------------------");
			System.out.print("메뉴를 선택해주세요 : ");
			
			menuNo = scan.nextInt();			
			System.out.println("선택 메뉴 : " + menuNo);
			
			// 학생 등록
			if(menuNo == 1) {
				if(studentCount == MAX_SIZE) {
					System.out.println("학생 수가 가득 찼습니다.");
				} else {
					// Step.2 : 데이터 입력
					for(int i = studentCount; i < MAX_SIZE; i++) {
						// 이름 입력
						System.out.print("학생명   : ");
						nameList[i] = scan.next();
						
						scoreList[i] = new int[subjectListNumber+2];
						
						// 2차원 배열에 점수 입력(국어, 영어, 수학)
						for(int j = 0; j < subjectListNumber; j++) {
							System.out.print(SUBJECTLIST[j] + " 점수 : ");
							// 각 과목점수
							scoreList[i][j] = scan.nextInt();
							// 총점
							scoreList[i][subjectListNumber] += scoreList[i][j];
						}
						// 평균
						scoreList[i][subjectListNumber+1] = (scoreList[i][subjectListNumber]/subjectListNumber);
						
//						// 각 점수 입력
//						System.out.print("국어 점수 : ");
//						korList[i] = scan.nextInt();
//						System.out.print("수학 점수 : ");
//						mathList[i] = scan.nextInt();
//						System.out.print("영어 점수 : ");
//						engList[i] = scan.nextInt();
//						

						// 총점
//						totList[i] = korList[i] + mathList[i] + engList[i];
//						// 평균
//						avgList[i] = totList[i]/3;
						
						// 등록된 학생수 증가
						studentCount++;
						
						// 등록된 학생수가 최대치 일경우
						if(studentCount == MAX_SIZE) {
							System.out.println("최대 등록수를 초과했습니다. 메뉴로 돌아갑니다.");
						} else {
							System.out.print("계속 등록 하시겠습니까?(y/n) : ");
							if(scan.next().equals("n")) {
								i = nameList.length; // break;
								System.out.println(" -- 등록 완료 -- ");
							}
						}
					}
				}
			} 
			// 학생 리스트 출력
			else if(menuNo == 2) {
				// 학생 수가 1명 이상일 경우
				if(studentCount > 0) { // nameList[0] != null
					// Step.3 : 데이터 출력
					System.out.println("--------------------------------------------");
					System.out.println("학생명\t국어\t영어\t수학\t총점\t평균" );
					System.out.println("--------------------------------------------");
					
					// 등록된 학생 수 만큼 출력
					for(int i = 0; i < studentCount; i++) {
						System.out.print(nameList[i] + "\t");
						// 반복하며 출력
						for(int j = 0; j < subjectListNumber+2; j++) {
							System.out.print(scoreList[i][j] + "\t");
						}
						System.out.println("");
						
//							System.out.print(korList[i] + "\t");
//							System.out.print(mathList[i] + "\t");
//							System.out.print(engList[i] + "\t");
//							System.out.print(totList[i] + "\t");
//							System.out.print(avgList[i] + "\n");
					}
					System.out.println("--------------------------------------------");
				} 
				// 학생 수가 0명일 경우
				else {
					System.out.println(" -- 등록된 데이터가 없습니다. 등록을 진행해 주세요. --");
				}
			} 
			// 학생 성적 검색
			else if(menuNo == 3) {
				//  학생 수가 1명 이상일 경우
				if(studentCount > 0) {
					// 반복 검색 제어
					boolean searchFlag = true;
					while(searchFlag) {
						// 조회할 학생명 입력
						System.out.print("조회할 학생명 : ");
						String searchName= scan.next();
						int countIdx = 0;
						int searchIdx = -1;

						// nameList에서 입력한 학생명 검색 --> 학생의 nameList 주소를 변수에 저장한다.
						for(String name : nameList) {
							// 입력한 학생명이 nameList에 존재할경우
							if(name != null) {
								if(searchName.equals(name)) {
									// 주소변수 저장
									searchIdx = countIdx;
									break;
								}
								countIdx++;	
							} else {
								break;
							}
						}
						
						// 검색 결과, 일치하는 학생이 있을 경우
						if(searchIdx >= 0) {
							// Step.5 : 조회 결과 출력\
							System.out.println("--------------------------------------------");
							System.out.println("\t\t조회 결과");
							System.out.println("--------------------------------------------");
							System.out.println("학생명\t국어\t영어\t수학\t총점\t평균" );
							System.out.println("--------------------------------------------");
							System.out.print(nameList[searchIdx] + "\t");
							// 반복하며 출력
							for(int j = 0; j < subjectListNumber+2; j++) {
								System.out.print(scoreList[searchIdx][j] + "\t");
							}
							System.out.println("");
//							System.out.print(korList[searchIdx] + "\t");
//							System.out.print(mathList[searchIdx] + "\t");
//							System.out.print(engList[searchIdx] + "\t");
//							System.out.print(totList[searchIdx] + "\t");
//							System.out.print(avgList[searchIdx] + "\n");
							System.out.println("--------------------------------------------");
							
							System.out.print("계속 조회 하시겠습니까?(y/n) : ");
							// 반복 종료
							if(scan.next().equals("n")) {
								searchFlag = false;
							}
						} 
						// 검색 결과, 일치하는  학생이 없을 경우
						else {
							System.out.println("검색한 학생이 존재하지 않습니다.");
						}
					}// while - searchFlag : Step.4, Step.5 반복
				} 
				// 학생 수가 0명일 경우
				else {
					System.out.println(" -- 등록된 데이터가 없습니다. 등록을 진행해 주세요. --");
				}
			}
			// 프로그램 종료
			else if(menuNo == 9) {
				System.out.println("-- 프로그램 종료 --");
				System.exit(0);
			} else {
				System.out.println("메뉴 준비중 입니다.");
			}
			
//			System.out.print("메뉴 선택으로 돌아가시겠습니까?(y/n) : ");
//			if(scan.next().equals("n")) {
//				menuFlag = false;
//			}
		}
		
		System.out.println("-- 프로그램 종료 --");
		
	}
}
