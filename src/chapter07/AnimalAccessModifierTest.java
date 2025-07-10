package chapter07;

import java.util.Calendar;

import commons.Animal;
/*
 *  접근 제어자
 */
public class AnimalAccessModifierTest {

	public static void main(String[] args) {
		// Calendar c = new Calendar(); // Calendar는 protected 접근제어자를 사용하고 있으므로 상속관계가 아니면 생성 불가.
		Calendar c = Calendar.getInstance(); // 생성된 객체의 인스턴스 주소를 가져옴 싱글톤 패턴
		Calendar d = Calendar.getInstance();

		System.out.println(c.getTime());
		
		AnimalAccessModifier.sname = "static";
		AnimalAccessModifier.sage = 3;
		AnimalAccessModifier.getInfo3();
		System.out.println("--------------------------");
		
		AnimalAccessModifier aam = new AnimalAccessModifier();
		
		aam.sname = "static2";
		aam.sage = 3;
		aam.getInfo3();
		System.out.println("--------------------------");
		
		Animal comDog = new Animal(); // import를 하면 해당 패키지의 클래스를 가져온다.
		
		// *************************public**********************************
		aam.publicName = "심바";
		aam.publicAge = 5;
		
		System.out.println("------public--------");
		System.out.println("publicName : " + aam.publicName);
		System.out.println("publicAge : " + aam.publicAge);
		System.out.println("--------------------");
		
		// *************************default**********************************
		aam.defaultName = "심바";
		aam.defaultAge = 5;
		System.out.println("------default--------");
		System.out.println("defaultName : " + aam.defaultName);
		System.out.println("defaultAge : " + aam.defaultAge);
		System.out.println("--------------------");
		
		// *************************다른 패키지**********************************
		//comDog.name = "예삐"; // 같은 패키지 내에서만 접근 가능하므로 에러
		//comDog.age = 2; // 같은 패키지 내에서만 접근 가능하므로 에러
		
		comDog.publicName = "예삐"; // public으로 접근제어자를 설정함으로써 다른 패키지에서 접근 가능
		comDog.publicAge = 5;// public으로 접근제어자를 설정함으로써 다른 패키지에서 접근 가능
		
		System.out.println("------ather pakage--------");
		System.out.println("publicName : " + comDog.publicName);
		System.out.println("publicAge : " + comDog.publicAge);
		System.out.println("--------------------------");
		
		// *************************private**********************************
		// 생성자를 통해 private로 설정된 변수에 값 설정
		AnimalAccessModifier aam2 = new AnimalAccessModifier("호순이",5);
		
		//aam2.privateName = "심바"; // private이므로 해당 클래스 내에서만 접근 가능하므로 에러
		//aam2.privateAge = 5; // private이므로 해당 클래스 내에서만 접근 가능하므로 에러
		
		aam2.setPrivateName("심바"); // setter메소드를 사용한 값설정
		aam2.setPrivateAge(5); // setter메소드를 사용한 값설정
		
		System.out.println("--------private----------");
		System.out.println("privateName : " + aam2.getPrivateName()); // getter메소드를 사용한 값 호출
		System.out.println("privateAge : " + aam2.getPrivateAge()); // getter메소드를 사용한 값 호출
		System.out.println("--------------------------");
		
		comDog.setPrivateName("호수니");
		comDog.setPrivateAge(3);
		
		System.out.println("comDog.getPrivateName : " + comDog.getPrivateName());
		System.out.println("comDog.getPrivateAge : " + comDog.getPrivateAge());
		
		
		// final
		System.out.println("--------final----------");
		
		// aam.fname = "홍"; // final 키워드의 변수이므로 외부에서 값 변경불가.
		// aam.fage = 5; // final 키워드의 변수이므로 외부에서 값 변경불가.
		
		// final 상수 호출
		System.out.println("START : " + AnimalAccessModifier.START);
		System.out.println("CONTINUE : " + AnimalAccessModifier.CONTINUE);
		System.out.println("END : " + AnimalAccessModifier.END);
		System.out.println("----------------------");
		
	}

}
