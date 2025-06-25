package chapter03;

/*
 * 변수의 범위 설정 : Global(전역), Local(지역, 로컬)
 */
public class VariableScorpeTest {
	
	// 전역 변수 설정
	static int gNumber = 10;
	
	// 전역 상수 설정
	static final int START = 1;
	static final int END = 0;

	public static void main(String[] args) {
		// main메소드의 지역 변수
		int number = 100;
		String str = new String("홍길동");
		String str2; // str2선언
		
		//number2는 해당 블록에서만 사용가능
		{
			str2 = "홍길순"; // 할당
			int number2 = 200;
			System.out.println("지역변수 number2 : " + number2);
			System.out.println("지역변수 str2    : " + str2);
		}

		// 출력
		System.out.println("전역변수 gNumber : " + gNumber);
		System.out.println("지역변수 number  : " + number);
		System.out.println("전역상수 START   : " + START);
		System.out.println("전역상수 END     : " + END);
		System.out.println("참조변수 str     : " + str);
		System.out.println("지역변수 str2    : " + str2);
		
		// number2는 선언한 블록 안에서만 사용가능
//		System.out.println("지역변수 number2 : " + number2);
	
	}
}
