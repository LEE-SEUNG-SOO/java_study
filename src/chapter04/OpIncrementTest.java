package chapter04;
/*
 * 증감연산자 : ++, --
 */
public class OpIncrementTest {

	public static void main(String[] args) {
		int number = 10;
		
		// 현재 number값 확인
		System.out.println("현재 number : " + (number)); // 10출력
		
		// 10에서 1이 증가한 후 출력
		System.out.println("++number : " + (++number)); // 11출력

		// 11을 출력한 후 1증가
		System.out.println("number++ : " + (number++) + "\n"); // 11출력(number는 12)

		// 현재 number값 확인
		System.out.println("현재 number : " + (number)); // 12출력

		// 12에서 1이 감소한 후 출력
		System.out.println("--number : " + (--number)); // 11출력

		// 11을 출력한 후 1감소
		System.out.println("number-- : " + (number--) + "\n"); // 11출력(number는 10)

		// 현재 number값 확인
		System.out.println("현재 number : " + (number)); // 10출력
		
	}

}
