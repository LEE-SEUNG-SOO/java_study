package com.scoremgm.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.scoremgm.model.Member;

public class ScoreRepositoryImpl implements ScoreRepository {
	List<Member> storage = new ArrayList<Member>();
	
	/**
	 * 학생 정보 입력
	 */
	@Override
	public boolean insert(Member member) {
		return storage.add(member);
	}
	
	/**
	 * 학생 정보 수정
	 */
	@Override
	public boolean update(Member member) {
		boolean result = false;
		int index;
		
		for(index = 0; index < storage.size(); index++) {
			Member m = storage.get(index);
			
			if(member.getNo().equals(m.getNo())) {
				result = true;
				storage.set(index, member);
				index = storage.size();
			}
		}
		
		return result;
	}
	
	/**
	 * 학생 정보 삭제
	 */
	public boolean remove(String no) {
		boolean result = false;
		
		Iterator<Member> ie = storage.iterator();
		
		while(ie.hasNext()) {
			Member mebmer = ie.next();
			if(mebmer.getNo().equals(no)) {
				ie.remove();
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * 학생 총 수 출력
	 */
	@Override
	public int getCount() {
		return storage.size();
	}
	
	/**
	 * 모든 학생 정보 출력 
	 */
	@Override
	public List<Member> findAll(){
		return storage;
	}
	
	/**
	 * 학번 기준 학생 정보 검색 
	 */
	@Override
	public Member findMember(String no) {
		no = "2025-" + no;
		Member member = null;
		
		if(no != null) {
			for(Member m : storage) {
				if(m.getNo().equals(no)) {
					member = m;
				}
			}
		}
		
		return member;
	}
}
