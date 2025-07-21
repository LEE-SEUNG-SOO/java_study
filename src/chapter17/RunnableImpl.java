package chapter17;

public class RunnableImpl implements Runnable{
	
	public RunnableImpl() {
		
	}

	@Override
	public void run() {
		// 1~10까지 출력
		for(int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(1000); // 1초 sleep
				System.out.println("Runnable : " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
