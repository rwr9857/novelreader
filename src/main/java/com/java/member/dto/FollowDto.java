package com.java.member.dto;

public class FollowDto {
	private int m_num;
	private int following;
	private String m_nickname;
	private String m_photo_name;
	private String m_photo_path;
	private long m_photo_size;
	
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	public int getFollowing() {
		return following;
	}
	public void setFollowing(int following) {
		this.following = following;
	}
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	public String getM_photo_name() {
		return m_photo_name;
	}
	public void setM_photo_name(String m_photo_name) {
		this.m_photo_name = m_photo_name;
	}
	public String getM_photo_path() {
		return m_photo_path;
	}
	public void setM_photo_path(String m_photo_path) {
		this.m_photo_path = m_photo_path;
	}
	public long getM_photo_size() {
		return m_photo_size;
	}
	public void setM_photo_size(long m_photo_size) {
		this.m_photo_size = m_photo_size;
	}
	
	@Override
	public String toString() {
		return "FollowDto [m_num=" + m_num + ", following=" + following + ", m_nickname=" + m_nickname
				+ ", m_photo_name=" + m_photo_name + ", m_photo_path=" + m_photo_path + ", m_photo_size=" + m_photo_size
				+ "]";
	}
	
	
}
