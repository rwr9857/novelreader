package com.java.manager.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.manager.service.ManagerService;
import com.java.member.service.MemberService;

@Controller
public class managerController {
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ManagerService managerService;
	
	@RequestMapping(value = "/manager/menu.do", method = RequestMethod.GET)
	  public ModelAndView managerMenu(HttpServletRequest request, HttpServletResponse response) {	
	    return new ModelAndView("manager/menu.tiles1");
	  }
	
	@RequestMapping(value = "/manager/memberView.do", method = RequestMethod.GET)
	  public ModelAndView managerMemberView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
	    mav.addObject("request", request);
	    
	    memberService.memberSelect(mav);
	    return mav;
	  }
	
	@RequestMapping(value = "/manager/memberModify.do", method = RequestMethod.GET)
	  public ModelAndView managerMemberModify(HttpServletRequest request, HttpServletResponse response) {
	    return new ModelAndView("manager/memberModify.tiles1");
	  }
	
	@RequestMapping(value = "/manager/memberDelete.do", method = RequestMethod.GET)
	  public ModelAndView managerMemberDelete(HttpServletRequest request, HttpServletResponse response) {
	    return new ModelAndView("manager/memberDelete.tiles1");
	  }
	
	@RequestMapping(value = "/manager/reportPost.do", method = RequestMethod.GET)
	  public ModelAndView managerReportPost(HttpServletRequest request, HttpServletResponse response) {
	    return new ModelAndView("manager/reportPost.tiles1");
	  }
	
	@RequestMapping(value = "/manager/reportComment.do", method = RequestMethod.GET)
	  public ModelAndView managerReportComment(HttpServletRequest request, HttpServletResponse response) {
	    return new ModelAndView("manager/reportComment.tiles1");
	  }
	
	@RequestMapping(value = "/manager/categoryView.do", method = RequestMethod.GET)
	  public ModelAndView managerCategoryView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		managerService.categoryList(mav);
		return mav;

	  }
	
	@RequestMapping(value = "/manager/categoryWrite.do", method = RequestMethod.POST)
	  public String managerCategoryWrite(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
	    mav.addObject("request", request);
	    mav.addObject("response", response);
	    
		managerService.categoryWrite(mav);
	    return null;
	  }
}
