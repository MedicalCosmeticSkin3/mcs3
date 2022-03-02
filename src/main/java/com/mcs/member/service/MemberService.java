package com.mcs.member.service;

import java.util.List;

import com.mcs.member.vo.MemberVO;

public interface MemberService {

//	public List<MemberVO> selectListMember() throws DataAccessException;

	public List<MemberVO> selectBoardList()  throws Exception ;

	public MemberVO login(MemberVO memberVO);

}
