package chapter13;

import java.util.HashMap;
import java.util.Map;

/**
 * Set 인터페이스
 */
public class MapTest {

	public static void main(String[] args) {
		// key, value
		Map<Integer, String> subjects = new HashMap<Integer,String>();
		
		// 1. 데이터 저장 C (Create)
		subjects.put(1, "java");
		subjects.put(2, "html");
		subjects.put(3, "css");
		subjects.put(4, "mysql");
		
		// 2. 데이터 읽기 R (Read)
		// subjects.forEach(System.out::println); // key와 value 둘중 누구를 출력해야하는지 명확하지 않기때문에 에러
		subjects.forEach( (key, value) -> {
			System.out.println(key + ", " + value);
		});
		System.out.println("--------------------");
		
		// 3. 데이터 수정 U (Update)
		if(subjects.containsKey(4)) {
//			subjects.put(4, "Oracle");
			subjects.replace(4, "Oracle");
		}
		
		subjects.forEach( (key, value) -> {
			System.out.println(key + ", " + value);
		});
		System.out.println("--------------------");
				
		// 4. 데이터 삭제 D (Delete)
		subjects.remove(4); // 해당 key 데이터 삭제
		
		subjects.forEach( (key, value) -> {
			System.out.println(key + ", " + value);
		});
		System.out.println("--------------------");
		
		subjects.clear(); // 전체 삭제
		System.out.println("== 전체 삭제 완료 ==");
		
		subjects.forEach( (key, value) -> {
			System.out.println(key + ", " + value);
		});
		System.out.println("--------------------");
		
	}

}
