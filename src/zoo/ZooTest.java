package zoo;

import java.util.ArrayList;
import java.util.List;

public class ZooTest {

	public static void main(String[] args) {
		
		List<Lion> list = new ArrayList<Lion>(); // Lion클래스 객체의 데이터만 들어감.
		List<AnimalInterface> list2 = new ArrayList<AnimalInterface>(); // AnimalInterface를 상속받은 모든 클래스객체가 들어가짐.
		
		Lion lion1 = new Lion();
		Tiger tiger1 = new Tiger();
		
		list.add(lion1);
//		list.add(tiger1); // Lion타입이 아니므로 list에 설정할 수 없다.(list는 lion 클래스 객체만 저장 가능)
		
		list2.add(lion1); // Lion타입은 AnimalInterface를 상속받은 부모클래스의 자식이므로 설정가능
		list2.add(tiger1); // tiger타입은 AnimalInterface를 상속받은 부모클래스의 자식이므로 설정가능
		
		list.get(0).sleep(); // list.get(0) -> lion1
		list2.get(0).sleep(); // list2.get(0) -> lion1
		list2.get(1).sleep(); // list2.get(1) -> tiger1
				
		Lion lion2 = (Lion)list.get(0); // 객체의 저장된 속성(값)은 강제(명시적)형변환을 통해 진행
		System.out.println(list.get(0).getName());
	}
}
