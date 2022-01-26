package com.java.novelhome.dao;

import com.java.novelhome.dto.NovelHomeDto;

public interface NovelHomeDao {

	public int novelHomeUpload(NovelHomeDto novelHomeDto);

	public NovelHomeDto novelHomeList(int n_num);

	public int novelHomeSelectGetNum(int m_num);



}
