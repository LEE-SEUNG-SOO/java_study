package chapter06;
/*
 * 배열 생성시 초기화에 대한 에러 확인
 */
public class ArrayTest01 {
	
	static int[] arrInt3;
	
	public static void main(String[] args) {
		int[] arrInt;
		int arrInt2[] = null;
		
//		System.out.println(arrInt); // 에러발생 : 지역변수로 초기화하지 않았기에 에러
		System.out.println(arrInt2); //에러X
		System.out.println(arrInt3); // 에러X : 초기화 하지않았으나 전역변수로 JVM이 자동으로 초기화시켜주기때문에 에러X

	}

}
