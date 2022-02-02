package com.java.member.dao;

import java.util.List;

import com.java.member.dto.MemberDto;

public interface MemberDao {
	public int memberInsert(MemberDto memberDto);

	public MemberDto loginCheck(String id, String pw);

	public MemberDto profileSelect(String nickname);

	public int getCount();

	public List<MemberDto> memberList(int startRow, int endRow);

	public MemberDto pmLoginCheck(String platform, String platform_id);

	public int profileFollowingCount(int num);

	public int profileFollowerCount(int num);

	public List<MemberDto> profileFollowerList(int num, int startRow, int endRow);

	public List<MemberDto> profileFollowingList(int num, int startRow, int endRow);

	public int profileFollowCheck(int me, int num);

	public int follow(int numSess, int num);

	public int followDelete(int numSess, int num);

	public int nicknameCheck(String nickname);

	public int profileEditOk(MemberDto memberDto);

	public int emailCheck(String email);

	public int accountEditNoPw(MemberDto memberDto);
	
	public int accountEdit(MemberDto memberDto);

	public int accountDelete(int m_num);
}
