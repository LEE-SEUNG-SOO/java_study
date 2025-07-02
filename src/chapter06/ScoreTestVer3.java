package chapter06;

import java.util.Scanner;

/*
 * ScoreTestVer2의 결과에 메뉴를 추가한다.
 * 
 * 더 조은 고등학교 1학년 1반 학생들의 성적관리 프로그램
 * 학생 : 홍길동, 이순신, 김유신, 강감찬, 홍길순(5명)
 * 과목 : 국어, 영어, 수학 (3과목)
 * 입력받은 과목의 총점, 평균 구하기
 * 학생명, 과목별 점수, 총점, 평균은 각각 1차원 배열로 생성하여 관리
 * 입출력을 위해서 각 배열의 주소를 통일시킨다.
 * 
 * 학생 성적 수정 메뉴를 추가 (검색 + 등록)
 * 학생 데이터(이름, 성적) 삭제 메뉴를 추가 (검색)
 * 
 */
public class ScoreTestVer3 {

	public static void main(String[] args) {
		System.out.println("------------------초기 설정--------------------");

		// Step.1 : 변수 선언(배열)
		Scanner scan = new Scanner(System.in);
		System.out.print("학생 수 입력 : ");
		final int MAX_SIZE = scan.nextInt();
		
		String[] nameList = new String[MAX_SIZE];
		int[] korList = new int[MAX_SIZE];
		int[] mathList = new int[MAX_SIZE];
		int[] engList = new int[MAX_SIZE];
		int[] totList = new int[MAX_SIZE];
		int[] avgList = new int[MAX_SIZE];
		
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
			System.out.println("4. 학생 성적 수정");
			System.out.println("5. 학생 데이터 삭제");
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
					for(int i = studentCount; i < nameList.length; i++) {
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
						// 등록된 학생수 증가
						studentCount++;
						
						System.out.print("계속 등록 하시겠습니까?(y/n) : ");
						if(scan.next().equals("n")) {
							i = nameList.length; // break;
							System.out.println(" -- 등록 완료 -- ");
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
			// 학생 성적 수정
			else if(menuNo == 4) {
				// 수정할 학생 검색
				// 대상 있음 : 새로운 성적 입력 후 수정
				// 대상 없음 : 수정 불가. 검색 데이터 없음 출력
				// 데이터 등록 여부 확인
				if(studentCount > 0) {
					boolean modiFlag = true;
					while(modiFlag) {
						System.out.print("수정할 학생명을 입력해주세요.(종료:n) : ");
						String modifiedName = scan.next();
						int modiIdx = -1;
						
						// 대상 확인
						for(int i = 0; i < studentCount; i++) {
							if(modifiedName.equals(nameList[i])) {
								modiIdx = i;
							}
						}
						
						// 대상이 없을 경우
						if(modiIdx == -1) {
							System.out.println("입력한 학생이 없습니다. 다시 입력해주세요.");
						} 
						// 대상이 있을 경우
						else {
							// 각 점수 입력
							System.out.print("국어 점수 : ");
							korList[modiIdx] = scan.nextInt();
							System.out.print("수학 점수 : ");
							mathList[modiIdx] = scan.nextInt();
							System.out.print("영어 점수 : ");
							engList[modiIdx] = scan.nextInt();
							
							// 총점
							totList[modiIdx] = korList[modiIdx] + mathList[modiIdx] + engList[modiIdx];
							// 평균
							avgList[modiIdx] = totList[modiIdx]/3;
							
							System.out.println(" -- 수정 완료 -- ");
							
							// 수정 내용 출력
							System.out.println("--------------------------------------------");
							System.out.println("학생명\t국어\t영어\t수학\t총점\t평균" );
							System.out.println("--------------------------------------------");
							System.out.print(nameList[modiIdx] + "\t");
							System.out.print(korList[modiIdx] + "\t");
							System.out.print(mathList[modiIdx] + "\t");
							System.out.print(engList[modiIdx] + "\t");
							System.out.print(totList[modiIdx] + "\t");
							System.out.print(avgList[modiIdx] + "\n");
							System.out.println("--------------------------------------------");
							
							System.out.print("계속 수정 하시겠습니까?(y/n) : ");
							// 반복 종료
							if(scan.next().equals("n")) {
								modiFlag = false;
							}
						}
					}
				} else {
					System.out.println(" -- 등록된 데이터가 없습니다. 등록을 진행해 주세요. --");
				}
			}
			

			// 학생 데이터 삭제
			else if(menuNo == 5) {
				// 수정할 학생 검색
				// 대상 있음 : 배열로 부터 삭제.
				// 			 삭제된 배열의 인덱스 + 1의 데이터를 삭제된 배열에 저장.
				// 대상 없음 : 수정 불가. 검색 데이터 없음 출력
				// 데이터 등록 여부 확인
				if(studentCount > 0) {
					boolean delFlag = true;
					while(delFlag) {

						System.out.print("삭제할 학생명을 입력해주세요.(종료:n) : ");
						String delName = scan.next();
						int delIdx = -1;
						
						// 대상 확인
						for(int i = 0; i < studentCount; i++) {
							if(delName.equals(nameList[i])) {
								delIdx = i;
							}
						}
						
						// 대상이 없을 경우
						if(delIdx == -1) {
							System.out.println("입력한 학생이 없습니다. 다시 입력해주세요.");
						} 
						// 대상이 있을 경우
						else {
							// 대상의 인덱스의 값을 인덱스 + 1값의 데이터로 수정(마지막 배열 전까지 반복)
							for(int i = delIdx; i < studentCount-1; i++) {
								nameList[i] = nameList[i+1];
								mathList[i] = mathList[i+1];
								engList[i] = engList[i+1];
								totList[i] = totList[i+1];
								avgList[i] = avgList[i+1];
							}
							
							// 등록된 학생수의 마지막 배열 초기화
							nameList[studentCount-1] = null;
							mathList[studentCount-1] = 0;
							engList[studentCount-1] = 0;
							totList[studentCount-1] = 0;
							avgList[studentCount-1] = 0;
							studentCount--;
						}
						
						System.out.println("-- 삭제 완료 --");
						System.out.print("계속 수정 하시겠습니까?(y/n) : ");
						// 반복 종료
						if(scan.next().equals("n")) {
							delFlag = false;
						}
					}
				}
				// 등록된 학생이 없을 경우
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
