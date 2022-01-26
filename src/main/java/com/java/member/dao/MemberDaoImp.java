package com.java.member.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.member.dto.FollowDto;
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

	// -------------플랫폼 로그인--------------

	@Override
	public MemberDto pmLoginCheck(String platform, String platform_id) {
		HashMap<String, Object> hMap = new HashMap<String, Object>();
		hMap.put("platform", platform);
		hMap.put("platform_id", platform_id);

		return sqlSessionTemplate.selectOne("pmLoginCheck", hMap);
	}

	// -------------프로필--------------
	@Override
	public MemberDto profileSelect(String nickname) {
		return sqlSessionTemplate.selectOne("profileSelect", nickname);
	}
	
	@Override
	public List<MemberDto> profileFollowerList(int num, int startRow, int endRow) {
		HashMap<String, Integer> hMap = new HashMap<String, Integer>();
		hMap.put("num", num);
		hMap.put("startRow", startRow);
		hMap.put("endRow", endRow);
		return sqlSessionTemplate.selectList("profileFollower",hMap);
	}
	
	@Override
	public int profileFollowerCount(int num) {
		return sqlSessionTemplate.selectOne("profileFollowerCount",num);
	}
	
	@Override
	public List<MemberDto> profileFollowingList(int num, int startRow, int endRow) {
		return sqlSessionTemplate.selectList("profileFollowing",num);
	}
	
	@Override
	public int profileFollowingCount(int num) {
		return sqlSessionTemplate.selectOne("profileFollowingCount",num);
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
