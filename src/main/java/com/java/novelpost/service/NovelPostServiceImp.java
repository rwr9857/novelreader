package com.java.novelpost.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.aop.LogAspect;
import com.java.novelpost.dao.NovelPostDao;
import com.java.novelpost.dto.NovelPostDto;

@Component
public class NovelPostServiceImp implements NovelPostService {
	@Autowired
	private NovelPostDao novelPostDao;

	@Override
	public void novelhomeRegister(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String pageNumber = request.getParameter("pageNumber");
		if (pageNumber == null)
			pageNumber = "1";

		int currentPage = Integer.parseInt(pageNumber);
		LogAspect.logger.info(LogAspect.LogMsg + "currentPage=" + currentPage);

		int boardSize = 4;
		int startRow = (currentPage - 1) * boardSize + 1;
		int endRow = currentPage * boardSize;

		int count = novelPostDao.getCount();
		LogAspect.logger.info(LogAspect.LogMsg + "count=" + count);

		List<NovelPostDto> novelPostList = null;
		if (count > 0) {
			novelPostList = novelPostDao.novelPostList(startRow, endRow);
		}
//		LogAspect.logger.info(LogAspect.LogMsg + novelPostList.size());

		mav.addObject("novelPostList", novelPostList);
		mav.addObject("count", count);
		mav.addObject("boardSize", boardSize);
		mav.addObject("currentPage", currentPage);
		mav.setViewName("novelpost/register");
	}

	@Override
	public void novelhomeRegisterOk(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		NovelPostDto novelPostDto = (NovelPostDto) map.get("novelPostDto");

		int check = novelPostDao.novelPostInsert(novelPostDto);
		LogAspect.logger.info(LogAspect.LogMsg + check);

		mav.addObject("check", check);
		mav.setViewName("novelpost/registerOk");
	}

}
