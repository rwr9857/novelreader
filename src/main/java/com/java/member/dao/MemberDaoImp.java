package com.java.member.dao;

import java.util.HashMap;
import java.util.List;

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

		return sqlSessionTemplate.selectOne("loginCheck", hMap);
	}

	// -------------프로필--------------
	@Override
	public MemberDto profileSelect(String nickname) {
		return sqlSessionTemplate.selectOne("profileSelect", nickname);
	}
	
	// -------------관리자 회원조회--------------

	@Override
	public int getCount() {
		return sqlSessionTemplate.selectOne("memberCount");
	}

	@Override
	public List<MemberDto> memberList(int startRow, int endRow) {
		HashMap<String, Integer> hMap = new HashMap<String, Integer>();
		hMap.put("startRow", startRow);
		hMap.put("endRow", endRow);

		return sqlSessionTemplate.selectList("memberList", hMap);
	}

}
