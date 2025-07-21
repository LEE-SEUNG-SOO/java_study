package chapter17;

public class MainThreadTest {

	public static void main(String[] args) {
		ThreadExtend thread = new ThreadExtend();
		thread.start(); // 해당 스레드의 run()메소드 실행
		
		// 1~10까지 정수 출력
		for(int i = 1; i <= 10 ; i++) {
			System.out.println("메인 : " + i);
		}
		
		// Runnable의 스레드 실행 방법
		Thread t = new Thread(new RunnableImpl());
		t.start();
		
		System.out.println("-- 메인 메소드 종료 --");	

	}
}
