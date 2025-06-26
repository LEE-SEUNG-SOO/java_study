package chapter04;
/*
 * 논리연산자 : &&(AND), ||(OR), !(NOT)
 * &&, || 연산자는 앞의 식의 결과에 따라 shortcut로 진행
 */
public class OpLogicTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		
		// &&(AND) : 두 개의 항의 결과가 모두 true 일경우만 true
		System.out.println("a > b AND a == 10 의 결과 : " + ((a > b) && (a == 10))); // true
		System.out.println("a > b AND b == 10 의 결과 : " + ((a > b) && (b == 10))); // false
		System.out.println("a < b AND a == 10 의 결과 : " + ((a < b) && (a == 10))); // false
		System.out.println("a < b AND b == 10 의 결과 : " + ((a < b) && (b == 10))); // false
		System.out.println("----------------------------------------");

		// ||(OR) : 두 개의 항의 결과중 하나라도 true 일경우 true
		System.out.println("a > b OR a == 10 의 결과 : " + ((a > b) || (a == 10))); // true
		System.out.println("a > b OR b == 10 의 결과 : " + ((a > b) || (b == 10))); // true
		System.out.println("a < b OR a == 10 의 결과 : " + ((a < b) || (a == 10))); // true
		System.out.println("a < b OR b == 10 의 결과 : " + ((a < b) || (b == 10))); // false
		System.out.println("----------------------------------------");

		// !(NOT) : 결과를 반대의 boolean값으로 변경
		System.out.println("a > b OR a == 10 의 결과의 반대 : " + (!((a > b) || (a == 10)))); // true
		System.out.println("a > b OR b == 10 의 결과의 반대 : " + (!((a > b) || (b == 10)))); // true
		System.out.println("a < b OR a == 10 의 결과의 반대 : " + (!((a < b) || (a == 10)))); // true
		System.out.println("a < b OR b == 10 의 결과의 반대 : " + (!((a < b) || (b == 10)))); // false
		
		//System.out.println(!a); // a는 int타입으로 boolean타입이 아니기때문에 에러
	}

}
