package chapter06;
/*
 * 배열 생성 및 할당 테스트
 */
public class ArrayTest02 {
		
	public static void main(String[] args) {
		// names 문자열 변수 선언 및 생성
		String names[];
		String[] names2;
		
		// 3개의 배열생성
		names = new String[3];
		// 5개의 배열생성 
		names2 = new String[5];
		
		int scores[] = new int[10];
//		int[] scores2 = new double[10];	// stack영역의 데이터 타입과 heap영역의 데이터 타입이 다르므로 에러	
		int[] scores3 = {10 , 20 , 30};
		String[] names3 = {"홍","이"};
		
		// names의 주소값 출력
		System.out.println("names 출력 : " + names);
		// names의 첫번째값 출력
		System.out.println("names[0] 출력 : " + names[0]);
		// names의 첫번째값 = 홍길동 
		names[0] = "홍길동";
		// names의 첫번째값 출력
		System.out.println("names[0] 출력 : " + names[0]);
		// names의 두번째값 = "이순신"
		names[1] = "이순신";
		// names의 두번째값 출력
		System.out.println("names[1] 출력 : " + names[1]);
		
		System.out.println("----------------------------------");
		
		// scores의 주소값출력
		System.out.println("scores 출력 : " + scores);
		// scores의 첫번째값 출력
		System.out.println("scores[0] 출력 : " + scores[0]);
		
		// scores의 값 변경
		scores[0] = 100;
		scores[1] = 200;
		scores[2] = 300;
		
		// scores의 첫번째값 출력
		System.out.println("scores[0] 출력 : " + scores[0]);		
		// scores의 두번째값 출력
		System.out.println("scores[1] 출력 : " + scores[1]);
		// scores의 세번째값 출력
		System.out.println("scores[2] 출력 : " + scores[2]);
		
	}

}
