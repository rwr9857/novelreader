package com.java.novelhome.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.categorie.dto.CategorieDto;
import com.java.member.dto.MemberDto;
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
	public int novelHomeCategorie(List<NovelCategorieDto> novelCategorieList) {
		return sqlSessionTemplate.insert("novelCategorieInsert");
	}


}
