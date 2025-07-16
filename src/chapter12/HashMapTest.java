package chapter12;

import java.util.HashMap;
import java.util.Scanner;

import commons.Animal;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		HashMap<String, String> map2 = new HashMap<String, String>();
		
		Animal animal = new Animal();
		animal.name = "호돌이";
		animal.age = 10;
		

		
		map.put("name", "홍길동");
		map.put("age", 10);
		map.put("scan", new Scanner(System.in));
		map.put("animal", animal); // animal 객체를 HashMap에 설정
		
		Animal aa = (Animal)map.get("animal"); // 객체를 넣었을경우 형변환 필요.
		aa.sleep(); // 출력
		
		System.out.println(map.get("name"));
		System.out.println(map.get("age"));
		System.out.println(map.get("scan"));
		System.out.println("------------------------------");
		
		map2.put("name", "홍길동");
		//map2.put("age", 10); // 값이 String타입이 아니기때문에 에러
		map2.put("age", String.valueOf(10));
		
		System.out.println(map2.get("name"));
		System.out.println(map2.get("age"));
		
	}

}
