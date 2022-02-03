package com.java.novelhome.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.novelhome.dto.NovelHomeDto;
import com.java.novelpost.dto.NovelPostDto;

@Component
public class NovelHomeDaoImp implements NovelHomeDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int novelHomeUpload(NovelHomeDto novelHomeDto) {
		return sqlSessionTemplate.insert("novelhomeInsert", novelHomeDto);
	}
	
	@Override
	public int novelHomeSelectGetNum(int m_num) {
		return sqlSessionTemplate.selectOne("novelhomeSelectGetNum", m_num);
	}
	
	@Override
	public NovelHomeDto novelHomeList(int n_num) {
		NovelHomeDto novelHomeDto = null;

		novelHomeDto = sqlSessionTemplate.selectOne("novelhomeSelect", n_num);
		return novelHomeDto;
	}
	
	@Override
	public int getCount(int n_num) {
		return sqlSessionTemplate.selectOne("novelPostCount", n_num);
	}
	
	@Override
	public List<NovelPostDto> novelPostList(int startRow, int endRow, int n_num) {
		HashMap<String, Integer> hMap = new HashMap<String, Integer>();
		hMap.put("startRow", startRow);
		hMap.put("endRow", endRow);
		hMap.put("n_num", n_num);
		return sqlSessionTemplate.selectList("novelPostList", hMap);
	}
	
	@Override
	public int novelCount(int m_num) {				//한 사람의 소설 개수
		return sqlSessionTemplate.selectOne("novelCount",m_num);
	}
	
	@Override
	public List<NovelHomeDto> novelListMember(int startRow, int endRow, int m_num) {	//한 사람의 소설 리스트
		HashMap<String, Integer> hMap = new HashMap<String, Integer>();
		hMap.put("startRow", startRow);
		hMap.put("endRow", endRow);
		hMap.put("m_num", m_num);
		return sqlSessionTemplate.selectList("novelListMember",hMap);
	}
	
}
