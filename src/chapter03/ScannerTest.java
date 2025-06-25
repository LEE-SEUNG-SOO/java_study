package chapter03;

import java.util.Scanner;

/*
 * Scanner 연습
 */
public class ScannerTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("이름을 입력해주세요. : ");
		//scan.next() : 키보드입력값을 String형태로 변환
		String name = scan.next();

		System.out.print("나이를 입력해주세요. : ");
		//scan.nextInt() : 키보드입력값을 int형태로 변환
		int age = scan.nextInt();

		System.out.print("과목을 입력해주세요. : ");
		//scan.nextInt() : 키보드입력값을 int형태로 변환
		String subject = scan.next();
		
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("과목 : " + subject);

	}

}
