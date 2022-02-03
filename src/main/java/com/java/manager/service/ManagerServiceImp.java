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

@Component
public class ManagerServiceImp implements ManagerService {
	@Autowired
	private ManagerDao managerDao;

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


}
