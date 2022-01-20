package com.java.novelhome.dto;

import java.util.Date;

public class NovelHomeDto {
	private int N_NUM;
	private String N_TITLE;
	private String N_SUMMARY;
	private String N_IMAGE_NAME;
	private String N_IMAGE_PATH;
	private Long N_IMAGE_SIZE;
	private Date N_PUB_DATE;
	private int N_REPORT;
	private int M_NUM;

	public int getN_NUM() {
		return N_NUM;
	}

	public void setN_NUM(int n_NUM) {
		N_NUM = n_NUM;
	}

	public String getN_TITLE() {
		return N_TITLE;
	}

	public void setN_TITLE(String n_TITLE) {
		N_TITLE = n_TITLE;
	}

	public String getN_SUMMARY() {
		return N_SUMMARY;
	}

	public void setN_SUMMARY(String n_SUMMARY) {
		N_SUMMARY = n_SUMMARY;
	}

	public String getN_IMAGE_NAME() {
		return N_IMAGE_NAME;
	}

	public void setN_IMAGE_NAME(String n_IMAGE_NAME) {
		N_IMAGE_NAME = n_IMAGE_NAME;
	}

	public String getN_IMAGE_PATH() {
		return N_IMAGE_PATH;
	}

	public void setN_IMAGE_PATH(String n_IMAGE_PATH) {
		N_IMAGE_PATH = n_IMAGE_PATH;
	}

	public Long getN_IMAGE_SIZE() {
		return N_IMAGE_SIZE;
	}

	public void setN_IMAGE_SIZE(Long n_IMAGE_SIZE) {
		N_IMAGE_SIZE = n_IMAGE_SIZE;
	}

	public Date getN_PUB_DATE() {
		return N_PUB_DATE;
	}

	public void setN_PUB_DATE(Date n_PUB_DATE) {
		N_PUB_DATE = n_PUB_DATE;
	}

	public int getN_REPORT() {
		return N_REPORT;
	}

	public void setN_REPORT(int n_REPORT) {
		N_REPORT = n_REPORT;
	}

	public int getM_NUM() {
		return M_NUM;
	}

	public void setM_NUM(int m_NUM) {
		M_NUM = m_NUM;
	}

	@Override
	public String toString() {
		return "NovelHomeDto [N_NUM=" + N_NUM + ", N_TITLE=" + N_TITLE + ", N_SUMMARY=" + N_SUMMARY + ", N_IMAGE_NAME="
				+ N_IMAGE_NAME + ", N_IMAGE_PATH=" + N_IMAGE_PATH + ", N_IMAGE_SIZE=" + N_IMAGE_SIZE + ", N_PUB_DATE="
				+ N_PUB_DATE + ", N_REPORT=" + N_REPORT + ", M_NUM=" + M_NUM + "]";
	}

	

}
