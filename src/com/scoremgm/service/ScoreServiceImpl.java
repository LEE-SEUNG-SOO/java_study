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
		List<Member> list = repository.findAll();
		System.out.println("========================================================");
		System.out.println("학번\t\t이름\t전공\t국어\t영어\t수학");
		System.out.println("========================================================");
		
		if(getCount() != 0) {
			list.forEach((member) -> {
				System.out.print(member.getNo() + "\t");
				System.out.print(member.getName() + "\t");
				System.out.print(member.getDepartment() + "\t");
				System.out.print(member.getKor() + "\t");
				System.out.print(member.getEng() + "\t");
				System.out.println(member.getMath());
			});
		} else {
			System.out.println("등록된 학생이 없습니다.");
			sms.showMenu();
			sms.selectMenu();
		}
	};
	
	@Override
	public void search() {
		
	};
	
	@Override
	public void update() {
		
	};
	
	@Override
	public void delete() {
		
	};
	
	@Override
	public void exit() {
		System.out.println("== 프로그램 종료 ==");
		System.exit(0);
	};
	
	/**
	 * 학생 정보 임시 저장 객체 생성
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
