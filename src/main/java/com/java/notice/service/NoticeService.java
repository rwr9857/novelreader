package com.java.notice.service;

import org.springframework.web.servlet.ModelAndView;

public interface NoticeService {
	public void noticeWriteOk(ModelAndView mav);

	public void question(ModelAndView mav);
	
	public void questionWrite(ModelAndView mav);
	
	public void questionWriteOk(ModelAndView mav);
	
	public void questionView(ModelAndView mav);
	
}
