package com.java.novelpost.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.novelpost.dto.NovelPostDto;
import com.java.novelpost.service.NovelPostService;

@Controller
public class NovelPostController {
	@Autowired
	private NovelPostService novelPostService;

	@RequestMapping(value = "/novelpost/register.do", method = RequestMethod.GET)
	public ModelAndView novelHomeRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		novelPostService.novelhomeRegister(mav);

		return mav;
	}

	@RequestMapping(value = "/novelpost/registerOk.do", method = RequestMethod.POST)
	public ModelAndView novelHomeRegisterOk(HttpServletRequest request, HttpServletResponse response,
			NovelPostDto novelPostDto) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("novelPostDto", novelPostDto);
		novelPostService.novelhomeRegisterOk(mav);

		return mav;
	}

}
