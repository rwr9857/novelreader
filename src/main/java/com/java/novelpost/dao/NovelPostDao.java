package com.java.novelpost.dao;

import java.util.List;

import com.java.novelpost.dto.NovelPostDto;

public interface NovelPostDao {

	public int getCount();

	public List<NovelPostDto> novelPostList(int startRow, int endRow);

	public int novelPostInsert(NovelPostDto novelPostDto);

}
