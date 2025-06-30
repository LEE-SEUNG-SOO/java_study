package chapter06;
/*
 * 배열과 반복문(for) 연습
 */
public class ArrayTest03 {

	public static void main(String[] args) {
		// 배열 객체 선언 - 1에서 5까지의 데이터를 저장 후 순서대로 출력
		int numbers[] = new int[5]; // 배열의 전체 크기 : 변수명.length

		// 데이터 저장 반복문(for) 사용
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}
		
		// 데이터 출력 반복문(for) 사용
		for(int i = 0; i < numbers.length; i++) {
			System.out.println("numbers[" + i + "] 출력 : " + numbers[i]);
		}
		
//		numbers[0] = 1;
//		numbers[1] = 2;
//		numbers[2] = 3;
//		numbers[3] = 4;
//		numbers[4] = 5;

//		System.out.println(numbers[0]);
//		System.out.println(numbers[1]);
//		System.out.println(numbers[2]);
//		System.out.println(numbers[3]);
//		System.out.println(numbers[4]);
//		
	}

}
