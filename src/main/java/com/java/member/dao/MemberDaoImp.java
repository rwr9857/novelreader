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
	public MemberDto profileSelect(String nickname) {									//프로필Dto 불러오기
		return sqlSessionTemplate.selectOne("profileSelect", nickname);
	}
	
	@Override
	public List<MemberDto> profileFollowerList(int num, int startRow, int endRow) {		//팔로워 리스트
		HashMap<String, Integer> hMap = new HashMap<String, Integer>();
		hMap.put("num", num);
		hMap.put("startRow", startRow);
		hMap.put("endRow", endRow);
		return sqlSessionTemplate.selectList("profileFollower",hMap);
	}
	
	@Override
	public int profileFollowerCount(int num) {							//팔로워 수 체크
		return sqlSessionTemplate.selectOne("profileFollowerCount",num);
	}
	
	@Override
	public List<MemberDto> profileFollowingList(int num, int startRow, int endRow) {	//팔로잉 리스트
		HashMap<String, Integer> hMap = new HashMap<String, Integer>();
		hMap.put("num", num);
		hMap.put("startRow", startRow);
		hMap.put("endRow", endRow);
		return sqlSessionTemplate.selectList("profileFollowing",hMap);
	}
	
	@Override
	public int profileFollowingCount(int num) {							//팔로잉 수 체크
		return sqlSessionTemplate.selectOne("profileFollowingCount",num);
	}
	
	@Override
	public int profileFollowCheck(int me, int num) {					//팔로우 돼있는지 체크
		HashMap<String, Integer> hMap = new HashMap<String, Integer>();
		hMap.put("me", me);
		hMap.put("num", num);
		
		return sqlSessionTemplate.selectOne("profileFollowCheck",hMap);
	}
	
	@Override
	public int follow(int numSess, int num) {							//팔로우 하기
		HashMap<String, Integer> hMap = new HashMap<String, Integer>();
		hMap.put("numSess", numSess);
		hMap.put("num", num);
		return sqlSessionTemplate.insert("followInsert",hMap);
	}
	
	@Override
	public int followDelete(int numSess, int num) {						//팔로우 취소하기
		HashMap<String, Integer> hMap = new HashMap<String, Integer>();
		hMap.put("numSess", numSess);
		hMap.put("num", num);
		return sqlSessionTemplate.delete("followDelete",hMap);
	}
	
	
	@Override
	public int nicknameCheck(String nickname) {
		return sqlSessionTemplate.selectOne("nicknameCheck",nickname);
	}
	
	
	@Override
	public int profileEditOk(MemberDto memberDto) {		
		return sqlSessionTemplate.update("profileEditOk",memberDto);
	}
	
	@Override
	public int emailCheck(String email) {
		return sqlSessionTemplate.selectOne("emailCheck",email);
	}
	
	@Override
	public int accountEditNoPw(MemberDto memberDto) {		
		return sqlSessionTemplate.update("accountEditNoPw",memberDto);
	}
	
	@Override
	public int accountEdit(MemberDto memberDto) {
		return sqlSessionTemplate.update("accountEdit",memberDto);
	}
	
	@Override
	public int accountDelete(int m_num) {
		return sqlSessionTemplate.delete("accountDelete",m_num);
	}
	
	@Override
	public String getPhotoName(String nickname) {
		return sqlSessionTemplate.selectOne("getPhotoName", nickname);
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

	
	
	
	
	
	// --------------인기작가 ------------------
	
	@Override
	public List<MemberDto> ranking() {
		return sqlSessionTemplate.selectList("ranking");
	}
	
	
	
	
	
	
	
}
