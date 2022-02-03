package com.java.manager.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.category.dto.CategoryDto;

import java.util.List;

@Component
public class ManagerDaoImp implements ManagerDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int categoryInsert(CategoryDto categoryDto) {
		return sqlSessionTemplate.insert("categoryInsert", categoryDto);
	}
	
	@Override
	public int getCategoryId() {
		return sqlSessionTemplate.selectOne("categoryId");
	}

	@Override
	public List<CategoryDto> getCategoryList() {
		return sqlSessionTemplate.selectList("categoryList");
	}


}
