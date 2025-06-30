package chapter06;
/*
 * 향상된 for문 - 배열이나 컬렉션(List) 객체에서 사용
 * 단점 : 인덱스를 확인하고 가져올 수 없다. count변수를 만들어서 확인하기.
 * for(데이터 타입 : 변수명) {
 *  실행문
 * }
 */
public class ArrayOfForTest {

	public static void main(String[] args) {
		int nList[] = {1, 2, 3, 4, 5};
		
		// 1. for문
		System.out.println("--------------for문 사용-----------------");
				
		for(int i = 0 ; i < nList.length; i++) {
			System.out.print(nList[i] + "\t");
		}
		
		System.out.println("\n----------------------------------------");
		
		// 2. 향상된 for문
		System.out.println("------------향상된 for문 사용--------------");
		
		for(int number : nList) {
			System.out.print(number + "\t");
		}
		
		System.out.println("\n----------------------------------------");
	}

}
