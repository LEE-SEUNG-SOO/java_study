package chapter07;

public class TestCarMain {

	public static void main(String[] args) {
		TestCar tc = new TestCar();
		TestCar tc2 = new TestCar();
		
		System.out.println("-----------대입전-----------");
		tc.output();
		tc2.output();
		System.out.println("------------------------------");
		
		tc.num = 1;
		tc2.num = 2;
		tc2.num2 = 3;
		
		System.out.println("-----------대입후-----------");		
		System.out.println("tc.num <- 1");
		System.out.println("tc2.num <- 2");
		System.out.println("tc2.num2 <-3 ");
		
		tc.output();
		tc2.output();
	}

}
