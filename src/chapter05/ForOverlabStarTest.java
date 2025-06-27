package chapter05;
/*
 * *출력하기
 * [시작]
 * *
 * **
 * ***
 * ****
 * *****
 * [종료]
 */
public class ForOverlabStarTest {

	public static void main(String[] args) {
		String star = "*";
		
		System.out.println("[시작]");
		
		// 반복출력 시작
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print(star);
			}
			System.out.println();
		}
		System.out.println("[종료]");
		
		System.out.println("[역출력시작]");
		
		// 반복출력 시작
		for(int i = 0; i < 5; i++) {
			for(int j = 5; j > i; j--) {
				System.out.print(star);
			}
			System.out.println();
		}
		System.out.println("[역출력종료]");
		
	}
}
