package com.java.novelpost.dto;

import java.util.Date;

public class NovelPostDto {
	private int N_NUM; // 소설로고번호
	private int N_POST_EPISODE; // 소설_회차
	private String N_POST_TITLE; // 회차_제목
	private String N_POST_CONTENT_NAME;// 회차_내용_이름
	private String N_POST_CONTENT_PATH;// 회차_내용_경로
	private Long N_POST_CONTENT_SIZE;// 회차_내용_사이즈
	private int N_POST_LIKE;// 회차_좋아요
	private int N_POST_DISLIKE;// 회차_싫어요
	private int N_POST_VIEWCOUNT;// 게시글조회수
	private Date N_POST_TIME;// 소설업로드시간

	public int getN_NUM() {
		return N_NUM;
	}

	public void setN_NUM(int n_NUM) {
		N_NUM = n_NUM;
	}

	public int getN_POST_EPISODE() {
		return N_POST_EPISODE;
	}

	public void setN_POST_EPISODE(int n_POST_EPISODE) {
		N_POST_EPISODE = n_POST_EPISODE;
	}

	public String getN_POST_TITLE() {
		return N_POST_TITLE;
	}

	public void setN_POST_TITLE(String n_POST_TITLE) {
		N_POST_TITLE = n_POST_TITLE;
	}

	public String getN_POST_CONTENT_NAME() {
		return N_POST_CONTENT_NAME;
	}

	public void setN_POST_CONTENT_NAME(String n_POST_CONTENT_NAME) {
		N_POST_CONTENT_NAME = n_POST_CONTENT_NAME;
	}

	public String getN_POST_CONTENT_PATH() {
		return N_POST_CONTENT_PATH;
	}

	public void setN_POST_CONTENT_PATH(String n_POST_CONTENT_PATH) {
		N_POST_CONTENT_PATH = n_POST_CONTENT_PATH;
	}

	public Long getN_POST_CONTENT_SIZE() {
		return N_POST_CONTENT_SIZE;
	}

	public void setN_POST_CONTENT_SIZE(Long n_POST_CONTENT_SIZE) {
		N_POST_CONTENT_SIZE = n_POST_CONTENT_SIZE;
	}

	public int getN_POST_LIKE() {
		return N_POST_LIKE;
	}

	public void setN_POST_LIKE(int n_POST_LIKE) {
		N_POST_LIKE = n_POST_LIKE;
	}

	public int getN_POST_DISLIKE() {
		return N_POST_DISLIKE;
	}

	public void setN_POST_DISLIKE(int n_POST_DISLIKE) {
		N_POST_DISLIKE = n_POST_DISLIKE;
	}

	public int getN_POST_VIEWCOUNT() {
		return N_POST_VIEWCOUNT;
	}

	public void setN_POST_VIEWCOUNT(int n_POST_VIEWCOUNT) {
		N_POST_VIEWCOUNT = n_POST_VIEWCOUNT;
	}

	public Date getN_POST_TIME() {
		return N_POST_TIME;
	}

	public void setN_POST_TIME(Date n_POST_TIME) {
		N_POST_TIME = n_POST_TIME;
	}

	@Override
	public String toString() {
		return "NovelPostDto [N_NUM=" + N_NUM + ", N_POST_EPISODE=" + N_POST_EPISODE + ", N_POST_TITLE=" + N_POST_TITLE
				+ ", N_POST_CONTENT_NAME=" + N_POST_CONTENT_NAME + ", N_POST_CONTENT_PATH=" + N_POST_CONTENT_PATH
				+ ", N_POST_CONTENT_SIZE=" + N_POST_CONTENT_SIZE + ", N_POST_LIKE=" + N_POST_LIKE + ", N_POST_DISLIKE="
				+ N_POST_DISLIKE + ", N_POST_VIEWCOUNT=" + N_POST_VIEWCOUNT + ", N_POST_TIME=" + N_POST_TIME + "]";
	}

}
