package com.java.notice.service;

import java.util.Map;

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
	public void questionWriteOk(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		QuestionDto questionDto = (QuestionDto) map.get("questionDto");

		LogAspect.logger.info(LogAspect.LogMsg + questionDto);
		
		int check = noticeDao.questionInsert(questionDto);
		LogAspect.logger.info(LogAspect.LogMsg + check);
		
		mav.addObject("check", check);
		
		mav.setViewName("notice/questionWriteOk");
	}

}
