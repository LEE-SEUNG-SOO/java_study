package chapter04;
/*
 * 삼항연산자 : 조건식 ? 값1 : 값2
 * 조건식이 true일경우 값1, false일경우 값2
 */

import java.util.Scanner;

public class OpTernaryTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int score = 0;
		// 점수입력
		System.out.print("점수를 입력해주세요. : ");
		score = input.nextInt();
				
		// score가 60점 이상이면 "합격", 이하면 "불합격", 해당 결과를 result변수에 대입함
		String result = (score >= 60) ? "합격" : "불합격";
		System.out.println("결과 : " + result);
		
	}
}
