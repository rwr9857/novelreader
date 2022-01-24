package com.java.member.dao;

import java.util.HashMap;
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
    return sqlSessionTemplate.insert("memberInsert", memberDto);
  }

  @Override
  public MemberDto loginCheck(String id, String pw) {
    HashMap<String, Object> hMap = new HashMap<String, Object>();
    hMap.put("id", id);
    hMap.put("pw", pw);
    
    return sqlSessionTemplate.selectOne("loginCheck",hMap);
  }
  
  
  // -------------프로필--------------
  @Override
	public MemberDto profileSelect(String nickname) {
		return sqlSessionTemplate.selectOne("profileSelect",nickname);
	}
}
