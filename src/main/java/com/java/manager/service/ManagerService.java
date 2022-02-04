package com.java.manager.service;

import org.springframework.web.servlet.ModelAndView;

public interface ManagerService {
	public void memberModify(ModelAndView mav);
	
	public void memberUpdate(ModelAndView mav);
	
	public void memberDelete(ModelAndView mav);
	
	public void memberDeleteOk(ModelAndView mav);
	
	public void categoryList(ModelAndView mav);

	public void categoryWrite(ModelAndView mav);
	
	public void categoryDelete(ModelAndView mav);
	
	public void categoryDeleteOk(ModelAndView mav);
	
}
