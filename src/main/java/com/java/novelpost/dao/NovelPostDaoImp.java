package com.java.novelpost.dao;

import java.util.HashMap;
import java.util.List;

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

	
}
