package com.java.manager.dao;

import com.java.category.dto.CategoryDto;

import java.util.List;

public interface ManagerDao {
	public int categoryInsert(CategoryDto categoryDto);
	
	public int getCategoryId();

	public List<CategoryDto> getCategoryList();
}
