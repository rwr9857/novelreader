package com.java.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.notice.dto.NoticeDto;
import com.java.notice.dto.QuestionDto;
import com.java.notice.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	NoticeService noticeService;

	@RequestMapping(value = "/notice/notice.do", method = RequestMethod.GET)
	public ModelAndView notice(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("notice/notice.tiles");
	}

	@RequestMapping(value = "/notice/noticeWrite.do", method = RequestMethod.GET)
	public ModelAndView noticeWrite(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("notice/noticeWrite.tiles");
	}

	@RequestMapping(value = "/notice/noticeWriteOk.do", method = RequestMethod.POST)
	public ModelAndView noticeWriteOk(HttpServletRequest request, HttpServletResponse response, NoticeDto noticeDto) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("noticeDto", noticeDto);

		noticeService.noticeWriteOk(mav);
		return mav;
	}

	@RequestMapping(value = "/notice/faq.do", method = RequestMethod.GET)
	public ModelAndView faq(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("notice/faq.tiles");
	}

	@RequestMapping(value = "/notice/question.do", method = RequestMethod.GET)
	public ModelAndView question(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);

		noticeService.question(mav);

		return mav;
	}


	@RequestMapping(value = "/notice/questionWrite.do", method = RequestMethod.GET)
	public ModelAndView questionWrite(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		noticeService.questionWrite(mav);

		return mav;
	}
	

	@RequestMapping(value = "/notice/questionWriteOk.do", method = RequestMethod.POST)
	public ModelAndView questionWriteOk(HttpServletRequest request, HttpServletResponse response,
			QuestionDto questionDto) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("questionDto", questionDto);

		noticeService.questionWriteOk(mav);
		return mav;
	}

	@RequestMapping(value = "/notice/questionView.do", method = RequestMethod.GET)
	public ModelAndView questionView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);

		noticeService.questionView(mav);
		return mav;
	}

}
