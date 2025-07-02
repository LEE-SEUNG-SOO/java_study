package chapter06;

import java.util.Scanner;

/*
 * 음식 주문/결제 프로그램(콘솔)
 * 음식을 주문(1), 결제(2), 프로그램 종료(9)하는 메뉴로 구성된다.
 * 프로그램 종료를 제외하고 나머지 메뉴는 반복 선택 가능.
 * 메뉴 선택 시 체크하는 기능은 switch~case를 이용하여 구현한다.
 * 
 * 반복문 사용
 * 예외사항 처리 : 메뉴 선택, 결제금액 입력시 정수형 타입이 아닌경우 메세지 출력후 재입력 유도
 * 				결제 금액이 메뉴의 금액보다 낮을 경우 재입력 유도(결제 금액 누적)
 * 				입력값이 정확할 때까지 재입력 유도(flag 변수 사용)
 */
public class LunchOrderTestVer3MultiArray {

	public static void main(String[] args) {
		// 주문 최대치
		Scanner scan = new Scanner(System.in);
		System.out.print("주문 리스트 크기 설정 : ");
		
		final int MAX_SIZE = scan.nextInt();
		final int MAXLIST_SIZE = 3;
		// 주문 음식 리스트
		String[] menuList = {"햄버거(🍔)", "피이자(🍕)", "라아면(🍜)", "샐러드(🥗)"};
		// 주문 음식 가격
		int[] priceList = {100, 200, 300, 400};		
		// 주문 리스트(번호로 저장)
		int[] orderList = new int[MAX_SIZE];
		// 주문 내역 리스트
		// 주문 리스트 + 입금 금액 + 결제 금액 + 잔액 + 주문한 음식수
		int[][][] testList = new int[MAXLIST_SIZE][1][MAX_SIZE+4];	
		// 주문한 음식수
		int orderCount = 0;
		// 결제 내역 수
		int paymentCount = 0;
		// 총 결제 금액
		int totalPayment = 0;

		boolean menuFlag = true;
		
		while(menuFlag) {
			// 메뉴판
			System.out.println("*************************************************");
			System.out.println("\t @@@@Welcom to Food Mart@@@@");
			System.out.println("*************************************************");
			System.out.println("\t 1. 음식 주문");
			System.out.println("\t 2. 주문 내역");
			System.out.println("\t 3. 음식 결제");
			System.out.println("\t 4. 결제 내역");
			System.out.println("\t 9. 프로그램 종료");
			System.out.println("*************************************************");
			System.out.println("************Food Mart에 오신것을 환영합니다***********");
			System.out.print("메뉴를 선택해주세요. : ");
			int selectMenu = scan.nextInt();
			
			switch(selectMenu) {
			// 1. 음식 주문
			case 1:
				// 주문 수가 최대치 보다 작을경우
				if(orderCount < MAX_SIZE) {
					// 추가 주문 플래그
					boolean orderFlag = true;
					while(orderFlag) {
						System.out.println("********************음식 목록*********************");
						// 음식 목록 출력
						for(int i = 0; i < menuList.length; i++) {
							System.out.println("\t " + (i+1) + ". " + menuList[i] + " : "	+ String.format("%,d", new Object[] {priceList[i]}) + "원");
						}
						System.out.println("*************************************************");
						System.out.print("음식을 선택해주세요.(최대 "+MAX_SIZE+"개) : ");
						// 음식 선택
						int menuNo = scan.nextInt();
						
						// if문 사용(논리 연산자)
						if(menuNo > 0 && menuNo < 5) {
							// 주문한 음식번호 설정(1~4번 입력시 동일한 로직실행)
							orderList[orderCount] = menuNo-1;
							// 주문 갯수 설정
							orderCount++;
							// 총 결제액 설정
							totalPayment += priceList[menuNo-1];
							// 주문 내역 출력
							System.out.println(menuList[menuNo-1] + " 주문 완료");
						} else {
							System.out.println("음식 준비중입니다.");
						}
						
						// 주문치가 최대일 경우
						if(orderCount == MAX_SIZE) {
							System.out.println("주문 할 수 있는 최대수량(" + MAX_SIZE +")을 초과하였습니다. 메뉴화면으로 돌아갑니다.");
							orderFlag = false;
						}
						// 추가 입력 선택
						else {
							System.out.print("계속 주문하시겠습니까?(y/n) : ");
							if(scan.next().equals("n")) {
								orderFlag = false;
							}
						}
					}
				} else {
					System.out.println("주문 할 수 있는 최대수량을 초과하였습니다. 메뉴화면으로 돌아갑니다.");
				}
				break;
			// 2. 주문 내역
			case 2:
				// 주문 내역이 있을경우.
				if(orderCount > 0) {
					System.out.println("------- 주문 내역 -------");
					for(int i = 0; i < orderCount; i++) {
						System.out.print((i+1) + ". " + menuList[orderList[i]] +" : " + String.format("%,d", new Object[] {priceList[orderList[i]]}) + "원");
						System.out.println();
					}
					System.out.println("-----------------------");
				} else {
					System.out.println("주문하신 음식이 없습니다.");
				}
				break;				
			// 3. 음식 결제
			case 3:
				// 주문 내역이 있을경우.
				if(orderCount > 0) {
					boolean paymentFlag = true;
					int charge = 0;
					
					while(paymentFlag) {
						System.out.println("결제 예정 금액 : " + String.format("%,d", new Object[] {totalPayment}) + "원");
						System.out.println("입금 금액 : " + String.format("%,d", new Object[] {charge})+ "원");
						System.out.println("남은 금액 : " + String.format("%,d", new Object[] {totalPayment-charge})+ "원");
						System.out.print("금액을 입력해주세요. : ");
						charge += scan.nextInt();

						// 총 입금액 >= 결제 예정 금액
						if(charge >= totalPayment) {
							System.out.println("------- 주문 내역 -------");
							// 주문한 목록 출력
							for(int i = 0; i < orderCount; i++) {
								System.out.print(menuList[orderList[i]] + " ");
							}
							System.out.println("\n-----------------------");
							System.out.println("결제 금액" + " : "+ String.format("%,d", new Object[] {totalPayment}) + "원");
							System.out.println("입금 금액" + " : "+ String.format("%,d", new Object[] {charge}) + "원");
							System.out.println("잔돈" + " : " + String.format("%,d", new Object[] {(charge-totalPayment)}) + "원"+"입니다.");
							
							// 주문 내역이 가득 찼을경우.
							if(paymentCount >= MAXLIST_SIZE) {
								for(int i = 0; i < MAXLIST_SIZE - 1; i++) {
									for(int j = 0; j < testList[i][0].length; j++) {
										// 가장 오래된 내역 삭제(배열을 한칸씩 이동)
										testList[i][0][j] = testList[i+1][0][j];
									}
								}
								paymentCount--;
							}			
							
							// 주문 내역
							for(int i = 0; i < orderCount; i++) {
								testList[paymentCount][0][i] = 	orderList[i];
							}

							// 입금 금액
							testList[paymentCount][0][MAX_SIZE] = charge;
							// 총 결제 금액
							testList[paymentCount][0][MAX_SIZE+1] = totalPayment;
							// 잔돈
							testList[paymentCount][0][MAX_SIZE+2] = charge-totalPayment;
							// 주문 갯수
							testList[paymentCount][0][MAX_SIZE+3] = orderCount;
							
							// 결제 내역 건수
							paymentCount++;
							
							// 주문 리스트 초기화
							orderList = new int[MAX_SIZE];
							// 주문 내역 초기화
							orderCount = 0;
							// 결제 금액 초기화
							totalPayment = 0;

							paymentFlag = false;
						} else {
							System.out.println("금액이 부족합니다.");
						}
					}
				} else {
					System.out.println("주문하신 음식이 없습니다.");
				}
				break;

			// 4. 결제 내역
			case 4:
				// 결제 내역이 있을 경우
				if(paymentCount > 0) {
					System.out.println("----------------------------------------------------------------------------");
					System.out.println("번호\t주문메뉴\t\t\t\t입금액\t결제금액\t잔돈");
					System.out.println("----------------------------------------------------------------------------");
					for(int i = 0; i < paymentCount; i++) {
						// 번호
						System.out.print((i + 1) + "\t");
						// 주문 메뉴
						for(int j = 0; j < testList[i][0][MAX_SIZE+3]; j++) {
							System.out.print(menuList[testList[i][0][j]] + " ");
						}
						// 주문 메뉴의 수에 따라 탭 설정(표시정렬을 위해)
						switch(testList[i][0][MAX_SIZE+3]) {
							case 1:
								System.out.print("\t\t\t");
								break;
							case 2:
								System.out.print("\t\t");
								break;
							case 3:
								System.out.print("\t");
								break;
							default:
						}
						// 입금액
						System.out.print(testList[i][0][MAX_SIZE] + "\t");
						// 결제금액
						System.out.print(testList[i][0][MAX_SIZE+1] + "\t");
						// 잔돈
						System.out.print(testList[i][0][MAX_SIZE+2] + "\t");
						System.out.println();			
					}
					System.out.println("----------------------------------------------------------------------------");
				} 
				// 결제 내역이 없을경우
				else {
					System.out.println("결제 내역이 없습니다.");
				}
				break;
			
			// 9. 프로그램 종료	
			case 9:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			
			// 그 외 다른입력
			default:
				System.out.println("메뉴 준비중입니다.");
			}
		}
	}

}
