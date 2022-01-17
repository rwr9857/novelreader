package com.java.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.java.member.dto.MemberDto;

@Component
public class MemberDaoImp implements MemberDao {
  @Autowired
  private SqlSessionTemplate sqlSessionTemplate;

  @Override
  public int memberInsert(MemberDto memberDto) {
    return sqlSessionTemplate.insert("memberInsert",memberDto);
  }
  
}
