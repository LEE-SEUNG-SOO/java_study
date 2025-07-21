package chapter17;

public class ThreadExtend extends Thread{
	
	public ThreadExtend() {
		super("스레드1");
	}
	
	@Override
	public void run() {
		// 1~10까지 출력
		for(int i = 1; i <= 10; i++) {	
			try {
				sleep(1000); // 1초 sleep
				System.out.println(this.getName() + " : " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}
}
