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

	public void profileFollow(ModelAndView mav);

	public void profileFollowDelete(ModelAndView mav);

	public void follower_followDelete(ModelAndView mav);

	public void following_followDelete(ModelAndView mav);

	public void profileEdit(ModelAndView mav);

	public void nicknameCheck(ModelAndView mav) throws Throwable;

	public void profileEditOk(ModelAndView mav) throws Throwable;

	public void accountEdit(ModelAndView mav);

	public void emailCheck(ModelAndView mav) throws Throwable;

	public void accountEditOk(ModelAndView mav);

	public void resign(ModelAndView mav);
}
