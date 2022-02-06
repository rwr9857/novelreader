package com.java.notice.dto;

import java.util.Date;

public class NoticeDto {
	private int not_num;
	private int m_num;
	private String not_title;
	private String not_content;
	private int not_viewcount;
	private Date not_time;
	
	
	
	
	public int getNot_num() {
		return not_num;
	}
	
	public void setNot_num(int not_num) {
		this.not_num = not_num;
	}
	
	public int getM_num() {
		return m_num;
	}
	
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	
	public String getNot_title() {
		return not_title;
	}
	
	public void setNot_title(String not_title) {
		this.not_title = not_title;
	}
	
	public String getNot_content() {
		return not_content;
	}
	
	public void setNot_content(String not_content) {
		this.not_content = not_content;
	}
	
	public int getNot_viewcount() {
		return not_viewcount;
	}
	
	public void setNot_viewcount(int not_viewcount) {
		this.not_viewcount = not_viewcount;
	}
	
	public Date getNot_time() {
		return not_time;
	}
	
	public void setNot_time(Date not_time) {
		this.not_time = not_time;
	}
	
	
	@Override
	public String toString() {
		return "NoticeDto [not_num=" + not_num + ", m_num=" + m_num + ", not_title=" + not_title + ", not_content="
				+ not_content + ", not_viewcount=" + not_viewcount + ", not_time=" + not_time + "]";
	}
	
	
}
