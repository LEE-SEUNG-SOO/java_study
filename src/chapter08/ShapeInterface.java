package chapter08;
/**
 *  추상 메소드들을 모아 놓은 그룹
 *  Method 에어리어에 생성
 */
public interface ShapeInterface {
	public abstract void draw();
	// 추상 메소드들만 모아두는 곳이기때문에 abstract 키워드를 쓰지 않아도 된다.
	public double getArea(); 
	// 상수를 정의해서 사용할 수 있다.(변수 X)
	public static final String TEST = "test";
}
