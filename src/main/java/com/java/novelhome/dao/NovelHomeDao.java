package com.java.novelhome.dao;

import java.util.List;

import com.java.novelcategory.dto.NovelCategoryDto;
import com.java.novelhome.dto.NovelHomeDto;
import com.java.novelpost.dto.NovelPostDto;

public interface NovelHomeDao {

	public int novelHomeUpload(NovelHomeDto novelHomeDto);

	public NovelHomeDto novelHomeList(int n_num);

	public int novelHomeSelectGetNum(int m_num);

	public int getCount(int n_num);

	public List<NovelPostDto> novelPostList(int startRow, int endRow, int n_num);

	public int novelCount(int m_num);

	public List<NovelHomeDto> novelListMember(int startRow, int endRow, int m_num);

	public String getNickname(int n_num);

	public int novelCategoryAdd(NovelCategoryDto novelCategoryDto);

	public int getCategoryId(int n_num);

	public int getAllViewCount(int n_num);
	
	public int novelFirstView(int n_num);

	public int postDelete(int n_num);

	public int homeDelete(int n_num);

	public int getAllPostCount(int n_num);
	// ----------------- index

	public int getAllCount();

	public List<NovelHomeDto> novelHomeList(int startRow, int endRow);

	public int getTitleSearchCount(String keyword);

	public List<NovelHomeDto> titleSearchList(int startRow, int endRow, String keyword);

	public int getWriterSearchCount(String keyword);

	public List<NovelHomeDto> writerSearchList(int startRow, int endRow, String keyword);

	public List<NovelHomeDto> novelViewCountList(int startRow, int endRow);

	public int getCategoryCount(String category);

	public List<NovelHomeDto> getCategoryList(int startRow, int endRow, String category);

	public int getAllCommentCount(int n_num);

	public String getCategoryName(int c_category_id);

	

	

}
