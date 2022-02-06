package com.java.comment.dto;

import java.util.Date;

public class CommentDto {
	private int comment_num;
	private int m_num;
	private String comment_content;
	private Date comment_time;
	private int n_post_num;

	public int getComment_num() {
		return comment_num;
	}

	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}

	public int getM_num() {
		return m_num;
	}

	public void setM_num(int m_num) {
		this.m_num = m_num;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public Date getComment_time() {
		return comment_time;
	}

	public void setComment_time(Date comment_time) {
		this.comment_time = comment_time;
	}

	public int getN_post_num() {
		return n_post_num;
	}

	public void setN_post_num(int n_post_num) {
		this.n_post_num = n_post_num;
	}

	@Override
	public String toString() {
		return "CommentDto [comment_num=" + comment_num + ", m_num=" + m_num + ", comment_content=" + comment_content
				+ ", comment_time=" + comment_time + ", n_post_num=" + n_post_num + "]";
	}

}
