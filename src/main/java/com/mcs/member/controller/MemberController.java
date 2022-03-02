package com.mcs.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mcs.member.service.MemberService;
import com.mcs.member.vo.MemberVO;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class MemberController {
	
	private MemberVO memberVO;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/log")
	public ModelAndView main() throws Exception{
		ModelAndView mv = new ModelAndView("/member/loginForm");
		return mv;
	}
	
	@RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") MemberVO member,
				              RedirectAttributes rAttr,
		                       HttpServletRequest request, HttpServletResponse response) throws Exception {
	ModelAndView mav = new ModelAndView();
	memberVO = memberService.login(memberVO);
	if(memberVO != null) {
		    HttpSession session = request.getSession();
		    session.setAttribute("member", memberVO);
		    session.setAttribute("isLogOn", true);
//		    mav.setViewName("redirect:/member/listMembers.do");
		    String action = (String)session.getAttribute("action");
		    session.removeAttribute("action");
		    if(action != null) {
		    	mav.setViewName("redirect:" + action);
		    }else {
		    	mav.setViewName("redirect:/member/listMembers.do");
		    }
	}else {
		    rAttr.addAttribute("result","loginFailed");
		    mav.setViewName("redirect:/member/loginForm.do");
	}
	return mav;
	}
	

	
	@RequestMapping("/app")    // 이 주소로 접속하면 이 메소드를 호출한다.(매핑한다.)
	public ModelAndView openBoardList() throws Exception{
		ModelAndView mv = new ModelAndView("/apple/boardList");
		
		List<MemberVO> list = memberService.selectBoardList();
		mv.addObject("list",list);
		System.out.println(list);
		return mv;
	}
}
