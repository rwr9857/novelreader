package com.java.novelpost.dao;

import java.util.List;

import com.java.comment.dto.CommentDto;
import com.java.novelpost.dto.NovelPostDto;

public interface NovelPostDao {

	public int novelPostInsert(NovelPostDto novelPostDto);

	public NovelPostDto read(int n_post_num);

	public int nPostNumSelect(int n_num);

	public int delete(int n_post_num);

	public NovelPostDto novelPostSelect(int n_post_num);

	public int novelPostUpdate(NovelPostDto novelPostDto);

	public int nNumSelect(int n_post_num);

	public int mNumSelect(int n_num);

	public int getCount(int n_post_num);

	public List<CommentDto> commentList(int startRow, int endRow, int n_post_num);

	public int novelPostCommentInsert(CommentDto commentDto);

	public int novelPostCommentDelete(int comment_num);

	public int commentAllCount(int n_post_num);

}
