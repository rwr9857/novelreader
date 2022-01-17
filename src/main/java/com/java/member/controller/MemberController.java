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

  @RequestMapping(value = "/member/register.do", method = RequestMethod.GET)
  public ModelAndView memberRegister(HttpServletRequest request, HttpServletResponse response) {
    return new ModelAndView("member/register");
  }
  
  @RequestMapping(value = "/member/registerOk.do", method = RequestMethod.POST)
  public ModelAndView memberRegisterOk(HttpServletRequest request, HttpServletResponse response,MemberDto memberDto) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("memberDto",memberDto);
    
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

}


