package com.java.novelhome.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.aop.LogAspect;
import com.java.novelcategorie.dto.NovelCategorieDto;
import com.java.novelhome.dto.NovelHomeDto;
import com.java.novelhome.service.NovelHomeService;

@Controller
public class NovelHomeController {
	@Autowired
	private NovelHomeService novelHomeService;

	@RequestMapping(value = "/novelhome/upload.do", method = RequestMethod.GET)
	public ModelAndView novelHomeUpload(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("novelhome/upload");
	}

	@RequestMapping(value = "/novelhome/uploadOk.do", method = RequestMethod.POST)
	public ModelAndView novelHomeUploadOk(HttpServletRequest request, HttpServletResponse response,
			NovelHomeDto novelHomeDto) throws IllegalAccessException, IOException {
		
		String C_CATEGORIE_ID = request.getParameter("C_CATEGORIE_ID");
		String N_NUM = request.getParameter("N_NUM");
		//int C_CATEGORIE_ID = Integer.parseInt(request.getParameter("C_CATEGORIE_ID"));
		//int N_NUM = Integer.parseInt(request.getParameter("N_NUM"));

		LogAspect.logger.info(LogAspect.LogMsg+C_CATEGORIE_ID+N_NUM);
		
		NovelCategorieDto novelCategorieDto1 = new NovelCategorieDto();
		novelCategorieDto1.setC_CATEGORIE_ID(Integer.parseInt(C_CATEGORIE_ID));
		NovelCategorieDto novelCategorieDto2 = new NovelCategorieDto();
		novelCategorieDto2.setN_NUM(Integer.parseInt(N_NUM));

		List<NovelCategorieDto> novelCategorieList = new ArrayList<NovelCategorieDto>();
		novelCategorieList.add(novelCategorieDto1);
		novelCategorieList.add(novelCategorieDto2);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("novelCategorieList", novelCategorieList);

		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		mav.addObject("novelHomeDto", novelHomeDto);
		mav.addObject("novelCategorieList", novelCategorieList);

		novelHomeService.novelhomeUploadOk(mav);

		return mav;
	}

}
