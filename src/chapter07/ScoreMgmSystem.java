package chapter07;

import java.util.Scanner;

/*
 * 	클래스명 : ScoreMgmSystem
	필드 : admin:String, sname:Student
	생성자 : ScoreMgmSystem()
	메소드 : insert(), update(), delete(), search()
 * 
 * 학생 3명의 점수 입력받기.
 * 한명 입력 받은후 계속 입력 여부 메세지로 출력후 입력
 * 
 */
public class ScoreMgmSystem {
	// Field
	Scanner scan = new Scanner(System.in);
	String admin;
	Student student;
	Student[] sstudent = new Student[10];
	int studentCount = 0;
	final int MAX_SIZE = 3;
	
	// Constructor
	public ScoreMgmSystem() {
		
	}
	// Method
	public void insert() {
		boolean insertFlag = true;
		while(insertFlag) {
			System.out.println("-- 등록 --");	
			student = new Student();
			sstudent[studentCount] = new Student();
			
			System.out.print("학생 명 : ");
			sstudent[studentCount].name = scan.next();
			
			System.out.print("국어 점수 : ");
			sstudent[studentCount].kor = scan.nextInt();
			
			System.out.print("영어 점수 : ");
			sstudent[studentCount].eng = scan.nextInt();
			
			System.out.print("수학 점수 : ");
			sstudent[studentCount].math = scan.nextInt();
			
			studentCount++;
			System.out.println("-- 등록완료 --");
			
			if(studentCount == MAX_SIZE) {
				System.out.println("학생이 가득 찼습니다.");
				insertFlag = false;
			} else {
				System.out.print("계속 입력하시겠습니까?(종료:n) : ");
				if(scan.next().equals("n")) {
					insertFlag = false;
				}
			}
		}
	}
	public void show() {
		System.out.println("------------------------------------");
		System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("------------------------------------");
		for(int i = 0; i < studentCount; i++) {
			System.out.print(sstudent[i].name + "\t");
			System.out.print(sstudent[i].kor + "\t");
			System.out.print(sstudent[i].eng + "\t");
			System.out.print(sstudent[i].math + "\t");
			System.out.print(sstudent[i].getTot() + "\t");
			System.out.print(sstudent[i].getAvg() + "\n");		
		}
//		System.out.print(student.name + "\t");
//		System.out.print(student.kor + "\t");
//		System.out.print(student.eng + "\t");
//		System.out.print(student.math + "\t");
////		System.out.print(student.tot + "\t");
////		System.out.print(student.avg + "\n");
//		System.out.print(student.getTot() + "\t");
//		System.out.print(student.getAvg() + "\n");		
////		student.tot();
////		student.avg();		
		System.out.println("------------------------------------");
	}
	public void update() {
		System.out.println("-- 수정 --");
	}
	public void remove() {
		System.out.println("-- 삭제 --");
	}
	public void search() {
		System.out.println("-- 검색 --");
	}
}
