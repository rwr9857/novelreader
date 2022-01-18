package com.java.member.dto;

import java.util.Date;

public class MemberDto {
  private int M_NUM;
  private String M_ID;
  private String M_PW;
  private String M_EMAIL;
  private int M_EMAIL_AGREE;
  private String M_NICKNAME;

  private String M_SEX;
  private String M_HOMEPAGE_ADDRESS;
  private String M_CITY;
  private Date M_REGISTER_DATE;
  private String M_PERMISSION;

  private String M_PHOTO_NAME;
  private String M_PHOTO_PATH;
  private long M_PHOTO_SIZE;
  private String M_INFO;
  private Date M_BIRTHDAY;

  private int M_HOMEPAGE_PUBLIC;
  private int M_SEX_PUBLIC;
  private int M_CITY_PUBLIC;
  private int M_BIRTHDAY_PUBLIC;
  private int M_INFO_PUBLIC;

  private String M_PLATFORM;
  private String M_SNS_ID;

  public int getM_NUM() {
    return M_NUM;
  }

  public void setM_NUM(int m_NUM) {
    M_NUM = m_NUM;
  }

  public String getM_ID() {
    return M_ID;
  }

  public void setM_ID(String m_ID) {
    M_ID = m_ID;
  }

  public String getM_PW() {
    return M_PW;
  }

  public void setM_PW(String m_PW) {
    M_PW = m_PW;
  }

  public String getM_EMAIL() {
    return M_EMAIL;
  }

  public void setM_EMAIL(String m_EMAIL) {
    M_EMAIL = m_EMAIL;
  }

  public int getM_EMAIL_AGREE() {
    return M_EMAIL_AGREE;
  }

  public void setM_EMAIL_AGREE(int m_EMAIL_AGREE) {
    M_EMAIL_AGREE = m_EMAIL_AGREE;
  }

  public String getM_NICKNAME() {
    return M_NICKNAME;
  }

  public void setM_NICKNAME(String m_NICKNAME) {
    M_NICKNAME = m_NICKNAME;
  }

  public String getM_SEX() {
    return M_SEX;
  }

  public void setM_SEX(String m_SEX) {
    M_SEX = m_SEX;
  }

  public String getM_HOMEPAGE_ADDRESS() {
    return M_HOMEPAGE_ADDRESS;
  }

  public void setM_HOMEPAGE_ADDRESS(String m_HOMEPAGE_ADDRESS) {
    M_HOMEPAGE_ADDRESS = m_HOMEPAGE_ADDRESS;
  }

  public String getM_CITY() {
    return M_CITY;
  }

  public void setM_CITY(String m_CITY) {
    M_CITY = m_CITY;
  }

  public Date getM_REGISTER_DATE() {
    return M_REGISTER_DATE;
  }

  public void setM_REGISTER_DATE(Date m_REGISTER_DATE) {
    M_REGISTER_DATE = m_REGISTER_DATE;
  }

  public String getM_PERMISSION() {
    return M_PERMISSION;
  }

  public void setM_PERMISSION(String m_PERMISSION) {
    M_PERMISSION = m_PERMISSION;
  }

  public String getM_PHOTO_NAME() {
    return M_PHOTO_NAME;
  }

  public void setM_PHOTO_NAME(String m_PHOTO_NAME) {
    M_PHOTO_NAME = m_PHOTO_NAME;
  }

  public String getM_PHOTO_PATH() {
    return M_PHOTO_PATH;
  }

  public void setM_PHOTO_PATH(String m_PHOTO_PATH) {
    M_PHOTO_PATH = m_PHOTO_PATH;
  }

  public long getM_PHOTO_SIZE() {
    return M_PHOTO_SIZE;
  }

  public void setM_PHOTO_SIZE(long m_PHOTO_SIZE) {
    M_PHOTO_SIZE = m_PHOTO_SIZE;
  }

  public String getM_INFO() {
    return M_INFO;
  }

  public void setM_INFO(String m_INFO) {
    M_INFO = m_INFO;
  }


  public Date getM_BIRTHDAY() {
    return M_BIRTHDAY;
  }

  public void setM_BIRTHDAY(Date m_BIRTHDAY) {
    M_BIRTHDAY = m_BIRTHDAY;
  }

  public int getM_HOMEPAGE_PUBLIC() {
    return M_HOMEPAGE_PUBLIC;
  }

  public void setM_HOMEPAGE_PUBLIC(int m_HOMEPAGE_PUBLIC) {
    M_HOMEPAGE_PUBLIC = m_HOMEPAGE_PUBLIC;
  }

  public int getM_SEX_PUBLIC() {
    return M_SEX_PUBLIC;
  }

  public void setM_SEX_PUBLIC(int m_SEX_PUBLIC) {
    M_SEX_PUBLIC = m_SEX_PUBLIC;
  }

  public int getM_CITY_PUBLIC() {
    return M_CITY_PUBLIC;
  }

  public void setM_CITY_PUBLIC(int m_CITY_PUBLIC) {
    M_CITY_PUBLIC = m_CITY_PUBLIC;
  }

  public int getM_BIRTHDAY_PUBLIC() {
    return M_BIRTHDAY_PUBLIC;
  }

  public void setM_BIRTHDAY_PUBLIC(int m_BIRTHDAY_PUBLIC) {
    M_BIRTHDAY_PUBLIC = m_BIRTHDAY_PUBLIC;
  }

  public int getM_INFO_PUBLIC() {
    return M_INFO_PUBLIC;
  }

  public void setM_INFO_PUBLIC(int m_INFO_PUBLIC) {
    M_INFO_PUBLIC = m_INFO_PUBLIC;
  }

  public String getM_PLATFORM() {
    return M_PLATFORM;
  }

  public void setM_PLATFORM(String m_PLATFORM) {
    M_PLATFORM = m_PLATFORM;
  }

  public String getM_SNS_ID() {
    return M_SNS_ID;
  }

  public void setM_SNS_ID(String m_SNS_ID) {
    M_SNS_ID = m_SNS_ID;
  }

  @Override
  public String toString() {
    return "MemberDto [M_NUM=" + M_NUM + ", M_ID=" + M_ID + ", M_PW=" + M_PW + ", M_EMAIL=" + M_EMAIL + ", M_EMAIL_AGREE=" + M_EMAIL_AGREE + ", M_NICKNAME=" + M_NICKNAME + ", M_SEX=" + M_SEX
        + ", M_HOMEPAGE_ADDRESS=" + M_HOMEPAGE_ADDRESS + ", M_CITY=" + M_CITY + ", M_REGISTER_DATE=" + M_REGISTER_DATE + ", M_PERMISSION=" + M_PERMISSION + ", M_PHOTO_NAME=" + M_PHOTO_NAME
        + ", M_PHOTO_PATH=" + M_PHOTO_PATH + ", M_PHOTO_SIZE=" + M_PHOTO_SIZE + ", M_INFO=" + M_INFO + ", M_BIRTHDAY=" + M_BIRTHDAY + ", M_HOMEPAGE_PUBLIC=" + M_HOMEPAGE_PUBLIC + ", M_SEX_PUBLIC="
        + M_SEX_PUBLIC + ", M_CITY_PUBLIC=" + M_CITY_PUBLIC + ", M_BIRTHDAY_PUBLIC=" + M_BIRTHDAY_PUBLIC + ", M_INFO_PUBLIC=" + M_INFO_PUBLIC + ", M_PLATFORM=" + M_PLATFORM + ", M_SNS_ID=" + M_SNS_ID
        + "]";
  }



}
