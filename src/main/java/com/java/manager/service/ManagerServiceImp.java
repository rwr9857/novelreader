package com.java.manager.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.aop.LogAspect;
import com.java.category.dto.CategoryDto;
import com.java.manager.dao.ManagerDao;
import com.java.member.dao.MemberDao;
import com.java.member.dto.MemberDto;

@Component
public class ManagerServiceImp implements ManagerService {
	@Autowired
	private ManagerDao managerDao;
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public void memberDeleteOk(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		LogAspect.logger.info(LogAspect.LogMsg + request.getParameter("m_num"));
		
		int m_num=Integer.parseInt(request.getParameter("m_num"));
		int check = memberDao.accountDelete(m_num);
		LogAspect.logger.info(LogAspect.LogMsg + check);
		
		String pageNumber = request.getParameter("pageNumber");
		if (pageNumber == null)
			pageNumber = "1";

		int currentPage = Integer.parseInt(pageNumber);
		LogAspect.logger.info(LogAspect.LogMsg + "현재 페이지: "+ currentPage);

		// 한 페이지 당 게시물 1page 10개 / start 1, end 10
		int boardSize = 10;
		int startRow = (currentPage - 1) * boardSize + 1;
		int endRow = currentPage * boardSize;

		int count = memberDao.getCount();
		LogAspect.logger.info(LogAspect.LogMsg + count);
		
		List<MemberDto> memberList = null;
		if (count > 0) {
			memberList = memberDao.memberList(startRow, endRow);
			LogAspect.logger.info(LogAspect.LogMsg + memberList.size());
		}

		mav.addObject("boardSize", boardSize); // 한페이지당 게시물 수
		mav.addObject("currentPage", currentPage); // 요청페이지
		mav.addObject("memberList", memberList); // 회원 리스트
		mav.addObject("count", count); // 전체 게시물 수
		
		mav.setViewName("manager/memberDelete.tiles1");
	}

	@Override
	public void categoryList(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		List<CategoryDto> categoryList = managerDao.getCategoryList();
		LogAspect.logger.info(LogAspect.LogMsg + categoryList.size());

		if (categoryList.size() != 0) {
			mav.addObject("categoryList", categoryList);
		}

		mav.setViewName("manager/categoryView.tiles1");
	}

	@Override
	public void categoryWrite(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");

		String writeCategory = request.getParameter("writeCategory");
		LogAspect.logger.info(LogAspect.LogMsg + writeCategory);

		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setC_category_name(writeCategory);

		int check = managerDao.categoryInsert(categoryDto);
		LogAspect.logger.info(LogAspect.LogMsg + check);

		if (check > 0) {
			int categoryId = managerDao.getCategoryId();
			LogAspect.logger.info(LogAspect.LogMsg + categoryId);
			
			// HashMap에 카테고리 id와 카테고리 이름 넣기
			HashMap<String, Object> map1 = new HashMap<String, Object>();
			map1.put("categoryId", categoryId);
			map1.put("writeCategory", writeCategory);
			
			// map1을 json으로 만들다.
			String jsonText = JSONValue.toJSONString(map1);
			LogAspect.logger.info(LogAspect.LogMsg + jsonText);
			
			// json을 뷰에 넘겨준다.
			if (jsonText != null) {
				response.setContentType("application/x-json;charset=utf-8");
				PrintWriter out = null;
				try {
					out = response.getWriter();
				} catch (IOException e) {
					e.printStackTrace();
				}
				out.print(jsonText);
			}

		}

	}
	
	@Override
	public void memberDelete(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String pageNumber = request.getParameter("pageNumber");
		if (pageNumber == null)
			pageNumber = "1";

		int currentPage = Integer.parseInt(pageNumber);
		LogAspect.logger.info(LogAspect.LogMsg + "현재 페이지: "+ currentPage);

		// 한 페이지 당 게시물 1page 10개 / start 1, end 10
		int boardSize = 10;
		int startRow = (currentPage - 1) * boardSize + 1;
		int endRow = currentPage * boardSize;

		int count = memberDao.getCount();
		LogAspect.logger.info(LogAspect.LogMsg + count);
		
		List<MemberDto> memberList = null;
		if (count > 0) {
			memberList = memberDao.memberList(startRow, endRow);
			LogAspect.logger.info(LogAspect.LogMsg + memberList.size());
		}

		mav.addObject("boardSize", boardSize); // 한페이지당 게시물 수
		mav.addObject("currentPage", currentPage); // 요청페이지
		mav.addObject("memberList", memberList); // 회원 리스트
		mav.addObject("count", count); // 전체 게시물 수

		mav.setViewName("manager/memberDelete.tiles1");
		
	}


}
