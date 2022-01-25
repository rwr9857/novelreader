package com.java.member.service;

import org.springframework.web.servlet.ModelAndView;

public interface MemberService {
	public void memberRegisterOk(ModelAndView mav);

	public void memberLoginOk(ModelAndView mav);

	public void kakaologin(ModelAndView mav);

	public void naverlogin(ModelAndView mav);

	public void profileNovel(ModelAndView mav);

	public void memberSelect(ModelAndView mav);
	
	public void profileFollower(ModelAndView mav);
	
	public void profileFollowing(ModelAndView mav);
}
