package chapter06;

import java.util.Scanner;

/*
 * ScoreTestVer3에서 다차원 배열로 변경
 * 
 */
public class StudentTest {

	public static void main(String[] args) {
		System.out.println("------------------초기 설정--------------------");

		// Step.1 : 변수 선언(배열)
		Scanner scan = new Scanner(System.in);
		System.out.print("학생 수 입력 : ");
		final int MAX_SIZE = scan.nextInt();
		final String SUBJECTLIST[] = {"국어", "수학","영어"};
		
		String[] nameList = new String[MAX_SIZE];
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
			System.out.println("2. 학생 목록 조회");
			System.out.println("3. 학생 성적 검색");
			System.out.println("4. 성적 수정");
			System.out.println("5. 학생 삭제");
			System.out.println("6. 프로그램 종료");
			System.out.println("--------------------------------------------");
			System.out.print("메뉴를 선택해주세요 : ");
			
			menuNo = scan.nextInt();			
			System.out.println("선택 메뉴 : " + menuNo);
			
			// 1. 학생 등록
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
			// 2. 학생 목록 조회
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
					}
					System.out.println("--------------------------------------------");
				} 
				// 학생 수가 0명일 경우
				else {
					System.out.println(" -- 등록된 데이터가 없습니다. 등록을 진행해 주세요. --");
				}
			} 
			// 3. 학생 성적 검색
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
							for(int score : scoreList[searchIdx]) {
								System.out.print(score + "\t");
							}
							System.out.println("");
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
					}
				} 
				// 학생 수가 0명일 경우
				else {
					System.out.println(" -- 등록된 데이터가 없습니다. 등록을 진행해 주세요. --");
				}
			}
			// 4. 성적 수정
			else if(menuNo == 4) {
				//  학생 수가 1명 이상일 경우
				if(studentCount > 0) {
					boolean editFlag = true;
					
					while(editFlag) {
						// 조회할 학생명 입력
						System.out.print("수정할 학생명 : ");
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
							System.out.println("수정할 과목을 선택해주세요.");
							System.out.print("1)국어, 2)영어, 3)수학 0)종료 : ");
							int editSubject = scan.nextInt();
							
							// 종료
							if(editSubject == 0) {
								editFlag = false;
							} 
							// 국어, 영어, 수학 중 택1
							else if(editSubject > 0 && editSubject < 4) {
								System.out.print("수정할 점수를 입력해주세요. : ");
								// 수정후 점수
								int afterScore = scan.nextInt();
								// 수정전 점수
								int beforeScore = scoreList[searchIdx][editSubject-1];
								
								// 수정할 과목의 점수 수정
								scoreList[searchIdx][editSubject-1] = afterScore;
								// 총합에서 수정전 과목의 점수를 뺀다.
								scoreList[searchIdx][subjectListNumber] -= beforeScore;
								// 총합에서 수정후 과목의 점수를 더한다.
								scoreList[searchIdx][subjectListNumber] += afterScore;
								// 평균
								scoreList[searchIdx][subjectListNumber+1] = (scoreList[searchIdx][subjectListNumber]/subjectListNumber);

								System.out.println("--------------------------------------------");
								System.out.println("선택한 과목 : " + SUBJECTLIST[editSubject-1]);
								System.out.println("수정전(" + beforeScore + ") -> 수정후(" + afterScore + ")");
								System.out.println("--------------------------------------------");
								
								System.out.print("계속 수정 하시겠습니까?(y/n) : ");
								// 반복 종료
								if(scan.next().equals("n")) {
									editFlag = false;
								}
							}
							// 그외
							else {
								System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
							}
						}
						// 검색 결과, 일치하는 학생이 없을 경우
						else {
							System.out.println("검색한 학생이 존재하지 않습니다.");
						}
					}
				}
				// 학생 수가 0명일 경우
				else {
					System.out.println(" -- 등록된 데이터가 없습니다. 등록을 진행해 주세요. --");
				}
			}
			// 5. 학생 삭제
			else if(menuNo == 5) {
				//  학생 수가 1명 이상일 경우
				if(studentCount > 0) {
					boolean deleteFlag = true;
					
					while(deleteFlag) {
						// 조회할 학생명 입력
						System.out.print("삭제할 학생명 : ");
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
							// 삭제한 인덱스가 가장 마지막 배열이 아니였을 경우.
							if(searchIdx != (MAX_SIZE-1)) {
								// 삭제된 배열의 주소값에 그 이후 주소값의 데이터를 순차적으로 저장.
								for(int i = searchIdx; i < MAX_SIZE-1; i++) {
									// 삭제한 인덱스의 다음 인덱스의 값 설정
									nameList[i] = nameList[i+1];
									for(int j = 0; j < subjectListNumber+2; j++) {
										// 삭제한 인덱스의 다음 인덱스의 값 설정
										scoreList[searchIdx][j] = scoreList[searchIdx+1][j];
									}
								}
								
								// 가장 마지막 배열 초기화
								nameList[MAX_SIZE-1] = null;
								for(int i = 0; i < subjectListNumber+2; i++) {
									scoreList[MAX_SIZE-1][i] = 0;
								}
							}
							// 총 학생수 -1
							studentCount--;
							if(studentCount == 0) {
								System.out.println("모든 학생이 삭제되었습니다. 선택 화면으로 돌아갑니다.");
								deleteFlag = false;
							} else {
								System.out.print("삭제 완료되었습니다. 계속 삭제 하시겠습니까?(y/n) : ");
								// 반복 종료
								if(scan.next().equals("n")) {
									deleteFlag = false;
								}
							}
						}
						// 검색 결과, 일치하는 학생이 없을 경우
						else {
							System.out.println("검색한 학생이 존재하지 않습니다.");
						}
					}
				}
				// 학생 수가 0명일 경우
				else {
					System.out.println(" -- 등록된 데이터가 없습니다. 등록을 진행해 주세요. --");
				}
			}
			// 6. 프로그램 종료
			else if(menuNo == 6) {
				System.out.println("-- 프로그램 종료 --");
				System.exit(0);
			} else {
				System.out.println("메뉴 준비중 입니다.");
			}
		}
		
		System.out.println("-- 프로그램 종료 --");
		scan.close();
	}
}
