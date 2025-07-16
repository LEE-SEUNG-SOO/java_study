package chapter12;

public class WrapperTest {

	public static void main(String[] args) {
		int num1 = 100;
		Integer num2 = new Integer(num1); // Deprocated : 나중에 버전업시 삭제 될 수 있음
		Integer num3 = Integer.valueOf(num1);
		int num4 = Integer.parseInt("123");
		double dnum = Double.valueOf("123.456");
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("num3 : " + num3);
		System.out.println("num4 : " + num4);
		System.out.println("dnum : " + dnum);
	
	}
}
