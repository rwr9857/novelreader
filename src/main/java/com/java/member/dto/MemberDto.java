package com.java.member.dto;

import java.util.Date;

public class MemberDto {
  private int m_num;
  private String m_id;
  private String m_pw;
  private String m_email;
  private int m_email_agree;
  private String m_nickname;

  private String m_sex;
  private String m_homepage_address;
  private String m_city;
  private Date m_register_date;
  private String m_permission;

  private String m_photo_name;
  private String m_photo_path;
  private long m_photo_size;
  private String m_info;
  private Date m_birthday;

  private int m_homepage_public;
  private int m_sex_public;
  private int m_city_public;
  private int m_birthday_public;
  private int m_info_public;

  private String m_platform;
  private String m_sns_id;
  
public int getM_num() {
	return m_num;
}
public void setM_num(int m_num) {
	this.m_num = m_num;
}
public String getM_id() {
	return m_id;
}
public void setM_id(String m_id) {
	this.m_id = m_id;
}
public String getM_pw() {
	return m_pw;
}
public void setM_pw(String m_pw) {
	this.m_pw = m_pw;
}
public String getM_email() {
	return m_email;
}
public void setM_email(String m_email) {
	this.m_email = m_email;
}
public int getM_email_agree() {
	return m_email_agree;
}
public void setM_email_agree(int m_email_agree) {
	this.m_email_agree = m_email_agree;
}
public String getM_nickname() {
	return m_nickname;
}
public void setM_nickname(String m_nickname) {
	this.m_nickname = m_nickname;
}
public String getM_sex() {
	return m_sex;
}
public void setM_sex(String m_sex) {
	this.m_sex = m_sex;
}
public String getM_homepage_address() {
	return m_homepage_address;
}
public void setM_homepage_address(String m_homepage_address) {
	this.m_homepage_address = m_homepage_address;
}
public String getM_city() {
	return m_city;
}
public void setM_city(String m_city) {
	this.m_city = m_city;
}
public Date getM_register_date() {
	return m_register_date;
}
public void setM_register_date(Date m_register_date) {
	this.m_register_date = m_register_date;
}
public String getM_permission() {
	return m_permission;
}
public void setM_permission(String m_permission) {
	this.m_permission = m_permission;
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
public String getM_info() {
	return m_info;
}
public void setM_info(String m_info) {
	this.m_info = m_info;
}
public Date getM_birthday() {
	return m_birthday;
}
public void setM_birthday(Date m_birthday) {
	this.m_birthday = m_birthday;
}
public int getM_homepage_public() {
	return m_homepage_public;
}
public void setM_homepage_public(int m_homepage_public) {
	this.m_homepage_public = m_homepage_public;
}
public int getM_sex_public() {
	return m_sex_public;
}
public void setM_sex_public(int m_sex_public) {
	this.m_sex_public = m_sex_public;
}
public int getM_city_public() {
	return m_city_public;
}
public void setM_city_public(int m_city_public) {
	this.m_city_public = m_city_public;
}
public int getM_birthday_public() {
	return m_birthday_public;
}
public void setM_birthday_public(int m_birthday_public) {
	this.m_birthday_public = m_birthday_public;
}
public int getM_info_public() {
	return m_info_public;
}
public void setM_info_public(int m_info_public) {
	this.m_info_public = m_info_public;
}
public String getM_platform() {
	return m_platform;
}
public void setM_platform(String m_platform) {
	this.m_platform = m_platform;
}
public String getM_sns_id() {
	return m_sns_id;
}
public void setM_sns_id(String m_sns_id) {
	this.m_sns_id = m_sns_id;
}

@Override
public String toString() {
	return "MemberDto [m_num=" + m_num + ", m_id=" + m_id + ", m_pw=" + m_pw + ", m_email=" + m_email
			+ ", m_email_agree=" + m_email_agree + ", m_nickname=" + m_nickname + ", m_sex=" + m_sex
			+ ", m_homepage_address=" + m_homepage_address + ", m_city=" + m_city + ", m_register_date="
			+ m_register_date + ", m_permission=" + m_permission + ", m_photo_name=" + m_photo_name + ", m_photo_path="
			+ m_photo_path + ", m_photo_size=" + m_photo_size + ", m_info=" + m_info + ", m_birthday=" + m_birthday
			+ ", m_homepage_public=" + m_homepage_public + ", m_sex_public=" + m_sex_public + ", m_city_public="
			+ m_city_public + ", m_birthday_public=" + m_birthday_public + ", m_info_public=" + m_info_public
			+ ", m_platform=" + m_platform + ", m_sns_id=" + m_sns_id + "]";
}

}
