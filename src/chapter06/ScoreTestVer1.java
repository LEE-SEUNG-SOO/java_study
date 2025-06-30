package chapter06;

import java.util.Scanner;

/*
 * 학생 한명의 국어, 영어, 수학 점수를 입력받아 출력하는 로직
 */
public class ScoreTestVer1 {

	public static void main(String[] args) {
		// 변수 설정
		Scanner scan = new Scanner(System.in);
		String name = null;
		int scoreList[] = new int[6];
		String subList[] = {"국어", "영어", "수학", "자바"};
		
		// 이름 입력
		System.out.print("이름을 입력해주세요. : ");
		name = scan.next();
		
		// 점수 입력
		for(int i = 0 ; i < scoreList.length; i++) {
			if(i < subList.length) {
				System.out.print(subList[i] + " 점수 입력 : ");
				// 각 점수 입력
				scoreList[i] = scan.nextInt();
				// 총점
				scoreList[scoreList.length - 2] += scoreList[i];
			} else {
				// 평균
				scoreList[scoreList.length - 1] = ((scoreList[subList.length])/subList.length);
				i = scoreList.length; // break대신 조건을 false를 만들기위해 i의 값 설정
//				break; 
			}
		}
		
		System.out.print("학생명\t");
		// 데이터 출력
		for (String subName : subList) {
			System.out.print(subName + "\t");
		}
		
		System.out.println("총점\t평균");
		
		// 이름 출력
		System.out.print(name + "\t");
		
		// 점수 출력
		for(int score : scoreList) {
			System.out.print(score + "\t");
		}
		
		scan.close();
	}

}
