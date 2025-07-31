package chapter20_JDBC.member;

import java.util.List;
import java.util.Scanner;

import commons.DefaultInterface;

public class MemberApp implements DefaultInterface{
	// Field
	Scanner scan = new Scanner(System.in);

	MemberDAO memberDAO;
	
	// Constructor
	public MemberApp() {
		memberDAO = new MemberDAO();
		showMenu();
		selectMenu();
	}
	
	// Method
	public void showMenu() {
		System.out.println("********************************");
		System.out.println("\t1. 등록");
		System.out.println("\t2. 조회");
		System.out.println("\t3. 수정");
		System.out.println("\t4. 삭제");
		System.out.println("\t0. 종료");
		System.out.println("********************************");
	}
	
	public void selectMenu() {
		System.out.print("메뉴 선택 : ");
		int menuno = scan.nextInt();
			
		switch(menuno) {
		case INSERT :
			insert();
			break;
		case SELECT :
			select();
			break;
		case UPDATE :
			update();
			break;
		case DELETE :
			delete();
			break;
		case EXIT :
			exit();
			break;
		default :
			System.out.println("잘못된 선택. 다시 입력");
			selectMenu();
		}
	}
	
	public void insert() {
		MemberVO member = new MemberVO();
		
		System.out.println("=> 이름과 이메일을 입력해주세요.");
		
		System.out.print("이름 입력 : ");
		member.setName(scan.next());
		
		System.out.print("이메일 입력 :");
		member.setEmail(scan.next());
		
		// insert
		int result = memberDAO.insert(member);
		
		if(result == 1) {
			System.out.println("=> 등록 성공");
		} else {
			System.out.println("=> 등록 실패");
		}
		
		selectMenu();
	}
	
	public void select() {
		List<MemberVO> list = memberDAO.listAll();
		
		if(list.size() != 0) {
			System.out.println("******************************************************************");
			System.out.println("아이디\t이름\t이메일\t\t\t생성일");
			System.out.println("******************************************************************");
			list.forEach( (member) -> {
				System.out.print(member.getMemberId() + "\t");
				System.out.print(member.getName() + "\t");
				System.out.print(member.getEmail() + "\t");
				System.out.print(member.getCreatedAt() + "\n");
			});
		} else {
			System.out.println("=> 등록된 데이터 없음");
		}
		
		selectMenu();
	}
	
	public void update() {
		System.out.println("[검색] 아이디 : ");
				
		// 데이터 여부 확인
		MemberVO member = memberDAO.search(scan.nextInt());
		
		if(member.getMemberId() != 0) {
			System.out.println("이름 : " + member.getName());
			System.out.println("이메일 : " + member.getEmail());
			
			// 업데이트 데이터 입력
			System.out.print("[수정] 이름 : ");
			member.setName(scan.next());
			
			System.out.print("[수정] 이메일 : ");
			member.setEmail(scan.next());
			
			// 업데이트
			int result = memberDAO.update(member);
			
			// 업데이트 결과
			if(result != 0) {
				System.out.println("=> 업데이트 성공");
			} else {
				System.out.println("=> 업데이트 실패");
			}
			
		} else {
			System.out.println("=> 등록된 데이터 없음");
		}

		showMenu();
		selectMenu();
	}

	public void delete() {
		System.out.println("[검색] 아이디 : ");
		
		// 데이터 여부 확인
		MemberVO member = memberDAO.search(scan.nextInt());
		
		if(member.getMemberId() != 0) {
			System.out.print("이름 : " + member.getName() + " 의 정보를 삭제하시겠습니까?(y/n) : ");
			
			if(scan.next().equals("y")) {
				// 삭제
				int result = memberDAO.delete(member.getMemberId());
				
				// 삭제 결과
				if(result != 0) {
					System.out.println("=> 삭제 성공");
				} else {
					System.out.println("=> 삭제 실패");
				}
			} else {
				System.out.println("삭제 진행이 취소되었습니다.");
			}
		} else {
			System.out.println("=> 등록된 데이터 없음");
		}
		
		showMenu();
		selectMenu();		
	}
	
	public void exit() {
		System.out.println("프로그램 종료");
		memberDAO.close();
		System.exit(EXIT);
	}
}
