package com.java.member.dao;

import java.util.List;

import com.java.member.dto.FollowDto;
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

	public List<FollowDto> profileFollower(int num);

	public List<FollowDto> profileFollowing(int num);
}
