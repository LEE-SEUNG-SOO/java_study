package chapter11;

public class ExceptionTest3 {

	public static void main(String[] args) {
		
		String name1 = "홍길동";
		String name2 = null;
		ExceptionObject eo = null;
		eo = new ExceptionObject();
		eo.name = "홍길동";
		
		if(name1.equals(name2)) {
			System.out.println("일치");
		} else {
			System.out.println("불일치");
		}
		
//		System.out.println("----------------------------");
//		
//		if(name2.equals(name1)) {
//			System.out.println("일치");
//		} else {
//			System.out.println("불일치");
//		}
//		
		System.out.println("----------------------------");
	
		try {
			if(name1.equals(eo.name)) {
				System.out.println("일치");
			} else {
				System.out.println("불일치");
			}
		} catch (NullPointerException npe){
			System.out.println(npe);
		}
	}
}
