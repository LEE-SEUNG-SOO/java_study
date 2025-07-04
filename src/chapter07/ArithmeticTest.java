package chapter07;
/*
 * Arithmetic 메인
 */
public class ArithmeticTest {

	public static void main(String[] args) {
		Arithmetic arithmetic = new Arithmetic();
		ArithmeticOverloading arithmetic2 = new ArithmeticOverloading();
		
		int result1 = arithmetic2.add(10, 20);
		int result2 = arithmetic2.add(3.14, 1.5);
		int result3 = arithmetic2.add("10", "20");
		int result4 = arithmetic2.add(1,2,3,4,5,6,7,8,9,10);
		int result5 = arithmetic2.add("1","2","3");
		
		System.out.println("arithmetic_ol.add : " + result1);
		System.out.println("arithmetic_ol.add : " + result2);
		System.out.println("arithmetic_ol.add : " + result3);
		System.out.println("arithmetic_ol.add : " + result4);
		System.out.println("arithmetic_ol.add : " + result5);
		
		System.out.println("-----------------------------------------------");
		
		// add
		int add = arithmetic.add(10.7, 20.8);
		// sub
		int sub = arithmetic.sub(10, 20);
		// mul
		double mul = arithmetic.mul(3.14, 10);
		// div
		int div = arithmetic.div(10, 20);
		// mod
		int mod = arithmetic.mod(10, 20);
		
		System.out.println("add = " + add);
		System.out.println("sub = " + sub);
		System.out.println("mul = " + mul);
		System.out.println("div = " + div);
		System.out.println("mod = " + mod);
		
		System.out.println("-----------------------------------------------");
		
	}

}
