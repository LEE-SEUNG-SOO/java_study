package chapter03;
/*
 * 기본자료형 테스트
 */

public class PrimitiveDataTypeTest {

	public static void main(String[] args) {
		// 논리형 데이터 타입
		boolean run = true;
		System.out.println("논리형 데이터 타입");
		System.out.println("boolean : " + run);
		System.out.println("----------------------");
		
		// 정수형 데이터 타입
		byte b = 1;
		short s = 10;
		int i = 100;
		long l = 1000;
		long l2 = 1000L;
		System.out.println("논리형 데이터 타입");
		System.out.println("byte    : " + b);
		System.out.println("short   : " + s);
		System.out.println("int     : " + i);
		System.out.println("long    : " + l);
		System.out.println("long2   : " + l2);
		System.out.println("----------------------");
		
		// 실수형 데이터 타입
		float f = 10.0f;
		double d = 100.0;
		System.out.println("논리형 데이터 타입");
		System.out.println("float   : " + f);
		System.out.println("double  : " + d);
		System.out.println("----------------------");
		
		// 문자리터럴 데이터 타입
		char c = 'a';
		char c2 = 'A';
		int c_asc = c;
		int c_asc2 = c2;
		char str = '홍';
//		char str2 = "홍"; char는 반드시 ''사용
		
		System.out.println("논리형 데이터 타입");
		System.out.println("char    : " + c);
		System.out.println("char2   : " + c2);
		System.out.println("char ascii  : " + c_asc);
		System.out.println("char ascii2 : " + c_asc2);
		System.out.println("----------------------");
		
		//상수 정의 : 프로그램 시작부터 종료까지 같은 값을 가지며, 상수명은 전체 대문자로 선언
		// final 데이터타입 변수명
		// 프로그램 시작 : START(1), 종료 : END(0)
		final int START = 1;
		final int END = 0;
		
		System.out.println("상수 정의");
		System.out.println("START   : " + START);
		System.out.println("END     : " + END);
		System.out.println("----------------------");
		
		
	}
}
