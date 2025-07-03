package chapter07;
/*
 * 
	클래스명 : Student
	필드 : name:String, kor:int, eng:int, math:int, tot:int, avg:int
	생성자 : Student()
	메소드 : getTot(): 합계, getAvg(): 평균
 */
public class Student {
	// Field
	String name;
	int kor;
	int eng;
	int math;
	// 처음 생성될때 메모리영역(heap)에 설정되므로 초기값 0 + 0 + 0 으로 tot는 0
	int tot = kor + eng + math;
	// tot(0)을 3으로 나누므로 0
	int avg = tot/3;
	
	// Constructor
	public Student() {
		
	}
	// Method
	public int getTot() {
		return (kor + eng + math);
	}
	public int getAvg() {
		return ((kor + eng + math)/3);
	}
}
