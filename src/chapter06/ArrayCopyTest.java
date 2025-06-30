package chapter06;

import java.util.Arrays;

/*
 * 배열 복사방법
 * 1. for
 * 2. System.arrayCopy()
 * 3. Arrays 클래스 : Arrays.copyOf()
 */
public class ArrayCopyTest {

	public static void main(String[] args) {
		// 1. for문을 이용한 복사
		int arrInt[] = { 1, 2, 3 };
		int arrInt2[] = new int[5];
		
		System.out.println("arrInt 내용 확인");
		for (int i = 0 ; i < arrInt.length; i++) {
			System.out.print(arrInt[i] + "\t");
		}
		System.out.println();
		
		System.out.println("--------------------for문을 이용한 복사------------------");
		
		for(int i = 0 ; i < arrInt.length ; i++) {
			arrInt2[i] = arrInt[i];
		}

		System.out.println("arrInt2 복사 결과");
		for (int i = 0 ; i < arrInt2.length; i++) {
			System.out.print(arrInt2[i] + "\t");
		}

		System.out.println("\n-------------------------------------------------------");
		
		// 2. System.arrayCopy()를 이용한 복사
		int arrInt3[] = new int[3];
		System.out.println("------------- System.arrayCopy()를 이용한 복사-----------");
		
		// System.arraycopy(복사 원본, 복제 위치, 복제본, 복제본 위치, 길이)
		System.arraycopy(arrInt, 0, arrInt3, 0, arrInt.length);
		System.out.println("arrInt3 복사 결과");
		
		for (int i = 0 ; i < arrInt3.length; i++) {
			System.out.print(arrInt3[i] + "\t");
		}
		
		System.out.println("\n-------------------------------------------------------");
		
		// 3. Arrays.copyOf()를 이용한 복사
		int arrInt4[] = new int[5];
		System.out.println("--------------- Arrays.copyOf()를 이용한 복사-------------");
		
		// Arrays.copyOf(복사 원본, 길이)
		// 배열을 새롭게 만들기 때문에 기존에 만든 5배열이 arrInt의 배열로 변경된다.
		arrInt4 = Arrays.copyOf(arrInt, arrInt.length);
		System.out.println("arrInt4 복사 결과");
		
		for (int i = 0 ; i < arrInt4.length; i++) {
			System.out.print(arrInt4[i] + "\t");
		}
		
		System.out.println("\n-------------------------------------------------------");
		
		
	}

}
