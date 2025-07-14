package chapter08;

public class Testsetst implements ShapeInterface{
	
	private static Animal a = new Animal();
	
	private Testsetst() {
		
	}

	public static Animal getA() {
		System.out.println(TEST);
		return a;
	}

	public static void setA(Animal a) {
		Testsetst.a = a;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}
}
