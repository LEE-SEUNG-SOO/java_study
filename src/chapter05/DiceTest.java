package chapter05;
/*
 * Dice 예제
 */
public class DiceTest {

	public static void main(String[] args) {
		int num = 0;
		boolean flag = true;
		int number = 0;
		
		while(flag) {
			System.out.println("Dice roll!!!");
			num = (int)Math.floor(Math.random()*(6)+1);
			System.out.println("Dice num : " + num);
			number++;
			if(num == 6) {
				System.out.println("총 주사위 굴린 횟수는 : " + number);
				flag = false;
			}
		}
	}

}
