package com.scoremgm.repository;

import java.util.List;

import com.scoremgm.model.Member;

public interface ScoreRepository {
	public boolean insert(Member member);
	public int getCount();
	public List<Member> findAll();
}
