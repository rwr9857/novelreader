package com.java.novelpost.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.novelpost.dto.NovelPostDto;

@Component
public class NovelPostDaoImp implements NovelPostDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int novelPostInsert(NovelPostDto novelPostDto) {
		return sqlSessionTemplate.insert("novelPostInsert", novelPostDto);
	}

//	@Override
//	public int novelPostSelect(int n_num) {
//		return sqlSessionTemplate.selectOne("novelPostSelect", n_num);
//	}

	
}
