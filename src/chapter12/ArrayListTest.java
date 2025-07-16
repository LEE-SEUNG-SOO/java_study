package chapter12;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		ArrayList<String> slist = new ArrayList<String>();
		
		System.out.println(list.size()); // 채워진 공간 수 출력 : 0
		list.add(100);
		list.add(new String("홍길동"));
		list.add(123.456);
		list.add(new Scanner(System.in));
		System.out.println(list.size()); // 채워진 공간 수 출력 : 4
		
		System.out.println("--------------------------------");
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println("--------------------------------");
		
		
		slist.add("홍길동");
		// slist.add(123); // 문자열만 들어갈 수 있으므로 에러
		slist.add(String.valueOf(123)); // String타입으로 변경후 저장
		
		for(String str : slist) {
			System.out.println(str);
		}
		System.out.println("-------------set----------------");
		slist.set(0, "이순신"); // 기존 0번지의 값을 이순신으로 변경
		
		for(String str : slist) {
			System.out.println(str);
		}
		System.out.println("-------------add of index----------------");
		slist.add(1,"홍길동"); // 리스트의 1번지에 홍길동을 추가(자동 인덱스변경)
		for(String str : slist) {
			System.out.println(str);
		}
		System.out.println("-------------remove----------------");
		slist.remove(2); // 리스트의 2번지 삭제
		for(String str : slist) {
			System.out.println(str);
		}
	}

}
