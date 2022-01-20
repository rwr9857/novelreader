package com.java.manager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class managerController {
	
	@RequestMapping(value = "/manager/menu.do", method = RequestMethod.GET)
	  public ModelAndView managerMenu(HttpServletRequest request, HttpServletResponse response) {
	    return new ModelAndView("manager/menu");
	  }
	
	@RequestMapping(value = "/manager/memberView.do", method = RequestMethod.GET)
	  public ModelAndView managerMemberView(HttpServletRequest request, HttpServletResponse response) {
	    return new ModelAndView("manager/memberView");
	  }
	
	@RequestMapping(value = "/manager/memberModify.do", method = RequestMethod.GET)
	  public ModelAndView managerMemberModify(HttpServletRequest request, HttpServletResponse response) {
	    return new ModelAndView("manager/memberModify");
	  }
	
	@RequestMapping(value = "/manager/memberDelete.do", method = RequestMethod.GET)
	  public ModelAndView managerMemberDelete(HttpServletRequest request, HttpServletResponse response) {
	    return new ModelAndView("manager/memberDelete");
	  }
	
	@RequestMapping(value = "/manager/reportPost.do", method = RequestMethod.GET)
	  public ModelAndView managerReportPost(HttpServletRequest request, HttpServletResponse response) {
	    return new ModelAndView("manager/reportPost");
	  }
	
	@RequestMapping(value = "/manager/reportComment.do", method = RequestMethod.GET)
	  public ModelAndView managerReportComment(HttpServletRequest request, HttpServletResponse response) {
	    return new ModelAndView("manager/reportComment");
	  }
}
