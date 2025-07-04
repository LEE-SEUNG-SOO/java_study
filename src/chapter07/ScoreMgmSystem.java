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
	Student[] sList = new Student[10];
	int studentCount = 0;
	final int MAX_SIZE = sList.length;
	
	// Constructor
	public ScoreMgmSystem() {
		
	}
	// Method
	/*
	 *  메뉴 선택
	 */
	public void showMenu() {
		System.out.println("---------------------------------------------------");
		System.out.println("더 조은 고등학교 성적관리 프로그램");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 리스트 출력");
		System.out.println("3. 학생 성적 검색");
		System.out.println("4. 학생 성적 수정");
		System.out.println("5. 학생 데이터 삭제");
		System.out.println("9. 프로그램 종료");
		System.out.println("---------------------------------------------------");
		
		System.out.print("메뉴를 선택해주세요 : ");
		int menu = scan.nextInt();
		menuCheck(menu);
	}
	
	/*
	 * 선택한 메뉴에 따라 기능별 메소드 호출
	 */
	public void menuCheck(int menu) {
		switch(menu) {
		// 1. 학생 등록
		case 1: 
			insert();
			showMenu();
			break;
		// 2. 학생 리스트 출력
		case 2:
			showList();
			showMenu();
			break;
		// 3. 학생 성적 검색
		case 3:
			search();
			showMenu();
			break;
		// 4. 학생 성적 수정
		case 4:
			update();
			showMenu();
			break;
		// 5. 학생 데이터 삭제
		case 5:
			remove();
			showMenu();
			break;
		// 9. 프로그램 종료
		case 9:
			System.out.println("-- 성적관리 시스템 종료 --");
			System.exit(0);
			break;
		// 상기외 다른 값 입력
		default:
			System.out.println(" -- 메뉴 준비중입니다. --");
			showMenu();
		}
	}
	
	// 1. 학생 등록
	public void insert() {
		// 등록한 학생 수가 최대치일 경우.
		if(studentCount == MAX_SIZE) {
			System.out.println("학생이 가득 찼습니다.");
		} else {
			System.out.println("-- 학생 정보를 등록하세요. --");	
			sList[studentCount] = new Student();
			
			System.out.print("학생 명 : ");
			sList[studentCount].name = scan.next();
			
			System.out.print("국어 점수 : ");
			sList[studentCount].kor = scan.nextInt();
			
			System.out.print("영어 점수 : ");
			sList[studentCount].eng = scan.nextInt();
			
			System.out.print("수학 점수 : ");
			sList[studentCount].math = scan.nextInt();
			
			studentCount++;
			System.out.println("-- 등록완료 --");
	
			// 반복 확인 메소드
			if(loopCheck("[등록]"))	{
				insert();
			}
		}
	}
	
	// 2. 학생 리스트 출력
	public void showList() {
		// 등록한 학생이 있을경우.
		if(studentCount > 0) {
			// 학생 정보 출력
			System.out.println("-------------------------------------------");
			System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
			System.out.println("-------------------------------------------");
			for(int i = 0; i < studentCount; i++) {
				System.out.print(sList[i].name + "\t");
				System.out.print(sList[i].kor + "\t");
				System.out.print(sList[i].eng + "\t");
				System.out.print(sList[i].math + "\t");
				System.out.print(sList[i].getTot() + "\t");
				System.out.print(sList[i].getAvg() + "\n");		
			}
			System.out.println("-------------------------------------------");
		} else {
			System.out.println("등록된 데이터가 없습니다. 등록을 진행한 후 실행해주세요.");
		}
	}
	
	// 4. 학생 성적 수정
	public void update() {
		// 등록한 학생이 있을경우.
		if(studentCount > 0) {
			// searchIndex 호출(학생명을 검색하여 해당 학생의 주소를 반환하는 메소드.)
			int searchIdx = searchIndex("[수정]");
			
			// 검색한 학생이 있을 경우
			if(searchIdx >= 0) {
				// 검색한 학생이 있을 경우
				System.out.print("국어 점수 : ");
				sList[searchIdx].kor  = scan.nextInt();
				
				System.out.print("영어 점수 : ");
				sList[searchIdx].eng  = scan.nextInt();
				
				System.out.print("수학 점수 : ");
				sList[searchIdx].math  = scan.nextInt();
				
				sList[searchIdx].tot = (sList[searchIdx].kor + sList[searchIdx].eng + sList[searchIdx].math);
				sList[searchIdx].avg = (sList[searchIdx].tot / 3);
				
				System.out.println(" -- 수정 완료 -- ");
				// 학생 정보 출력
				showListForm(sList[searchIdx]);
			} else {
				System.out.println("검색한 학생이 존재하지 않습니다.");
			}
			
			// 반복 확인 메소드
			if(loopCheck("[수정]"))	{
				update();
			}
		} else {
			System.out.println("등록된 데이터가 없습니다. 등록을 진행한 후 실행해주세요.");
		}
	}
	
	
	// 5. 학생 데이터 삭제
	public void remove() {
		// 등록한 학생이 있을경우.
		if(studentCount > 0) {
			// 조회할 학생명 입력
			int searchIdx = searchIndex("[삭제]");
			
			// 검색 대상이 존재할 경우
			if(searchIdx >= 0) {
				// 대상의 인덱스의 값을 인덱스 + 1값의 데이터로 수정(등록된 마지막 배열 전까지 반복)
				for(int i = searchIdx; i < studentCount-1; i++) {
					sList[i] = sList[i+1];
				}
				// 등록 학생수 -1
				studentCount--;
				// 등록된 마지막 데이터 초기화
				sList[studentCount] = null;
				
				System.out.println("-- 삭제완료 --");
				
			} else {
				System.out.println("입력한 학생이 없습니다. 다시 입력해주세요.");
			}
			
			// 반복 확인 메소드
			if(loopCheck("[삭제]"))	{
				remove();
			}
		}
		 else {
			System.out.println("등록된 데이터가 없습니다. 등록을 진행한 후 실행해주세요.");
		}
	}
	
	// 3. 학생 성적 검색
	public void search() {
		// 등록한 학생이 있을경우.
		if(studentCount > 0) {
			// 조회할 학생명 입력
			int searchIdx = searchIndex("[검색]");
			
			// 검색한 학생이 있을 경우
			if(searchIdx >= 0) {
				// 학생 정보 출력
				showListForm(sList[searchIdx]);
				// 검색 결과 플래그 변경
			} else {
				System.out.println("검색한 학생이 존재하지 않습니다.");
			}
			
			// 반복 확인 메소드
			if(loopCheck("[검색]"))	{
				search();
			}
			
		} else {
			System.out.println("등록된 데이터가 없습니다. 등록을 진행한 후 실행해주세요.");
		}
	}
	
	/*
	 * 학생명을 검색하여 주소를 리턴하는 메소드
	 */
	public int searchIndex(String pname) {
		// 학생명 입력
		System.out.print(pname + "할 학생명을 입력해주세요. : ");
		String searchName = scan.next();
		int searchIdx = -1;
		
		// sList에서 입력한 학생명의 데이터 검색
		for(int i = 0; i < studentCount; i++) {
			Student student = sList[i];
			// 검색한 학생이 있을 경우
			if(searchName.equals(student.name)) {
				searchIdx = i;
				i = studentCount;
			}
		}
		return searchIdx;
	}
	
	/*
	 * 학생 정보를 출력하는 포멧 메소드
	 */
	public void showListForm(Student student) {
		System.out.println("-------------------------------------------");
		System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-------------------------------------------");
		System.out.print(student.name + "\t");
		System.out.print(student.kor + "\t");
		System.out.print(student.eng + "\t");
		System.out.print(student.math + "\t");
		System.out.print(student.getTot() + "\t");
		System.out.print(student.getAvg() + "\n");
		System.out.println("-------------------------------------------");
	}
	
	/*
	 * 각 기능의 반복 실행을 확인하는 메소드
	 */
	public boolean loopCheck(String pname) {
		boolean flag = true;
		
		System.out.print("계속 " + pname +" 하시겠습니까?(y/n) : ");
		// 반복 종료
		if(scan.next().equals("n")) {
			flag = false;
		}
		return flag;
	}
}
