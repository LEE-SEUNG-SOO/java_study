package chapter13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set 인터페이스
 */
public class SetTest {

	public static void main(String[] args) {
		Set<String> foods = new HashSet<String>();
		
		// 1. 데이터 저장 C (Create)
		foods.add("된장찌개");
		foods.add("김치찌개");
		foods.add("짜장면");
		foods.add("짜장면"); // 중복 불가. 에러는 안뜨나 쓸모없는 처리
		
		// 2. 데이터 읽기 R (Read)
		foods.forEach(System.out::println);		
		System.out.println("-------------------------");
		
		// 3. 데이터 수정 U (Update)
		if(foods.contains("짜장면")) {
			foods.remove("짜장면");
			foods.add("짬뽕");
		}

		foods.forEach(System.out::println);		
		System.out.println("-------------------------");		
		
		// 4. 데이터 삭제 D (Delete)
		// Set은 원래 Set형태이므로 Iterator를 사용할 필요가 없음.
		if(foods.contains("김치찌개")) {
			foods.remove("김치찌개");
		}	
		
		Iterator<String> ie = foods.iterator(); // 제너릭으로 타입을 제한하지 않으면 Object 타입으로 생성된다.
		
		while(ie.hasNext()) {
			if(ie.next().equals("김치찌개")) {
				ie.remove();
			}
		}
		
		foods.forEach(System.out::println);		
		System.out.println("-------------------------");	
	}

}
