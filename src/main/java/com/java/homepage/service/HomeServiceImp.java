package com.java.homepage.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.aop.LogAspect;
import com.java.category.dto.CategoryDto;
import com.java.manager.dao.ManagerDao;
import com.java.member.dao.MemberDao;
import com.java.member.dto.MemberDto;
import com.java.novelhome.dao.NovelHomeDao;
import com.java.novelhome.dto.NovelHomeDto;

@Component
public class HomeServiceImp implements HomeService {
	@Autowired
	private NovelHomeDao novelHomeDao;

	@Autowired
	private ManagerDao managerDao;
	
	@Autowired
	private MemberDao memberDao;

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

		int categoryCount = managerDao.getCategoryId();
		LogAspect.logger.info(LogAspect.LogMsg + categoryCount);

		List<CategoryDto> CategoryList = null;
		if (categoryCount > 0) {
			CategoryList = managerDao.getCategoryListDesc();
			LogAspect.logger.info(LogAspect.LogMsg + CategoryList.size());
		}
		
		// 최신순 기준
		mav.addObject("novelHomeList", novelHomeList);
		mav.addObject("CategoryList", CategoryList);
		mav.addObject("count", count);
		mav.addObject("boardSize", boardSize);
		mav.addObject("currentPage", currentPage);

		mav.setViewName("index.tiles");

	}
	
	@Override
	public void top10(ModelAndView mav) {
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

		List<NovelHomeDto> novelViewCountList = null;
		if (count > 0) {
			novelViewCountList = novelHomeDao.novelViewCountList(startRow, endRow);
			LogAspect.logger.info(LogAspect.LogMsg + novelViewCountList.size());
		}

		int categoryCount = managerDao.getCategoryId();
		LogAspect.logger.info(LogAspect.LogMsg + categoryCount);

		List<CategoryDto> CategoryList = null;
		if (categoryCount > 0) {
			CategoryList = managerDao.getCategoryListDesc();
			LogAspect.logger.info(LogAspect.LogMsg + CategoryList.size());
		}

		mav.addObject("novelViewCountList", novelViewCountList);
		mav.addObject("CategoryList", CategoryList);
		mav.addObject("count", count);
		mav.addObject("boardSize", boardSize);
		mav.addObject("currentPage", currentPage);
		
		
		mav.setViewName("home/indexAdd.tiles");
		
	}
	
	
	
	
	
	@Override
	public void ranking(ModelAndView mav) {
		
		List<MemberDto> rankingList=null;
		
		rankingList=memberDao.ranking();
		
		System.out.println(rankingList.toString());
		
		
		mav.addObject("rankingList", rankingList);
		
		mav.setViewName("home/ranking.tiles");
	}
	
	
	
	
	
}
