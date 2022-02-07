package com.java.novelhome.dto;

import java.util.Date;

public class NovelHomeDto {
	private int n_num;
	private String n_title;
	private String n_summary;
	private String n_image_name;
	private String n_image_path;

	private Long n_image_size;
	private Date n_pub_date;
	private int n_report;
	private int m_num;
	
	
	// member table JOIN
	private String m_nickname;
	
	private String c_category_name;

	public int getN_num() {
		return n_num;
	}

	public void setN_num(int n_num) {
		this.n_num = n_num;
	}

	public String getN_title() {
		return n_title;
	}

	public void setN_title(String n_title) {
		this.n_title = n_title;
	}

	public String getN_summary() {
		return n_summary;
	}

	public void setN_summary(String n_summary) {
		this.n_summary = n_summary;
	}

	public String getN_image_name() {
		return n_image_name;
	}

	public void setN_image_name(String n_image_name) {
		this.n_image_name = n_image_name;
	}

	public String getN_image_path() {
		return n_image_path;
	}

	public void setN_image_path(String n_image_path) {
		this.n_image_path = n_image_path;
	}

	public Long getN_image_size() {
		return n_image_size;
	}

	public void setN_image_size(Long n_image_size) {
		this.n_image_size = n_image_size;
	}

	public Date getN_pub_date() {
		return n_pub_date;
	}

	public void setN_pub_date(Date n_pub_date) {
		this.n_pub_date = n_pub_date;
	}

	public int getN_report() {
		return n_report;
	}

	public void setN_report(int n_report) {
		this.n_report = n_report;
	}

	public int getM_num() {
		return m_num;
	}

	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	
	
	

	public String getM_nickname() {
		return m_nickname;
	}

	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	
	
	
	
	public String getC_category_name() {
		return c_category_name;
	}

	public void setC_category_name(String c_category_name) {
		this.c_category_name = c_category_name;
	}

	@Override
	public String toString() {
		return "NovelHomeDto [n_num=" + n_num + ", n_title=" + n_title + ", n_summary=" + n_summary + ", n_image_name="
				+ n_image_name + ", n_image_path=" + n_image_path + ", n_image_size=" + n_image_size + ", n_pub_date="
				+ n_pub_date + ", n_report=" + n_report + ", m_num=" + m_num + ", m_nickname=" + m_nickname + "]";
	}

	

}
