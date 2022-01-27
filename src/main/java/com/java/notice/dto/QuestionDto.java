package com.java.notice.dto;

import java.util.Date;

public class QuestionDto {
		private int q_num;
		private int m_num;
		private String q_title;
		private String q_content;
		private int q_viewcount;
		private Date q_time;
		private String q_category;
		
		public int getQ_num() {
			return q_num;
		}
		public void setQ_num(int q_num) {
			this.q_num = q_num;
		}
		public int getM_num() {
			return m_num;
		}
		public void setM_num(int m_num) {
			this.m_num = m_num;
		}
		public String getQ_title() {
			return q_title;
		}
		public void setQ_title(String q_title) {
			this.q_title = q_title;
		}
		public String getQ_content() {
			return q_content;
		}
		public void setQ_content(String q_content) {
			this.q_content = q_content;
		}
		public int getQ_viewcount() {
			return q_viewcount;
		}
		public void setQ_viewcount(int q_viewcount) {
			this.q_viewcount = q_viewcount;
		}
		public Date getQ_time() {
			return q_time;
		}
		public void setQ_time(Date q_time) {
			this.q_time = q_time;
		}
		public String getQ_category() {
			return q_category;
		}
		public void setQ_category(String q_category) {
			this.q_category = q_category;
		}
		@Override
		public String toString() {
			return "QuestionDto [q_num=" + q_num + ", m_num=" + m_num + ", q_title=" + q_title + ", q_content="
					+ q_content + ", q_viewcount=" + q_viewcount + ", q_time=" + q_time + ", q_category=" + q_category
					+ "]";
		}
		
		
}
