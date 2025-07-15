package chapter08;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Collection의 클래스들이 인터페이스기반으로 설계가 됨
 * 인터페이스 기반으로 객체 생성하는것을 권장
 */
public class CollectionTest {

	public static void main(String[] args) {
		List list = new ArrayList();
		List list3 = new Vector();
		
		list.add("홍길동");
		
		System.out.println(list.get(0));
				
		List<String> list2 = new ArrayList<String>();
		
	}

}
