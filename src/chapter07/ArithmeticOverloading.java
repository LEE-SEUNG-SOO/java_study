package chapter07;
/*
 * 오버로딩
 */
public class ArithmeticOverloading {
	// Field
	// Constructor
	// Method
	
	// add() 메소드의 오버로딩
	public int add(int x , int y) {	return (x + y);	}
	public int add(double x, double y) { return (int)(x + y); }
	public int add(String x, String y) {
		// 문자열값을 정수형으로 변환
		int xx = Integer.valueOf(x);
		int yy = Integer.valueOf(y);
		
		return (xx + yy); 
		}
	
	// 가변매개변수
	public int add(int ... numbers) {
		int sum = 0;
		for(int number : numbers) {
			sum += number;
		}
		return sum;
	}
	// 가변매개변수
	public int add(String ... numbers) {
		int sum = 0;
		for(String number : numbers) {
			sum += Integer.valueOf(number);
		}
		return sum;
	}
}
