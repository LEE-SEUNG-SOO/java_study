package chapter05;
/*
 * 정수에 대해 세자리수 마다, 붙여서 출력하기
 * 10000 -> 10,000 
 */
public class FomatTest {

	public static void main(String[] args) {
		
		// 10000
		int a = 10000;
		
		// 세자리수 마다 ,를 붙여 10,000이 출력되게 설정.
		String aa = String.format("%,d", new Object[] {Integer.valueOf(a)});
		System.out.println(aa);

	}

}
