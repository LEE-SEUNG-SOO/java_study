package chapter10;

public class OuterTest {

	public static void main(String[] args) {
		Outer outer = new Outer();
		
		System.out.println("outer.name : " + outer.name);
		
		Outer.Inner iner = new Outer.Inner();
		System.out.println("iner.name : " + iner.name);
		// static
		System.out.println("outer.iner.name : " + Outer.Inner.name);
		
	}
}
