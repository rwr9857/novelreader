package com.java.novelhome.dao;

import java.util.List;

import com.java.novelhome.dto.NovelHomeDto;
import com.java.novelpost.dto.NovelPostDto;

public interface NovelHomeDao {

	public int novelHomeUpload(NovelHomeDto novelHomeDto);

	public NovelHomeDto novelHomeList(int n_num);

	public int novelHomeSelectGetNum(int m_num);

	public int getCount(int n_num);

	public List<NovelPostDto> novelPostList(int startRow, int endRow, int n_num);

	public int novelCount(int m_num);	//한 사람의 소설 개수 가져오기

	public List<NovelHomeDto> novelListMember(int startRow, int endRow, int m_num);	//한 사람의 소설 내용 가져오기

}
