package com.java.notice.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.aop.LogAspect;
import com.java.notice.dao.NoticeDao;
import com.java.notice.dto.QuestionDto;

@Component
public class NoticeServiceImp implements NoticeService {
	@Autowired
	private NoticeDao noticeDao;

	@Override
	public void questionWrite(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String n_title = request.getParameter("n_title");
		
		mav.addObject("n_title", n_title);
		mav.setViewName("notice/questionWrite.tiles");
	}
	
	@Override
	public void questionWriteOk(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		QuestionDto questionDto = (QuestionDto) map.get("questionDto");

		LogAspect.logger.info(LogAspect.LogMsg + questionDto);
		
		int check = noticeDao.questionInsert(questionDto);
		LogAspect.logger.info(LogAspect.LogMsg + check);
		
		mav.addObject("check", check);
		
		mav.setViewName("notice/questionWriteOk");
	}
	
	@Override
	public void question(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		if(request.getParameter("m_num")!=null && !request.getParameter("m_num").equals("")) {
			int m_num = Integer.parseInt(request.getParameter("m_num"));
			
			String pageNumber = request.getParameter("pageNumber");
			
			if (pageNumber == null)
				pageNumber = "1";
			
			int currentPage = Integer.parseInt(pageNumber);
			LogAspect.logger.info(LogAspect.LogMsg + "현재 페이지 : " +currentPage);
	
			// 한페이지당 게시물 10개/ start 1, end 10
			int listSize = 10;
			int startRow = (currentPage - 1) * listSize + 1;
			int endRow = currentPage * listSize;
			
			
			List<QuestionDto> questionList = noticeDao.selectQuestion(m_num, startRow, endRow);
			
			int questionCount = noticeDao.selectQuestionCount(m_num);
			
			System.out.println(" 개수 " + questionCount);
			
			
			
			mav.addObject("listSize", listSize);
			mav.addObject("questionList", questionList);
			mav.addObject("questionCount", questionCount);
			mav.addObject("currentPage",currentPage);
			mav.addObject("m_num",m_num);
		}
		
		mav.setViewName("notice/question.tiles");
	}

	
	
	
	
	
}
