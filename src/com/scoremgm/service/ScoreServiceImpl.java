package com.scoremgm.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.scoremgm.app.ScoreMgmSystem;
import com.scoremgm.model.Member;
import com.scoremgm.repository.ScoreRepository;
import com.scoremgm.repository.ScoreRepositoryImpl;

public class ScoreServiceImpl implements ScoreService{
	Scanner scan;
	ScoreRepository repository = new ScoreRepositoryImpl();
	ScoreMgmSystem sms;
	
	
	public ScoreServiceImpl() {
		
	}

	public ScoreServiceImpl(ScoreMgmSystem sms) {
		this.sms = sms;
		this.scan = sms.scan;
	}
	
	/**
	 * 학생정보 저장소(storage)의 갯수 가져오기
	 */
	@Override
	public int getCount() {
		return repository.getCount();
	}
	
	@Override
	public void register() {
		// 멤버 생성
		List memberInfo = createMemberInfo();
//		memberInfo.forEach(System.out::println);
		
		// Member 생성
		Member member = new Member();
		// Member 설정
		setMemberInfo(member,memberInfo);
		
		// 저장소에 저장을 위한 Repository 호출
		if(repository.insert(member)) {
			System.out.println("=> 등록 성공");
		} else {
			System.out.println("=> 등록 실패");
		}
		
		// 메뉴 호출
		sms.showMenu();
		sms.selectMenu();
	};
	
	@Override
	public void list() {
		if(getCount() != 0) {
			List<Member> list = repository.findAll();
			System.out.println("========================================================");
			System.out.println("학번\t\t이름\t전공\t국어\t영어\t수학");
			System.out.println("========================================================");
			
			list.forEach((member) -> {
				System.out.print(member.getNo() + "\t");
				System.out.print(member.getName() + "\t");
				System.out.print(member.getDepartment() + "\t");
				System.out.print(member.getKor() + "\t");
				System.out.print(member.getEng() + "\t");
				System.out.println(member.getMath());
			});
			System.out.println("========================================================");
		} else {
			System.out.println("=> 등록된 학생이 없습니다.");
		}
		sms.showMenu();
		sms.selectMenu();
	};
	
	/**
	 * 학생 정보 검색 : 학번 기준
	 */
	@Override
	public void search() {
		// 학생 정보가 존재할경우
		if(getCount() != 0) {
			System.out.print("학번(뒤4자리) : ");
			String no = scan.next();
			
			// 학번으로 학생 정보 검색
			Member member = repository.findMember(no);
			
			// 학번이 일치하는 정보가 존재할 경우
			if(member != null) {
				System.out.println("========================================================");
				System.out.println("학번\t\t이름\t전공\t국어\t영어\t수학");
				System.out.println("========================================================");
				System.out.print(member.getNo() + "\t");
				System.out.print(member.getName() + "\t");
				System.out.print(member.getDepartment() + "\t");
				System.out.print(member.getKor() + "\t");
				System.out.print(member.getEng() + "\t");
				System.out.println(member.getMath());
				System.out.println("========================================================");
			} else {
				System.out.println("=> 입력한 학번의 학생이 존재하지 않습니다.");
			}
		} else {
			System.out.println("=> 등록된 학생이 없습니다.");
		}
		
		sms.showMenu();
		sms.selectMenu();
	};
	
