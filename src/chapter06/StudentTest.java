package chapter06;

import java.util.Scanner;

/*
 *  실습2_성적관리프로그램
 */
public class StudentTest {

	public static void main(String[] args) {
		// 변수 설정
		Scanner scan = new Scanner(System.in);
		// 현버전 최대 5명
		// 학생명
		String studentName[] = new String[5];
		// 학번
		int studentNumber[] = new int[5];
		// 전공
		String studentInfo[] = new String[5];
		// 현버전 최대 5명
		int studentScore[][] = new int[5][];
		// 현버전 3개 과목
		String subjectName[] = {"국어","영어","수학"};
		
		// 초기화면
		System.out.println("===== 학생 성적 관리 시스템 =====");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 목록 조회");
		System.out.println("3. 학생 성적 검색");
		System.out.println("4. 성적 수정");
		System.out.println("5. 학생 삭제");
		System.out.println("6. 종료");
		
		while(true) {
			// 선택지 입력.
			System.out.print(">>메뉴 선택 : ");
			// 정수 판별
			if(scan.hasNextInt()) {
				switch(scan.nextInt()) {
					// 1번 입력
					case 1:
						// 등록 정보수 체크
						boolean studentNameFlag = false;
						
						for(int i = 0; i < studentName.length; i++) {
							// studentName[i]의 배열이 비어있을경우 등록
							if(studentName[i] == null) {
								// 학생 정보 등록
								System.out.println("[학생 등록]");
								System.out.print("이름 : ");
								studentName[i] = scan.next();
								System.out.print("학번 : ");
								studentNumber[i] = scan.nextInt();
								System.out.print("전공 : ");
								studentInfo[i] = scan.next();
								
								// 점수 등록
								for(int j =0; j < subjectName.length; j++) {
									System.out.print(subjectName[j] + " 점수 : ");
									studentScore[i][j] = scan.nextInt();
								}
								// while문 종료
								studentNameFlag = true;
								System.out.println("-> 등록 완료!");
							}
						}
						// studentName배열이 꽉차 등록을 못했을경우.
						if(studentNameFlag) {
							System.out.println("학생등록이 꽉 찼습니다. 삭제후 진행해주세요.");
						}
						break;
					case 2:
						// 등록 정보수 체크
						boolean studentNumberFlag = false;
						
						System.out.print("조회할 학생의 이름 또는 학번을 입력해주세요. : ");
						// 학번을 입력받았을 경우.
						if(scan.hasNextInt()) {
							int checkNumber = scan.nextInt();
							int tot = 0;
							for(int i = 0; i < studentName.length; i++) {
								// 입력된 학번이 존재할 경우.
								if(studentNumber[i] == checkNumber) {
									System.out.println("[학생 성적 조회 - ]" + studentName[i]);
									System.out.println("학번 : " + studentNumber[i]);
									for(int j = 0; j < subjectName.length; j++) {
										System.out.print(subjectName[j] + " : " + studentScore[i][j]);
										tot += studentScore[i][j];
									}
									double avg = ((double)tot/subjectName.length);
									System.out.print("총점 : " + tot + "," + "평균 : " + avg);
								}else {
									System.out.println("입력한 학생이 존재하지 않습니다. 다시 입력해주세요.");
								}
							}
						}
						// 이름을 입력받았을 경우.
						else {
							String checkName = scan.next();
							int tot = 0;
							// 입력된 이름이 존재할 경우.
							for(int i = 0; i < studentName.length; i++) {
								if(studentName[i].equals(checkName)) {
									System.out.println("[학생 성적 조회 - ]" + studentName[i]);
									System.out.println("학번 : " + studentNumber[i]);
									for(int j = 0; j < subjectName.length; j++) {
										System.out.print(subjectName[j] + " : " + studentScore[i][j]);
										tot += studentScore[i][j];
									}
									double avg = ((double)tot/subjectName.length);
									System.out.print("총점 : " + tot + "," + "평균 : " + avg);
								}else {
									System.out.println("입력한 학생이 존재하지 않습니다. 다시 입력해주세요.");
								}
							}
						}
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;
					case 6:
						System.out.println("프로그램을 종료합니다.");
						System.exit(0);
						break;
					default:
						System.out.println("선택 번호외 입력입니다. 다시 입력해주세요.");
				}
				
			} else {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				scan.next();
			}	
		}
		

		

	}

}
