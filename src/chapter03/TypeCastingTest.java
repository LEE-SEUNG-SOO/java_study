package chapter03;

/*
 * 형 변환 실습
 */
public class TypeCastingTest {

	public static void main(String[] args) {
		// 자동(묵시적)형변환 : 작은 데이터 타입 -> 큰 데이터 타입
		// 1byte
		byte bdata = 1;
		// 2byte
		short sdata = bdata;
		// 4byte
		int idata = sdata;
		// 8byte
		long ldata = idata;
		
		System.out.println("작은 데이터 타입 -> 큰 데이터 타입");
		System.out.println("byte  : " + bdata);
		System.out.println("short : " + sdata);
		System.out.println("int   : " + idata);
		System.out.println("long  : " + ldata);
		System.out.println("----------------------");
		
		// 4byte -> 4byte
		int number = 100;
		float fnumber = number;
		
		System.out.println("같은 데이터 타입 int와 float 확인(int타입을 float타입에)");
		System.out.println("int    : " + number);
		System.out.println("float  : " + fnumber);
		System.out.println("----------------------");
		
		// 강제(명시적) 형변환 : 큰 데이터 타입 -> 작은 데이터 타입
		// 데이터 유실 주의
		int inumber = 13587952;
		byte bnumber = (byte)inumber;
		
		double dnumber = 12345.67890;
		int inumber2 = (int)dnumber;
		
		System.out.println("큰 데이터 타입 -> 작은 데이터 타입");
		System.out.println("int      : " + inumber);
		System.out.println("byte     : " + bnumber);
		System.out.println("double   : " + dnumber);
		System.out.println("int      : " + inumber2);
		System.out.println("----------------------");
		
	}

}
