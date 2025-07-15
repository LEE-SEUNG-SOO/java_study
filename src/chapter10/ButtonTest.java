package chapter10;

// java.awt 패키지 전체 임포트
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ButtonTest {

	public static void main(String[] args) {
		Frame f = new Frame();
		Button btnClick = new Button("버튼1");
		Button btnClick2 = new Button("버튼2");
		Button btnClick3 = new Button("버튼3");
		Panel p = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		p.add(btnClick);
		p2.add(btnClick2);
		p3.add(btnClick3);
		// 레이아웃에 영역만들기?
		f.setLayout(new BorderLayout());
		// 프레임 타이틀설정
		f.setTitle("버튼 테스트");	
		// 프레임 초기 사이즈 설정
		f.setSize(300,400);
		
		// 프레임에 버튼추가, 보더레이아웃에 설정
		f.add(p,BorderLayout.NORTH);
		f.add(p2,BorderLayout.CENTER);
		f.add(p3,BorderLayout.SOUTH);
		
		// 화면에 표시하기
		f.setVisible(true);
		
		// 버튼의 이벤트 처리 방법1 : 내부 클래스를 생성하여 액션 이벤트 처리
//		ButtonTest.ButtonActionLister action = new ButtonTest.ButtonActionLister();
		btnClick.addActionListener(new ButtonTest.ButtonActionLister());

		// 버튼의 이벤트 처리 방법2 : 익명 클래스를 생성하여 액션 이벤트 처리
		btnClick2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼2클릭");
			}
		});
		
		// 버튼의 이벤트 처리 방법3 : 람다식 처리방식을 이용한 이벤트 처리 (class파일도 미생성)
//		btnClick3.addActionListener((ActionEvent e) -> {
//			System.out.println("버튼3클릭");
//		});

//		btnClick3.addActionListener(e -> {
//			System.out.println("버튼3클릭");
//		});
		
		btnClick3.addActionListener(e -> System.out.println("버튼3클릭"));
		
		// frame의 종료 이벤트
		f.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {}
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("--프로그램 종료--");
				System.exit(0);
			}
			@Override
			public void windowClosed(WindowEvent e) {}
			@Override
			public void windowIconified(WindowEvent e) {}
			@Override
			public void windowDeiconified(WindowEvent e) {}
			@Override
			public void windowActivated(WindowEvent e) {}
			@Override
			public void windowDeactivated(WindowEvent e) {}			
		});
	}
	
	// inner class
	/**
	 * 버튼의 이벤트 처리 클래스
	 */
	public static class ButtonActionLister implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("버튼1클릭");
		}
	}
	
}
