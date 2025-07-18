package com.scoremgm.repository;

import java.util.List;

import com.scoremgm.model.Member;

public interface ScoreRepository {
	public boolean insert(Member member);
	public boolean update(Member member);
	public boolean remove(String no);
	public int getCount();
	public List<Member> findAll();
	public Member findMember(String no);
}