	/**
	 * 학생 정보 수정 : 학번 기준
	 */
	@Override
	public void update() {
		// 학생 정보가 존재할경우
		if(getCount() != 0) {
			System.out.print("학번(뒤4자리) : ");
			String no = scan.next();
			
			// 학번으로 학생 정보 검색
			Member member = repository.findMember(no);
			
			// 학번이 일치하는 정보가 존재할 경우
			if(member != null) {
				// 학생 정보 임시 저장 객체 생성 - Update
				List memberInfo = createMemberInfo(member);
				// index 3 : 국어점수
				member.setKor((int)memberInfo.get(0));
				// index 4 : 영어점수
				member.setEng((int)memberInfo.get(1));
				// index 5 : 수학점수
				member.setMath((int)memberInfo.get(2));
				
				// storage에 member 업데이트
				if(repository.update(member)) {
					System.out.println("=> 수정 성공");
				} else {
					System.out.println("=> 수정 실패");
				}
				
				System.out.println("========================================================");
				System.out.println("학번\t\t이름\t전공\t국어\t영어\t수학");
				System.out.println("========================================================");
				System.out.print(member.getNo() + "\t");
				System.out.print(member.getName() + "\t");
				System.out.print(member.getDepartment() + "\t");
				System.out.print(member.getKor() + "\t");
				System.out.print(member.getEng() + "\t");
				System.out.println(member.getMath());
				System.out.println("========================================================");
			} else {
				System.out.println("=> 입력한 학번의 학생이 존재하지 않습니다.");
			}
		} else {
			System.out.println("=> 등록된 학생이 없습니다.");
		}
		
		sms.showMenu();
		sms.selectMenu();
	};
	
	/**
	 * 학생 정보 삭제
	 */
	@Override
	public void delete() {
		// 학생 정보가 존재할경우
		if(getCount() != 0) {
			System.out.print("학번(뒤4자리) : ");
			String no = scan.next();
			
			// 학번으로 학생 정보 검색
			Member member = repository.findMember(no);
			
			// 학번이 일치하는 정보가 존재할 경우
			if(member != null) {
				// 삭제 여부 확인
				System.out.print("정말로 삭제 하시겠습니까?(y:삭제, 취소:y이외)");
				if(scan.next().equals("y")) {
					// storage에서 member 삭제
					if(repository.remove(member.getNo())) {
						System.out.println("=> 삭제 성공");
					} else {
						System.out.println("=> 삭제 실패");
					}
				} else {
					System.out.println("=> 삭제 처리를 취소합니다.");
				}
			} else {
				System.out.println("=> 입력한 학번의 학생이 존재하지 않습니다.");
			}
		} else {
			System.out.println("=> 등록된 학생이 없습니다.");
		}
		
		sms.showMenu();
		sms.selectMenu();
	};
	
	@Override
	public void exit() {
		System.out.println("== 프로그램 종료 ==");
		System.exit(0);
	};
	
	/**
	 * 학생 정보 임시 저장 객체 생성 - Update
	 * @return List
	 */
	public List createMemberInfo() {
		String[] labels = {"학생명","전공과목","국어","영어","수학"};
		
		// 학번 생성
		Random random = new Random();
		Calendar calendar = Calendar.getInstance();
		String year = String.valueOf(calendar.getWeekYear());
		String randomNo = String.valueOf(random.nextInt(1000,9999));
		String no = year + "-" + randomNo;
		
		List memberInfo = new ArrayList();
		
		// 학생 정보 저장
		for(int i = 0; i < labels.length; i++) {
			System.out.print(labels[i] + " : ");
			// 국어, 영어, 수학
			if(i >= 2) {
				memberInfo.add(scan.nextInt());
			} 
			// 학생명, 전공과목
			else {
				memberInfo.add(scan.next());
			}			
		}
		
		memberInfo.add(0,no);
		
		return memberInfo;
	}
	
	/**
	 * 학생 정보 임시 저장 객체 생성 - Update
	 * @param no 학번
	 * @return List 학생정보
	 */
	public List createMemberInfo(Member member) {
		String[] labels = {"국어","영어","수학"};
		
		// 학번 생성		
		List memberInfo = new ArrayList();
		System.out.println("학번 : " + member.getNo() + ", " +"학생명 : " + member.getName());
		
		// 학생 정보 저장
		for(int i = 0; i < labels.length; i++) {
			System.out.print(labels[i] + " : ");
			// 국어, 영어, 수학
			memberInfo.add(scan.nextInt());
		}
		
		return memberInfo;
	}
	
	/**
	 * member 설정
	 */
	public void setMemberInfo(Member member, List memberInfo) {
		member.setNo((String)memberInfo.get(0));
		member.setName((String)memberInfo.get(1));
		member.setDepartment((String)memberInfo.get(2));
		member.setKor((int)memberInfo.get(3));
		member.setEng((int)memberInfo.get(4));
		member.setMath((int)memberInfo.get(5));
	}
}
