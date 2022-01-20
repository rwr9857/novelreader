package com.java.novelhome.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.novelcategorie.dto.NovelCategorieDto;
import com.java.novelhome.dto.NovelHomeDto;
@Component
public class NovelHomeDaoImp implements NovelHomeDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int novelHomeUpload(NovelHomeDto novelHomeDto) {
		return sqlSessionTemplate.insert("novelhomeInsert");
	}
	

	@Override
	public int novelHomeCategorie(NovelCategorieDto novelCategorieDto) {
		return sqlSessionTemplate.insert("novelCategorieInsert");
	}
}
