package chapter06;

import java.util.Scanner;

/*
 * 메뉴 등록/출력/검색 프로그램
 * 메뉴 : 피자, 햄버거, 라면, 샐러드
 * 메뉴명, 이모지, 가격을 저장
 * 메뉴명, 이모지, 가격은 각각 1차원 배열로 생성하여 관리
 * 메뉴 관리를 위해서 각 배열의 주소를 통일시킨다.
 * 
 */
public class MenuTestVer1 {

	public static void main(String[] args) {
		// 0. 변수 선언
		Scanner scan = new Scanner(System.in);
		System.out.print("메뉴 갯수 설정 : ");
		
		// 메뉴 최대 갯수
		final int MAX_SIZE = scan.nextInt();
		// 메뉴명
		String[] menuNameList = new String[MAX_SIZE];
		// 이모지
		String[] menuEmojiList = new String[MAX_SIZE];
		// 가격
		int[] menuPriceList = new int[MAX_SIZE];
		// 반복문 제어
		boolean menuFlag = true;
		// 등록한 메뉴 갯수
		int menuCount = 0;
		
		while(menuFlag) {
			// 1. 초기 화면
			System.out.println("--------------------------------------------");
			System.out.println("더 조은 레스토랑 메뉴 관리 프로그램");
			System.out.println("1. 메뉴 등록");
			System.out.println("2. 메뉴 출력");
			System.out.println("3. 메뉴 검색");
			System.out.println("9. 프로그램 종료");
			System.out.println("--------------------------------------------");
			System.out.print("메뉴를 선택해주세요 : ");
			int selectMenu = scan.nextInt();
			
			// 2. 메뉴 등록
			if(selectMenu == 1) {
				// 등록할 공간이 남아 있을경우
				if(menuCount < MAX_SIZE){
					// 등록 가능한 공간만큼 반복
					for(int i = menuCount; i < MAX_SIZE; i++) {
						System.out.print("메뉴명 : ");
						menuNameList[i] = scan.next();
						System.out.print("이모지 : ");
						menuEmojiList[i] = scan.next();
						System.out.print("가격 : ");
						menuPriceList[i] = scan.nextInt();
						
						// 메뉴 갯수 1증가
						menuCount++;
						
						// 메뉴 갯수가 최대치에 달했을경우
						if(menuCount == MAX_SIZE) {
							System.out.println("메뉴를 최대치까지 등록 했습니다. 메뉴 화면으로 이동됩니다.");
						} else {
							System.out.print("계속 등록하시겠습니까?(y/n) : ");
							if(scan.next().equals("n")) {
								i = MAX_SIZE;
								System.out.println("> 등록 완료");
							}
						}
					}
				}
				// 등록할 공간이 없을 경우
				else {
					System.out.println("설정 메뉴 갯수를 초과했습니다. 최대 : " + MAX_SIZE + "개");
				}
			}
		
			// 3. 메뉴 출력
			else if(selectMenu == 2) {
				if(menuCount > 0) {
					System.out.println("--------------------------------------------");
					System.out.println("메뉴명\t이모지\t가격" );
					System.out.println("--------------------------------------------");
					
					// 등록된 메뉴수만큼 출력
					for(int i = 0; i < menuCount; i++) {
						System.out.print(menuNameList[i] + "\t");
						System.out.print(menuEmojiList[i] + "\t");
						System.out.print(menuPriceList[i] + "\n");
					}
					System.out.println("--------------------------------------------");
				} else {
					System.out.println("등록된 메뉴가 없습니다. 메뉴등록을 해주세요.");
				}
			}
			
			// 4. 메뉴 검색
			else if(selectMenu == 3) {
				if(menuCount > 0) {
					boolean searchFlag = true;
					
					while(searchFlag) {
						System.out.print("검색할 메뉴를 입력해주세요.(종료:n) : ");
						String searchMenu = scan.next();
						// 검색 인덱스
						int searchMenuIdx = -1;
						
						if(!searchMenu.equals("n")) {
							// 등록된 메뉴수만큼 반복
							for(int i = 0; i < menuCount; i++) {
								// 검색한 메뉴명과 일치하는 메뉴가 있을 경우
								if(searchMenu.equals(menuNameList[i])) {
									searchMenuIdx = i;
									i = menuCount;
								}
							}
							
							if(searchMenuIdx < 0) {
								System.out.println("일치하는 메뉴가 없습니다.");
							} else {
								System.out.println("--------------------------------------------");
								System.out.println("메뉴명\t이모지\t가격" );
								System.out.println("--------------------------------------------");
								System.out.print(menuNameList[searchMenuIdx] + "\t");
								System.out.print(menuEmojiList[searchMenuIdx] + "\t");
								System.out.print(menuPriceList[searchMenuIdx] + "\n");
								System.out.println("--------------------------------------------");
							}	
						} else {
							// 검색 종료
							searchFlag = false;
						}
					}// search while
				} 
				// 등록한 메뉴가 없을 경우
				else {
					System.out.println("등록된 메뉴가 없습니다. 메뉴등록을 해주세요.");
				}
			}
			
			// 5. 프로그램 종료
			else if(selectMenu == 9) {
				System.out.println("-- 프로그램 종료 --");
				System.exit(0);
			}
			// 그 외 번호 입력
			else {
				System.out.println("메뉴 준비중입니다.");
			}
		}
	}

}
