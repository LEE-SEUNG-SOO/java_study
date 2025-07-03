package chapter07;
/*
 * ScoreMgmSystem 실행
 */
public class ScoreMgmSystemTest {

	public static void main(String[] args) {
		ScoreMgmSystem tjsms = new ScoreMgmSystem();
		
		tjsms.insert();
		tjsms.show();
		
		System.out.println("-- main 종료 --");
	}

}
