package com.java.novelpost.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.aop.LogAspect;
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

}
