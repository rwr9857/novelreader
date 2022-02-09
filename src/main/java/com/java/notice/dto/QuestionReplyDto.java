package com.java.notice.dto;

import java.util.Date;

public class QuestionReplyDto {
	private int qr_num;
	private int m_num;
	private String qr_title;
	private String qr_content;
	private Date qr_time;
	
	
	public int getQr_num() {
		return qr_num;
	}
	public void setQr_num(int qr_num) {
		this.qr_num = qr_num;
	}
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	public String getQr_title() {
		return qr_title;
	}
	public void setQr_title(String qr_title) {
		this.qr_title = qr_title;
	}
	public String getQr_content() {
		return qr_content;
	}
	public void setQr_content(String qr_content) {
		this.qr_content = qr_content;
	}
	public Date getQr_time() {
		return qr_time;
	}
	public void setQr_time(Date qr_time) {
		this.qr_time = qr_time;
	}
	
	@Override
	public String toString() {
		return "QuestionReplyDto [qr_num=" + qr_num + ", m_num=" + m_num + ", qr_title=" + qr_title + ", qr_content="
				+ qr_content + ", qr_time=" + qr_time + "]";
	}
	
	
}
