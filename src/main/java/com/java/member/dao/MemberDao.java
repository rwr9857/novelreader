package com.java.member.dao;

import com.java.member.dto.MemberDto;

public interface MemberDao {
  public int memberInsert(MemberDto memberDto);
  
  public MemberDto loginCheck(String id,String pw);

  public MemberDto profileSelect(String nickname);
}
