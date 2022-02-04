package com.java.novelpost.service;

import org.springframework.web.servlet.ModelAndView;

public interface NovelPostService {
	
	public void novelPostRegisterOk(ModelAndView mav);

	public void novelPostRead(ModelAndView mav);

	public void novelPostDelete(ModelAndView mav);

	public void novelPostUpdate(ModelAndView mav);

	public void novelPostUpdateOk(ModelAndView mav);

}
