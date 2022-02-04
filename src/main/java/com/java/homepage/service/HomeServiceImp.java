package com.java.homepage.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.aop.LogAspect;
import com.java.novelhome.dao.NovelHomeDao;
import com.java.novelhome.dto.NovelHomeDto;

@Component
public class HomeServiceImp implements HomeService {
	@Autowired
	private NovelHomeDao novelHomeDao;

	@Override
	public void index(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String pageNumber = request.getParameter("pageNumber");
		if (pageNumber == null)
			pageNumber = "1";

		int currentPage = Integer.parseInt(pageNumber);
		LogAspect.logger.info(LogAspect.LogMsg + currentPage);

		int boardSize = 9;
		int startRow = (currentPage - 1) * boardSize + 1;
		int endRow = currentPage * boardSize;

		int count = novelHomeDao.getAllCount();
		LogAspect.logger.info(LogAspect.LogMsg + count);

		List<NovelHomeDto> novelHomeList = null;
		if (count > 0) {
			novelHomeList = novelHomeDao.novelHomeList(startRow, endRow);
			LogAspect.logger.info(LogAspect.LogMsg + novelHomeList.size());
		}

		mav.addObject("novelHomeList", novelHomeList);
		mav.addObject("count", count);
		mav.addObject("boardSize", boardSize);
		mav.addObject("currentPage", currentPage);

		mav.setViewName("index.tiles");

	}
}
