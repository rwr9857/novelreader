package com.java.homepage.service;

import org.springframework.web.servlet.ModelAndView;

public interface HomeService {
	public void index(ModelAndView mav);
	
	public void top10(ModelAndView mav);
}
