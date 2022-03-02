package com.mcs.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mcs.member.dao.MemberDAO;
import com.mcs.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
//	@Override
//	public List<MemberVO> selectListMember() throws DataAccessException{
//		return memberDAO.selectAllList();
//	}

	@Override
	public List<MemberVO> selectBoardList() throws Exception  {
		return memberDAO.selectBoardList();
	}

	@Override
	public MemberVO login(MemberVO memberVO) throws DataAccessException{
		return memberDAO.loginById(memberVO);
	}

//	@Override
//	public MemberVO login(MemberVO memberVO) throws Exception {
//		return memberDAO.logintest();
//	}

}
