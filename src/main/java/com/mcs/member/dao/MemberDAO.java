package com.mcs.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mcs.member.vo.MemberVO;

@Mapper
public interface MemberDAO {
	public List<MemberVO> selectBoardList() throws Exception;

	public MemberVO logintest() throws Exception;

	public MemberVO loginById(MemberVO memberVO);
	
}
