package com.java.novelhome.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.novelcategory.dto.NovelCategoryDto;
import com.java.novelhome.dto.NovelHomeDto;
import com.java.novelhome.service.NovelHomeService;

@Controller
public class NovelHomeController {
	@Autowired
	private NovelHomeService novelHomeService;

	@RequestMapping(value = "/novelhome/upload.do", method = RequestMethod.GET)
	public ModelAndView novelHomeUpload(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);

		novelHomeService.novelhomeUpload(mav);

		return mav;
	}

	@RequestMapping(value = "/novelhome/uploadOk.do", method = RequestMethod.POST)
	public ModelAndView novelHomeUploadOk(HttpServletRequest request, HttpServletResponse response,
			NovelHomeDto novelHomeDto, NovelCategoryDto novelCategoryDto) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		mav.addObject("novelHomeDto", novelHomeDto);
		mav.addObject("novelCategoryDto", novelCategoryDto);

		novelHomeService.novelhomeUploadOk(mav);

		return mav;
	}

	@RequestMapping(value = "/novelhome/list.do", method = RequestMethod.GET)
	public ModelAndView novelHomeList(HttpServletRequest request, HttpServletResponse response,
			NovelCategoryDto novelCategoryDto) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		mav.addObject("novelCategoryDto", novelCategoryDto);
		
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
	

	@RequestMapping(value = "/novelhome/category.do", method = RequestMethod.GET)
	public ModelAndView category(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		
		novelHomeService.category(mav);

		return mav;
	}

	@RequestMapping(value = "/novelhome/delete.do", method = RequestMethod.GET)
	public ModelAndView novelHomeDelete(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);

		novelHomeService.novelHomeDelete(mav);

		return mav;
	}
	
	@RequestMapping(value = "/novelhome/alldelete.do", method = RequestMethod.GET)
	public ModelAndView novelHomeAllDelete(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);

		novelHomeService.novelHomeAllDelete(mav);

		return mav;
	}
	

}
