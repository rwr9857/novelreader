package com.java.novelpost.dao;

import com.java.novelpost.dto.NovelPostDto;

public interface NovelPostDao {

	public int novelPostInsert(NovelPostDto novelPostDto);

	public NovelPostDto read(int n_post_num);

	public int nPostNumSelect(int n_num);

//	public int novelPostSelect(int n_num);

}
