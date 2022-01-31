package com.java.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.java.member.dto.MemberDto;
import com.java.member.service.MemberService;

@Controller
public class MemberController {
  @Autowired
  private MemberService memberService;

  @RequestMapping(value = "/member/login.do", method = RequestMethod.GET)
  public ModelAndView memberLogin(HttpServletRequest request, HttpServletResponse response) {
    return new ModelAndView("member/login");
  }

  @RequestMapping(value = "/member/loginOk.do", method = RequestMethod.POST)
  public ModelAndView memberLoginOk(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("request", request);

    memberService.memberLoginOk(mav);
    return mav;
  }

  @RequestMapping(value = "/member/logout.do", method = RequestMethod.GET)
  public ModelAndView memberLogout(HttpServletRequest request, HttpServletResponse response) {
    return new ModelAndView("member/logout");
  }

  @RequestMapping(value = "/member/register.do", method = RequestMethod.GET)
  public ModelAndView memberRegister(HttpServletRequest request, HttpServletResponse response) {
    return new ModelAndView("member/register");
  }

  @RequestMapping(value = "/member/registerOk.do", method = RequestMethod.POST)
  public ModelAndView memberRegisterOk(HttpServletRequest request, HttpServletResponse response, MemberDto memberDto) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("memberDto", memberDto);

    memberService.memberRegisterOk(mav);
    return mav;

  }


  @RequestMapping(value = "/member/kakaologin.do", method = RequestMethod.POST)
  public ModelAndView memberKakao(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("request", request);

    memberService.kakaologin(mav);
    return mav;
  }

  @RequestMapping(value = "/member/naverlogin.do", method = RequestMethod.GET)
  public ModelAndView memberNaver(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("request", request);
    
    memberService.naverlogin(mav);
    return mav;
  }
  
  
  
  
  
  
  
  // --------프로필-----------
  
  @RequestMapping(value = "/member/profile.do", method = RequestMethod.GET)
  public ModelAndView profileNovel(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("request", request);
    
    memberService.profileNovel(mav);
    return mav;
  }

  
  @RequestMapping(value = "/member/profileFollower.do", method = RequestMethod.GET)
  public ModelAndView profileFollower(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("request", request);
    
    memberService.profileFollower(mav);
    return mav;
  }
  
  @RequestMapping(value = "/member/profileFollowing.do", method = RequestMethod.GET)
  public ModelAndView profileFollowing(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("request", request);
    
    memberService.profileFollowing(mav);
    return mav;
  }
  
  @RequestMapping(value = "/member/follow.do", method = RequestMethod.POST)
  public ModelAndView profileFollow(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("request", request);
    
    memberService.profileFollow(mav);
    return mav;
  }
  
  @RequestMapping(value = "/member/followDelete.do", method = RequestMethod.POST)
  public ModelAndView profileFollowDelete(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("request", request);
    
    memberService.profileFollowDelete(mav);
    return mav;
  }
  
  @RequestMapping(value = "/member/follower_followDelete.do", method = RequestMethod.POST)
  public ModelAndView profileFollower_followDelete(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("request", request);
    
    memberService.follower_followDelete(mav);
    return mav;
  }
  
  @RequestMapping(value = "/member/following_followDelete.do", method = RequestMethod.POST)
  public ModelAndView profileFollowing_followDelete(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("request", request);
    
    memberService.following_followDelete(mav);
    return mav;
  }
  
  @RequestMapping(value = "/member/profileEdit.do", method = RequestMethod.GET)
  public ModelAndView profileEdit(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("request", request);
    
    memberService.profileEdit(mav);
    return mav;
  }
  
  @RequestMapping(value = "/member/nicknameCheck.do", method = RequestMethod.POST)
  public ModelAndView nicknameCheck(HttpServletRequest request, HttpServletResponse response) throws Throwable {
    ModelAndView mav = new ModelAndView();
    mav.addObject("request", request);
    mav.addObject("response", response);
    
    memberService.nicknameCheck(mav);
    return mav;
  }  
  
  @RequestMapping(value = "/member/profileEditOk.do", method = RequestMethod.POST)
  public ModelAndView profileEditOk(HttpServletRequest request, HttpServletResponse response, MemberDto memberDto) throws Throwable{
    ModelAndView mav = new ModelAndView();
    mav.addObject("request", request);
    mav.addObject("memberDto", memberDto);
    
    memberService.profileEditOk(mav);
    return mav;
  }  
}


