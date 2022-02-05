package com.java.novelhome.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.novelhome.dto.NovelHomeDto;
import com.java.novelhome.service.NovelHomeService;

@Controller
public class NovelHomeController {
	@Autowired
	private NovelHomeService novelHomeService;

	@RequestMapping(value = "/novelhome/upload.do", method = RequestMethod.GET)
	public ModelAndView novelHomeUpload(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("novelhome/upload.tiles");
	}

	@RequestMapping(value = "/novelhome/uploadOk.do", method = RequestMethod.POST)
	public ModelAndView novelHomeUploadOk(HttpServletRequest request, HttpServletResponse response,
			NovelHomeDto novelHomeDto) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		mav.addObject("novelHomeDto", novelHomeDto);

		novelHomeService.novelhomeUploadOk(mav);

		return mav;
	}

	@RequestMapping(value = "/novelhome/list.do", method = RequestMethod.GET)
	public ModelAndView novelHomeList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);

		novelHomeService.novelHomeList(mav);

		return mav;
	}
	
	@RequestMapping(value = "/novelhome/search.do", method = RequestMethod.GET)
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		
		novelHomeService.search(mav);

		return mav;
	}
}
