package com.java.novelpost.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.aop.LogAspect;
import com.java.comment.dto.CommentDto;
import com.java.novelhome.dto.NovelHomeDto;
import com.java.novelpost.dto.NovelPostDto;

@Component
public class NovelPostDaoImp implements NovelPostDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int novelPostInsert(NovelPostDto novelPostDto) {
		return sqlSessionTemplate.insert("novelPostInsert", novelPostDto);
	}

	@Override
	public NovelPostDto read(int n_post_num) {
		NovelPostDto novelPostDto = null;

		int check = sqlSessionTemplate.update("novelPostReadCount",n_post_num);
		LogAspect.logger.info(LogAspect.LogMsg + check);

		novelPostDto = sqlSessionTemplate.selectOne("novelPostRead", n_post_num);

		return novelPostDto;
	}

	@Override
	public int nPostNumSelect(int n_num) {
		return sqlSessionTemplate.selectOne("novelPostNumSelect", n_num);
	}

	@Override
	public int delete(int n_post_num) {
		return sqlSessionTemplate.delete("novelPostDelete", n_post_num);
	}

	@Override
	public NovelPostDto novelPostSelect(int n_post_num) {
		return sqlSessionTemplate.selectOne("novelPostSelect", n_post_num);
	}

	@Override
	public int novelPostUpdate(NovelPostDto novelPostDto) {
		return sqlSessionTemplate.update("novelPostUpdate", novelPostDto);
	}

	@Override
	public int nNumSelect(int n_post_num) {
		return sqlSessionTemplate.selectOne("nNumSelect", n_post_num);
	}
	
	@Override
	public int mNumSelect(int n_num) {
		return sqlSessionTemplate.selectOne("mNumSelect", n_num);
	}

	@Override
	public int getCount(int n_post_num) {
		return sqlSessionTemplate.selectOne("getCount", n_post_num);
	}

	@Override
	public List<CommentDto> commentList(int startRow, int endRow, int n_post_num) {
		HashMap<String, Integer> hMap = new HashMap<String, Integer>();
		hMap.put("startRow", startRow);
		hMap.put("endRow", endRow);
		hMap.put("n_post_num", n_post_num);
		return sqlSessionTemplate.selectList("commentList", hMap);
	}

	@Override
	public int novelPostCommentInsert(CommentDto commentDto) {
		return sqlSessionTemplate.insert("novelPostCommentInsert", commentDto);
	}

	@Override
	public int novelPostCommentDelete(int comment_num) {
		return sqlSessionTemplate.delete("novelPostCommentDelete", comment_num);
	}

	@Override
	public int commentAllCount(int n_post_num) {
		return sqlSessionTemplate.selectOne("commentAllCount", n_post_num);
	}

}
