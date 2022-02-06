package com.java.novelpost.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.comment.dto.CommentDto;
import com.java.novelpost.dto.NovelPostDto;
import com.java.novelpost.service.NovelPostService;

@Controller
public class NovelPostController {
	@Autowired
	private NovelPostService novelPostService;

	@RequestMapping(value = "/novelpost/register.do", method = RequestMethod.GET)
	public ModelAndView novelPostRegister(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("novelpost/register.tiles");
	}

	@RequestMapping(value = "/novelpost/registerOk.do", method = RequestMethod.POST)
	public ModelAndView novelPostRegisterOk(HttpServletRequest request, HttpServletResponse response,
			NovelPostDto novelPostDto) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("novelPostDto", novelPostDto);
		mav.addObject("request", request);

		novelPostService.novelPostRegisterOk(mav);

		return mav;
	}

	@RequestMapping(value = "/novelpost/read.do", method = RequestMethod.GET)
	public ModelAndView novelPostRead(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);

		novelPostService.novelPostRead(mav);

		return mav;
	}

	@RequestMapping(value = "/novelpost/delete.do", method = RequestMethod.GET)
	public ModelAndView novelPostDelete(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		novelPostService.novelPostDelete(mav);

		return mav;
	}

	@RequestMapping(value = "/novelpost/update.do", method = RequestMethod.GET)
	public ModelAndView novelPostUpdate(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		novelPostService.novelPostUpdate(mav);

		return mav;
	}

	@RequestMapping(value = "/novelpost/updateOk.do", method = RequestMethod.POST)
	public ModelAndView novelPostUpdateOk(HttpServletRequest request, HttpServletResponse response,
			NovelPostDto novelPostDto) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		mav.addObject("novelPostDto", novelPostDto);
		novelPostService.novelPostUpdateOk(mav);

		return mav;
	}
	
	@RequestMapping(value = "/novelpost/commentOk.do", method = RequestMethod.POST)
	public ModelAndView novelPostCommentOk(HttpServletRequest request, HttpServletResponse response,
			CommentDto commentDto) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		mav.addObject("commentDto", commentDto);
		novelPostService.novelPostCommentOk(mav);

		return mav;
	}
	
	@RequestMapping(value = "/novelpost/commentdelete.do", method = RequestMethod.GET)
	public ModelAndView novelPostCommentDelete(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		
		novelPostService.novelPostCommentDelete(mav);

		return mav;
	}

}
